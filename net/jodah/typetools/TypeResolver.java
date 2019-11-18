package net.jodah.typetools;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import sun.misc.Unsafe;

public final class TypeResolver {
   private static final Map TYPE_VARIABLE_CACHE = Collections.synchronizedMap(new WeakHashMap());
   private static volatile boolean CACHE_ENABLED = true;
   private static boolean RESOLVES_LAMBDAS;
   private static Method GET_CONSTANT_POOL;
   private static Method GET_CONSTANT_POOL_SIZE;
   private static Method GET_CONSTANT_POOL_METHOD_AT;
   private static final Map OBJECT_METHODS = new HashMap();
   private static final Map PRIMITIVE_WRAPPERS;
   private static final Double JAVA_VERSION = Double.parseDouble(System.getProperty("java.specification.version", "0"));

   private TypeResolver() {
   }

   public static void enableCache() {
      CACHE_ENABLED = true;
   }

   public static void disableCache() {
      TYPE_VARIABLE_CACHE.clear();
      CACHE_ENABLED = false;
   }

   public static Class resolveRawArgument(Class type, Class subType) {
      return resolveRawArgument(resolveGenericType(type, subType), subType);
   }

   public static Class resolveRawArgument(Type genericType, Class subType) {
      Class[] arguments = resolveRawArguments(genericType, subType);
      if (arguments == null) {
         return TypeResolver$Unknown.class;
      } else if (arguments.length != 1) {
         throw new IllegalArgumentException("Expected 1 argument for generic type " + genericType + " but found " + arguments.length);
      } else {
         return arguments[0];
      }
   }

   public static Class[] resolveRawArguments(Class type, Class subType) {
      return resolveRawArguments(resolveGenericType(type, subType), subType);
   }

   public static Class[] resolveRawArguments(Type genericType, Class subType) {
      Class[] result = null;
      Class functionalInterface = null;
      if (RESOLVES_LAMBDAS && subType.isSynthetic()) {
         Class fi = genericType instanceof ParameterizedType && ((ParameterizedType)genericType).getRawType() instanceof Class ? (Class)((ParameterizedType)genericType).getRawType() : (genericType instanceof Class ? (Class)genericType : null);
         if (fi != null && fi.isInterface()) {
            functionalInterface = fi;
         }
      }

      if (genericType instanceof ParameterizedType) {
         ParameterizedType paramType = (ParameterizedType)genericType;
         Type[] arguments = paramType.getActualTypeArguments();
         result = new Class[arguments.length];

         for(int i = 0; i < arguments.length; ++i) {
            result[i] = resolveRawClass(arguments[i], subType, functionalInterface);
         }
      } else if (genericType instanceof TypeVariable) {
         result = new Class[]{resolveRawClass(genericType, subType, functionalInterface)};
      } else if (genericType instanceof Class) {
         TypeVariable[] typeParams = ((Class)genericType).getTypeParameters();
         result = new Class[typeParams.length];

         for(int i = 0; i < typeParams.length; ++i) {
            result[i] = resolveRawClass(typeParams[i], subType, functionalInterface);
         }
      }

      return result;
   }

   public static Type resolveGenericType(Class type, Type subType) {
      Class rawType;
      if (subType instanceof ParameterizedType) {
         rawType = (Class)((ParameterizedType)subType).getRawType();
      } else {
         rawType = (Class)subType;
      }

      if (type.equals(rawType)) {
         return subType;
      } else {
         Type result;
         if (type.isInterface()) {
            Type[] var4 = rawType.getGenericInterfaces();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               Type superInterface = var4[var6];
               if (superInterface != null && !superInterface.equals(Object.class) && (result = resolveGenericType(type, superInterface)) != null) {
                  return result;
               }
            }
         }

         Type superClass = rawType.getGenericSuperclass();
         return superClass != null && !superClass.equals(Object.class) && (result = resolveGenericType(type, superClass)) != null ? result : null;
      }
   }

   public static Class resolveRawClass(Type genericType, Class subType) {
      return resolveRawClass(genericType, subType, (Class)null);
   }

   private static Class resolveRawClass(Type genericType, Class subType, Class functionalInterface) {
      if (genericType instanceof Class) {
         return (Class)genericType;
      } else if (genericType instanceof ParameterizedType) {
         return resolveRawClass(((ParameterizedType)genericType).getRawType(), subType, functionalInterface);
      } else if (genericType instanceof GenericArrayType) {
         GenericArrayType arrayType = (GenericArrayType)genericType;
         Class component = resolveRawClass(arrayType.getGenericComponentType(), subType, functionalInterface);
         return Array.newInstance(component, 0).getClass();
      } else {
         if (genericType instanceof TypeVariable) {
            TypeVariable variable = (TypeVariable)genericType;
            Type genericType = (Type)getTypeVariableMap(subType, functionalInterface).get(variable);
            genericType = genericType == null ? resolveBound(variable) : resolveRawClass(genericType, subType, functionalInterface);
         }

         return genericType instanceof Class ? (Class)genericType : TypeResolver$Unknown.class;
      }
   }

   private static Map getTypeVariableMap(Class targetType, Class functionalInterface) {
      Reference ref = (Reference)TYPE_VARIABLE_CACHE.get(targetType);
      Map map = ref != null ? (Map)ref.get() : null;
      if (map == null) {
         map = new HashMap();
         if (functionalInterface != null) {
            populateLambdaArgs(functionalInterface, targetType, (Map)map);
         }

         populateSuperTypeArgs(targetType.getGenericInterfaces(), (Map)map, functionalInterface != null);
         Type genericType = targetType.getGenericSuperclass();

         Class type;
         for(type = targetType.getSuperclass(); type != null && !Object.class.equals(type); type = type.getSuperclass()) {
            if (genericType instanceof ParameterizedType) {
               populateTypeArgs((ParameterizedType)genericType, (Map)map, false);
            }

            populateSuperTypeArgs(type.getGenericInterfaces(), (Map)map, false);
            genericType = type.getGenericSuperclass();
         }

         for(type = targetType; type.isMemberClass(); type = type.getEnclosingClass()) {
            genericType = type.getGenericSuperclass();
            if (genericType instanceof ParameterizedType) {
               populateTypeArgs((ParameterizedType)genericType, (Map)map, functionalInterface != null);
            }
         }

         if (CACHE_ENABLED) {
            TYPE_VARIABLE_CACHE.put(targetType, new WeakReference(map));
         }
      }

      return (Map)map;
   }

   private static void populateSuperTypeArgs(Type[] types, Map map, boolean depthFirst) {
      Type[] var3 = types;
      int var4 = types.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Type type = var3[var5];
         if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            if (!depthFirst) {
               populateTypeArgs(parameterizedType, map, depthFirst);
            }

            Type rawType = parameterizedType.getRawType();
            if (rawType instanceof Class) {
               populateSuperTypeArgs(((Class)rawType).getGenericInterfaces(), map, depthFirst);
            }

            if (depthFirst) {
               populateTypeArgs(parameterizedType, map, depthFirst);
            }
         } else if (type instanceof Class) {
            populateSuperTypeArgs(((Class)type).getGenericInterfaces(), map, depthFirst);
         }
      }

   }

   private static void populateTypeArgs(ParameterizedType type, Map map, boolean depthFirst) {
      if (type.getRawType() instanceof Class) {
         TypeVariable[] typeVariables = ((Class)type.getRawType()).getTypeParameters();
         Type[] typeArguments = type.getActualTypeArguments();
         if (type.getOwnerType() != null) {
            Type owner = type.getOwnerType();
            if (owner instanceof ParameterizedType) {
               populateTypeArgs((ParameterizedType)owner, map, depthFirst);
            }
         }

         for(int i = 0; i < typeArguments.length; ++i) {
            TypeVariable variable = typeVariables[i];
            Type typeArgument = typeArguments[i];
            if (typeArgument instanceof Class) {
               map.put(variable, typeArgument);
            } else if (typeArgument instanceof GenericArrayType) {
               map.put(variable, typeArgument);
            } else if (typeArgument instanceof ParameterizedType) {
               map.put(variable, typeArgument);
            } else if (typeArgument instanceof TypeVariable) {
               TypeVariable typeVariableArgument = (TypeVariable)typeArgument;
               Type resolvedType;
               if (depthFirst) {
                  resolvedType = (Type)map.get(variable);
                  if (resolvedType != null) {
                     map.put(typeVariableArgument, resolvedType);
                     continue;
                  }
               }

               resolvedType = (Type)map.get(typeVariableArgument);
               if (resolvedType == null) {
                  resolvedType = resolveBound(typeVariableArgument);
               }

               map.put(variable, resolvedType);
            }
         }
      }

   }

   public static Type resolveBound(TypeVariable typeVariable) {
      Type[] bounds = typeVariable.getBounds();
      if (bounds.length == 0) {
         return TypeResolver$Unknown.class;
      } else {
         Type bound = bounds[0];
         if (bound instanceof TypeVariable) {
            bound = resolveBound((TypeVariable)bound);
         }

         return (Type)(bound == Object.class ? TypeResolver$Unknown.class : bound);
      }
   }

   private static void populateLambdaArgs(Class functionalInterface, Class lambdaType, Map map) {
      if (RESOLVES_LAMBDAS) {
         Method[] var3 = functionalInterface.getMethods();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Method m = var3[var5];
            if (!isDefaultMethod(m) && !Modifier.isStatic(m.getModifiers()) && !m.isBridge()) {
               Method objectMethod = (Method)OBJECT_METHODS.get(m.getName());
               if (objectMethod == null || !Arrays.equals(m.getTypeParameters(), objectMethod.getTypeParameters())) {
                  Type returnTypeVar = m.getGenericReturnType();
                  Type[] paramTypeVars = m.getGenericParameterTypes();
                  Member member = getMemberRef(lambdaType);
                  if (member == null) {
                     return;
                  }

                  if (returnTypeVar instanceof TypeVariable) {
                     Class returnType = member instanceof Method ? ((Method)member).getReturnType() : ((Constructor)member).getDeclaringClass();
                     returnType = wrapPrimitives(returnType);
                     if (!returnType.equals(Void.class)) {
                        map.put((TypeVariable)returnTypeVar, returnType);
                     }
                  }

                  Class[] arguments = member instanceof Method ? ((Method)member).getParameterTypes() : ((Constructor)member).getParameterTypes();
                  int paramOffset = 0;
                  if (paramTypeVars.length > 0 && paramTypeVars[0] instanceof TypeVariable && paramTypeVars.length == arguments.length + 1) {
                     Class instanceType = member.getDeclaringClass();
                     map.put((TypeVariable)paramTypeVars[0], instanceType);
                     paramOffset = 1;
                  }

                  int argOffset = 0;
                  if (paramTypeVars.length < arguments.length) {
                     argOffset = arguments.length - paramTypeVars.length;
                  }

                  for(int i = 0; i + argOffset < arguments.length; ++i) {
                     if (paramTypeVars[i] instanceof TypeVariable) {
                        map.put((TypeVariable)paramTypeVars[i + paramOffset], wrapPrimitives(arguments[i + argOffset]));
                     }
                  }

                  return;
               }
            }
         }
      }

   }

   private static boolean isDefaultMethod(Method m) {
      return JAVA_VERSION >= 1.8D && m.isDefault();
   }

   private static Member getMemberRef(Class type) {
      Object constantPool;
      try {
         constantPool = GET_CONSTANT_POOL.invoke(type);
      } catch (Exception var5) {
         return null;
      }

      Member result = null;

      for(int i = getConstantPoolSize(constantPool) - 1; i >= 0; --i) {
         Member member = getConstantPoolMethodAt(constantPool, i);
         if (member != null && (!(member instanceof Constructor) || !member.getDeclaringClass().getName().equals("java.lang.invoke.SerializedLambda")) && !member.getDeclaringClass().isAssignableFrom(type)) {
            result = member;
            if (!(member instanceof Method) || !isAutoBoxingMethod((Method)member)) {
               break;
            }
         }
      }

      return result;
   }

   private static boolean isAutoBoxingMethod(Method method) {
      Class[] parameters = method.getParameterTypes();
      return method.getName().equals("valueOf") && parameters.length == 1 && parameters[0].isPrimitive() && wrapPrimitives(parameters[0]).equals(method.getDeclaringClass());
   }

   private static Class wrapPrimitives(Class clazz) {
      return clazz.isPrimitive() ? (Class)PRIMITIVE_WRAPPERS.get(clazz) : clazz;
   }

   private static int getConstantPoolSize(Object constantPool) {
      int var10000;
      try {
         var10000 = (Integer)GET_CONSTANT_POOL_SIZE.invoke(constantPool);
      } catch (Exception var2) {
         return 0;
      }

      return var10000;
   }

   private static Member getConstantPoolMethodAt(Object constantPool, int i) {
      Member var10000;
      try {
         var10000 = (Member)GET_CONSTANT_POOL_METHOD_AT.invoke(constantPool, i);
      } catch (Exception var3) {
         return null;
      }

      return var10000;
   }

   static {
      try {
         Unsafe unsafe = (Unsafe)AccessController.doPrivileged(new TypeResolver$1());
         GET_CONSTANT_POOL = Class.class.getDeclaredMethod("getConstantPool");
         String constantPoolName = JAVA_VERSION < 9.0D ? "sun.reflect.ConstantPool" : "jdk.internal.reflect.ConstantPool";
         Class constantPoolClass = Class.forName(constantPoolName);
         GET_CONSTANT_POOL_SIZE = constantPoolClass.getDeclaredMethod("getSize");
         GET_CONSTANT_POOL_METHOD_AT = constantPoolClass.getDeclaredMethod("getMethodAt", Integer.TYPE);
         Field overrideField = AccessibleObject.class.getDeclaredField("override");
         long overrideFieldOffset = unsafe.objectFieldOffset(overrideField);
         unsafe.putBoolean(GET_CONSTANT_POOL, overrideFieldOffset, true);
         unsafe.putBoolean(GET_CONSTANT_POOL_SIZE, overrideFieldOffset, true);
         unsafe.putBoolean(GET_CONSTANT_POOL_METHOD_AT, overrideFieldOffset, true);
         Object constantPool = GET_CONSTANT_POOL.invoke(Object.class);
         GET_CONSTANT_POOL_SIZE.invoke(constantPool);
         Method[] var7 = Object.class.getDeclaredMethods();
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            Method method = var7[var9];
            OBJECT_METHODS.put(method.getName(), method);
         }

         RESOLVES_LAMBDAS = true;
      } catch (Exception var11) {
      }

      Map types = new HashMap();
      types.put(Boolean.TYPE, Boolean.class);
      types.put(Byte.TYPE, Byte.class);
      types.put(Character.TYPE, Character.class);
      types.put(Double.TYPE, Double.class);
      types.put(Float.TYPE, Float.class);
      types.put(Integer.TYPE, Integer.class);
      types.put(Long.TYPE, Long.class);
      types.put(Short.TYPE, Short.class);
      types.put(Void.TYPE, Void.class);
      PRIMITIVE_WRAPPERS = Collections.unmodifiableMap(types);
   }
}

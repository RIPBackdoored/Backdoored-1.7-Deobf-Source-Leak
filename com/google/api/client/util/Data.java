package com.google.api.client.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Data {
   public static final Boolean NULL_BOOLEAN = new Boolean(true);
   public static final String NULL_STRING = new String();
   public static final Character NULL_CHARACTER = new Character('\u0000');
   public static final Byte NULL_BYTE = new Byte((byte)0);
   public static final Short NULL_SHORT = new Short((short)0);
   public static final Integer NULL_INTEGER = new Integer(0);
   public static final Float NULL_FLOAT = new Float(0.0F);
   public static final Long NULL_LONG = new Long(0L);
   public static final Double NULL_DOUBLE = new Double(0.0D);
   public static final BigInteger NULL_BIG_INTEGER = new BigInteger("0");
   public static final BigDecimal NULL_BIG_DECIMAL = new BigDecimal("0");
   public static final DateTime NULL_DATE_TIME = new DateTime(0L);
   private static final ConcurrentHashMap NULL_CACHE = new ConcurrentHashMap();

   public static Object nullOf(Class objClass) {
      Object result = NULL_CACHE.get(objClass);
      if (result == null) {
         synchronized(NULL_CACHE) {
            result = NULL_CACHE.get(objClass);
            if (result == null) {
               if (objClass.isArray()) {
                  int dims = 0;
                  Class componentType = objClass;

                  do {
                     componentType = componentType.getComponentType();
                     ++dims;
                  } while(componentType.isArray());

                  result = Array.newInstance(componentType, new int[dims]);
               } else if (objClass.isEnum()) {
                  FieldInfo fieldInfo = ClassInfo.of(objClass).getFieldInfo((String)null);
                  Preconditions.checkNotNull(fieldInfo, "enum missing constant with @NullValue annotation: %s", objClass);
                  Enum e = fieldInfo.enumValue();
                  result = e;
               } else {
                  result = Types.newInstance(objClass);
               }

               NULL_CACHE.put(objClass, result);
            }
         }
      }

      return result;
   }

   public static boolean isNull(Object object) {
      return object != null && object == NULL_CACHE.get(object.getClass());
   }

   public static Map mapOf(Object data) {
      if (data != null && !isNull(data)) {
         if (data instanceof Map) {
            Map result = (Map)data;
            return result;
         } else {
            Map result = new DataMap(data, false);
            return result;
         }
      } else {
         return Collections.emptyMap();
      }
   }

   public static Object clone(Object data) {
      if (data != null && !isPrimitive(data.getClass())) {
         if (data instanceof GenericData) {
            return ((GenericData)data).clone();
         } else {
            Class dataClass = data.getClass();
            Object copy;
            if (dataClass.isArray()) {
               copy = Array.newInstance(dataClass.getComponentType(), Array.getLength(data));
            } else if (data instanceof ArrayMap) {
               copy = ((ArrayMap)data).clone();
            } else {
               if ("java.util.Arrays$ArrayList".equals(dataClass.getName())) {
                  Object[] arrayCopy = ((List)data).toArray();
                  deepCopy(arrayCopy, arrayCopy);
                  Object copy = Arrays.asList(arrayCopy);
                  return copy;
               }

               copy = Types.newInstance(dataClass);
            }

            deepCopy(data, copy);
            return copy;
         }
      } else {
         return data;
      }
   }

   public static void deepCopy(Object src, Object dest) {
      Class srcClass = src.getClass();
      Preconditions.checkArgument(srcClass == dest.getClass());
      if (srcClass.isArray()) {
         Preconditions.checkArgument(Array.getLength(src) == Array.getLength(dest));
         int index = 0;
         Iterator var4 = Types.iterableOf(src).iterator();

         while(var4.hasNext()) {
            Object value = var4.next();
            Array.set(dest, index++, clone(value));
         }
      } else {
         Iterator var14;
         if (Collection.class.isAssignableFrom(srcClass)) {
            Collection srcCollection = (Collection)src;
            if (ArrayList.class.isAssignableFrom(srcClass)) {
               ArrayList destArrayList = (ArrayList)dest;
               destArrayList.ensureCapacity(srcCollection.size());
            }

            Collection destCollection = (Collection)dest;
            var14 = srcCollection.iterator();

            while(var14.hasNext()) {
               Object srcValue = var14.next();
               destCollection.add(clone(srcValue));
            }
         } else {
            boolean isGenericData = GenericData.class.isAssignableFrom(srcClass);
            Object srcValue;
            if (!isGenericData && Map.class.isAssignableFrom(srcClass)) {
               if (ArrayMap.class.isAssignableFrom(srcClass)) {
                  ArrayMap destMap = (ArrayMap)dest;
                  ArrayMap srcMap = (ArrayMap)src;
                  int size = srcMap.size();

                  for(int i = 0; i < size; ++i) {
                     srcValue = srcMap.getValue(i);
                     destMap.set(i, clone(srcValue));
                  }
               } else {
                  Map destMap = (Map)dest;
                  Map srcMap = (Map)src;
                  Iterator var21 = srcMap.entrySet().iterator();

                  while(var21.hasNext()) {
                     Entry srcEntry = (Entry)var21.next();
                     destMap.put(srcEntry.getKey(), clone(srcEntry.getValue()));
                  }
               }
            } else {
               ClassInfo classInfo = isGenericData ? ((GenericData)src).classInfo : ClassInfo.of(srcClass);
               var14 = classInfo.names.iterator();

               while(true) {
                  FieldInfo fieldInfo;
                  do {
                     do {
                        if (!var14.hasNext()) {
                           return;
                        }

                        String fieldName = (String)var14.next();
                        fieldInfo = classInfo.getFieldInfo(fieldName);
                     } while(fieldInfo.isFinal());
                  } while(isGenericData && fieldInfo.isPrimitive());

                  srcValue = fieldInfo.getValue(src);
                  if (srcValue != null) {
                     fieldInfo.setValue(dest, clone(srcValue));
                  }
               }
            }
         }
      }

   }

   public static boolean isPrimitive(Type type) {
      if (type instanceof WildcardType) {
         type = Types.getBound((WildcardType)type);
      }

      if (!(type instanceof Class)) {
         return false;
      } else {
         Class typeClass = (Class)type;
         return typeClass.isPrimitive() || typeClass == Character.class || typeClass == String.class || typeClass == Integer.class || typeClass == Long.class || typeClass == Short.class || typeClass == Byte.class || typeClass == Float.class || typeClass == Double.class || typeClass == BigInteger.class || typeClass == BigDecimal.class || typeClass == DateTime.class || typeClass == Boolean.class;
      }
   }

   public static boolean isValueOfPrimitiveType(Object fieldValue) {
      return fieldValue == null || isPrimitive(fieldValue.getClass());
   }

   public static Object parsePrimitiveValue(Type type, String stringValue) {
      Class primitiveClass = type instanceof Class ? (Class)type : null;
      if (type == null || primitiveClass != null) {
         if (primitiveClass == Void.class) {
            return null;
         }

         if (stringValue == null || primitiveClass == null || primitiveClass.isAssignableFrom(String.class)) {
            return stringValue;
         }

         if (primitiveClass == Character.class || primitiveClass == Character.TYPE) {
            if (stringValue.length() != 1) {
               throw new IllegalArgumentException("expected type Character/char but got " + primitiveClass);
            }

            return stringValue.charAt(0);
         }

         if (primitiveClass == Boolean.class || primitiveClass == Boolean.TYPE) {
            return Boolean.valueOf(stringValue);
         }

         if (primitiveClass == Byte.class || primitiveClass == Byte.TYPE) {
            return Byte.valueOf(stringValue);
         }

         if (primitiveClass == Short.class || primitiveClass == Short.TYPE) {
            return Short.valueOf(stringValue);
         }

         if (primitiveClass == Integer.class || primitiveClass == Integer.TYPE) {
            return Integer.valueOf(stringValue);
         }

         if (primitiveClass == Long.class || primitiveClass == Long.TYPE) {
            return Long.valueOf(stringValue);
         }

         if (primitiveClass == Float.class || primitiveClass == Float.TYPE) {
            return Float.valueOf(stringValue);
         }

         if (primitiveClass == Double.class || primitiveClass == Double.TYPE) {
            return Double.valueOf(stringValue);
         }

         if (primitiveClass == DateTime.class) {
            return DateTime.parseRfc3339(stringValue);
         }

         if (primitiveClass == BigInteger.class) {
            return new BigInteger(stringValue);
         }

         if (primitiveClass == BigDecimal.class) {
            return new BigDecimal(stringValue);
         }

         if (primitiveClass.isEnum()) {
            Enum result = ClassInfo.of(primitiveClass).getFieldInfo(stringValue).enumValue();
            return result;
         }
      }

      throw new IllegalArgumentException("expected primitive class, but got: " + type);
   }

   public static Collection newCollectionInstance(Type type) {
      if (type instanceof WildcardType) {
         type = Types.getBound((WildcardType)type);
      }

      if (type instanceof ParameterizedType) {
         type = ((ParameterizedType)type).getRawType();
      }

      Class collectionClass = type instanceof Class ? (Class)type : null;
      if (type != null && !(type instanceof GenericArrayType) && (collectionClass == null || !collectionClass.isArray() && !collectionClass.isAssignableFrom(ArrayList.class))) {
         if (collectionClass == null) {
            throw new IllegalArgumentException("unable to create new instance of type: " + type);
         } else if (collectionClass.isAssignableFrom(HashSet.class)) {
            return new HashSet();
         } else if (collectionClass.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
         } else {
            Collection result = (Collection)Types.newInstance(collectionClass);
            return result;
         }
      } else {
         return new ArrayList();
      }
   }

   public static Map newMapInstance(Class mapClass) {
      if (mapClass != null && !mapClass.isAssignableFrom(ArrayMap.class)) {
         if (mapClass.isAssignableFrom(TreeMap.class)) {
            return new TreeMap();
         } else {
            Map result = (Map)Types.newInstance(mapClass);
            return result;
         }
      } else {
         return ArrayMap.create();
      }
   }

   public static Type resolveWildcardTypeOrTypeVariable(List context, Type type) {
      if (type instanceof WildcardType) {
         type = Types.getBound((WildcardType)type);
      }

      while(type instanceof TypeVariable) {
         Type resolved = Types.resolveTypeVariable(context, (TypeVariable)type);
         if (resolved != null) {
            type = resolved;
         }

         if (type instanceof TypeVariable) {
            type = ((TypeVariable)type).getBounds()[0];
         }
      }

      return type;
   }

   static {
      NULL_CACHE.put(Boolean.class, NULL_BOOLEAN);
      NULL_CACHE.put(String.class, NULL_STRING);
      NULL_CACHE.put(Character.class, NULL_CHARACTER);
      NULL_CACHE.put(Byte.class, NULL_BYTE);
      NULL_CACHE.put(Short.class, NULL_SHORT);
      NULL_CACHE.put(Integer.class, NULL_INTEGER);
      NULL_CACHE.put(Float.class, NULL_FLOAT);
      NULL_CACHE.put(Long.class, NULL_LONG);
      NULL_CACHE.put(Double.class, NULL_DOUBLE);
      NULL_CACHE.put(BigInteger.class, NULL_BIG_INTEGER);
      NULL_CACHE.put(BigDecimal.class, NULL_BIG_DECIMAL);
      NULL_CACHE.put(DateTime.class, NULL_DATE_TIME);
   }
}

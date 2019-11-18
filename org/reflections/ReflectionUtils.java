package org.reflections;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.Utils;

public abstract class ReflectionUtils {
   public static boolean includeObject = false;
   private static List primitiveNames;
   private static List primitiveTypes;
   private static List primitiveDescriptors;

   public static Set getAllSuperTypes(Class type, Predicate... predicates) {
      Set result = Sets.newLinkedHashSet();
      if (type != null && (includeObject || !type.equals(Object.class))) {
         result.add(type);
         Iterator var3 = getSuperTypes(type).iterator();

         while(var3.hasNext()) {
            Class supertype = (Class)var3.next();
            result.addAll(getAllSuperTypes(supertype));
         }
      }

      return filter((Iterable)result, predicates);
   }

   public static Set getSuperTypes(Class type) {
      Set result = new LinkedHashSet();
      Class superclass = type.getSuperclass();
      Class[] interfaces = type.getInterfaces();
      if (superclass != null && (includeObject || !superclass.equals(Object.class))) {
         result.add(superclass);
      }

      if (interfaces != null && interfaces.length > 0) {
         result.addAll(Arrays.asList(interfaces));
      }

      return result;
   }

   public static Set getAllMethods(Class type, Predicate... predicates) {
      Set result = Sets.newHashSet();
      Iterator var3 = getAllSuperTypes(type).iterator();

      while(var3.hasNext()) {
         Class t = (Class)var3.next();
         result.addAll(getMethods(t, predicates));
      }

      return result;
   }

   public static Set getMethods(Class t, Predicate... predicates) {
      return filter((Object[])(t.isInterface() ? t.getMethods() : t.getDeclaredMethods()), predicates);
   }

   public static Set getAllConstructors(Class type, Predicate... predicates) {
      Set result = Sets.newHashSet();
      Iterator var3 = getAllSuperTypes(type).iterator();

      while(var3.hasNext()) {
         Class t = (Class)var3.next();
         result.addAll(getConstructors(t, predicates));
      }

      return result;
   }

   public static Set getConstructors(Class t, Predicate... predicates) {
      return filter((Object[])t.getDeclaredConstructors(), predicates);
   }

   public static Set getAllFields(Class type, Predicate... predicates) {
      Set result = Sets.newHashSet();
      Iterator var3 = getAllSuperTypes(type).iterator();

      while(var3.hasNext()) {
         Class t = (Class)var3.next();
         result.addAll(getFields(t, predicates));
      }

      return result;
   }

   public static Set getFields(Class type, Predicate... predicates) {
      return filter((Object[])type.getDeclaredFields(), predicates);
   }

   public static Set getAllAnnotations(AnnotatedElement type, Predicate... predicates) {
      Set result = Sets.newHashSet();
      if (type instanceof Class) {
         Iterator var3 = getAllSuperTypes((Class)type).iterator();

         while(var3.hasNext()) {
            Class t = (Class)var3.next();
            result.addAll(getAnnotations(t, predicates));
         }
      } else {
         result.addAll(getAnnotations(type, predicates));
      }

      return result;
   }

   public static Set getAnnotations(AnnotatedElement type, Predicate... predicates) {
      return filter((Object[])type.getDeclaredAnnotations(), predicates);
   }

   public static Set getAll(Set elements, Predicate... predicates) {
      return (Set)(Utils.isEmpty((Object[])predicates) ? elements : Sets.newHashSet(Iterables.filter(elements, Predicates.and(predicates))));
   }

   public static Predicate withName(String name) {
      return new ReflectionUtils$1(name);
   }

   public static Predicate withPrefix(String prefix) {
      return new ReflectionUtils$2(prefix);
   }

   public static Predicate withPattern(String regex) {
      return new ReflectionUtils$3(regex);
   }

   public static Predicate withAnnotation(Class annotation) {
      return new ReflectionUtils$4(annotation);
   }

   public static Predicate withAnnotations(Class... annotations) {
      return new ReflectionUtils$5(annotations);
   }

   public static Predicate withAnnotation(Annotation annotation) {
      return new ReflectionUtils$6(annotation);
   }

   public static Predicate withAnnotations(Annotation... annotations) {
      return new ReflectionUtils$7(annotations);
   }

   public static Predicate withParameters(Class... types) {
      return new ReflectionUtils$8(types);
   }

   public static Predicate withParametersAssignableTo(Class... types) {
      return new ReflectionUtils$9(types);
   }

   public static Predicate withParametersCount(int count) {
      return new ReflectionUtils$10(count);
   }

   public static Predicate withAnyParameterAnnotation(Class annotationClass) {
      return new ReflectionUtils$11(annotationClass);
   }

   public static Predicate withAnyParameterAnnotation(Annotation annotation) {
      return new ReflectionUtils$12(annotation);
   }

   public static Predicate withType(Class type) {
      return new ReflectionUtils$13(type);
   }

   public static Predicate withTypeAssignableTo(Class type) {
      return new ReflectionUtils$14(type);
   }

   public static Predicate withReturnType(Class type) {
      return new ReflectionUtils$15(type);
   }

   public static Predicate withReturnTypeAssignableTo(Class type) {
      return new ReflectionUtils$16(type);
   }

   public static Predicate withModifier(int mod) {
      return new ReflectionUtils$17(mod);
   }

   public static Predicate withClassModifier(int mod) {
      return new ReflectionUtils$18(mod);
   }

   public static Class forName(String typeName, ClassLoader... classLoaders) {
      if (getPrimitiveNames().contains(typeName)) {
         return (Class)getPrimitiveTypes().get(getPrimitiveNames().indexOf(typeName));
      } else {
         String type;
         if (typeName.contains("[")) {
            int i = typeName.indexOf("[");
            type = typeName.substring(0, i);
            String array = typeName.substring(i).replace("]", "");
            if (getPrimitiveNames().contains(type)) {
               type = (String)getPrimitiveDescriptors().get(getPrimitiveNames().indexOf(type));
            } else {
               type = "L" + type + ";";
            }

            type = array + type;
         } else {
            type = typeName;
         }

         List reflectionsExceptions = Lists.newArrayList();
         ClassLoader[] var12 = ClasspathHelper.classLoaders(classLoaders);
         int var5 = var12.length;
         int var6 = 0;

         while(var6 < var5) {
            ClassLoader classLoader = var12[var6];
            Class var10000;
            if (type.contains("[")) {
               label49: {
                  try {
                     var10000 = Class.forName(type, false, classLoader);
                  } catch (Throwable var10) {
                     reflectionsExceptions.add(new ReflectionsException("could not get type for name " + typeName, var10));
                     break label49;
                  }

                  return var10000;
               }
            }

            try {
               var10000 = classLoader.loadClass(type);
            } catch (Throwable var9) {
               reflectionsExceptions.add(new ReflectionsException("could not get type for name " + typeName, var9));
               ++var6;
               continue;
            }

            return var10000;
         }

         if (Reflections.log != null) {
            Iterator var13 = reflectionsExceptions.iterator();

            while(var13.hasNext()) {
               ReflectionsException reflectionsException = (ReflectionsException)var13.next();
               Reflections.log.warn("could not get type for name " + typeName + " from any class loader", reflectionsException);
            }
         }

         return null;
      }
   }

   public static List forNames(Iterable classes, ClassLoader... classLoaders) {
      List result = new ArrayList();
      Iterator var3 = classes.iterator();

      while(var3.hasNext()) {
         String className = (String)var3.next();
         Class type = forName(className, classLoaders);
         if (type != null) {
            result.add(type);
         }
      }

      return result;
   }

   private static Class[] parameterTypes(Member member) {
      return member != null ? (member.getClass() == Method.class ? ((Method)member).getParameterTypes() : (member.getClass() == Constructor.class ? ((Constructor)member).getParameterTypes() : null)) : null;
   }

   private static Set parameterAnnotations(Member member) {
      Set result = Sets.newHashSet();
      Annotation[][] annotations = member instanceof Method ? ((Method)member).getParameterAnnotations() : (member instanceof Constructor ? ((Constructor)member).getParameterAnnotations() : (Annotation[][])null);
      Annotation[][] var3 = annotations;
      int var4 = annotations.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Annotation[] annotation = var3[var5];
         Collections.addAll(result, annotation);
      }

      return result;
   }

   private static Set annotationTypes(Iterable annotations) {
      Set result = Sets.newHashSet();
      Iterator var2 = annotations.iterator();

      while(var2.hasNext()) {
         Annotation annotation = (Annotation)var2.next();
         result.add(annotation.annotationType());
      }

      return result;
   }

   private static Class[] annotationTypes(Annotation[] annotations) {
      Class[] result = new Class[annotations.length];

      for(int i = 0; i < annotations.length; ++i) {
         result[i] = annotations[i].annotationType();
      }

      return result;
   }

   private static void initPrimitives() {
      if (primitiveNames == null) {
         primitiveNames = Lists.newArrayList(new String[]{"boolean", "char", "byte", "short", "int", "long", "float", "double", "void"});
         primitiveTypes = Lists.newArrayList(new Class[]{Boolean.TYPE, Character.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE});
         primitiveDescriptors = Lists.newArrayList(new String[]{"Z", "C", "B", "S", "I", "J", "F", "D", "V"});
      }

   }

   private static List getPrimitiveNames() {
      initPrimitives();
      return primitiveNames;
   }

   private static List getPrimitiveTypes() {
      initPrimitives();
      return primitiveTypes;
   }

   private static List getPrimitiveDescriptors() {
      initPrimitives();
      return primitiveDescriptors;
   }

   static Set filter(Object[] elements, Predicate... predicates) {
      return Utils.isEmpty((Object[])predicates) ? Sets.newHashSet(elements) : Sets.newHashSet(Iterables.filter(Arrays.asList(elements), Predicates.and(predicates)));
   }

   static Set filter(Iterable elements, Predicate... predicates) {
      return Utils.isEmpty((Object[])predicates) ? Sets.newHashSet(elements) : Sets.newHashSet(Iterables.filter(elements, Predicates.and(predicates)));
   }

   private static boolean areAnnotationMembersMatching(Annotation annotation1, Annotation annotation2) {
      if (annotation2 != null && annotation1.annotationType() == annotation2.annotationType()) {
         Method[] var2 = annotation1.annotationType().getDeclaredMethods();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Method method = var2[var4];

            try {
               if (!method.invoke(annotation1).equals(method.invoke(annotation2))) {
                  boolean var10000 = false;
                  return var10000;
               }
            } catch (Exception var7) {
               throw new ReflectionsException(String.format("could not invoke method %s on annotation %s", method.getName(), annotation1.annotationType()), var7);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   // $FF: synthetic method
   static Class[] access$000(Annotation[] x0) {
      return annotationTypes(x0);
   }

   // $FF: synthetic method
   static boolean access$100(Annotation x0, Annotation x1) {
      return areAnnotationMembersMatching(x0, x1);
   }

   // $FF: synthetic method
   static Class[] access$200(Member x0) {
      return parameterTypes(x0);
   }

   // $FF: synthetic method
   static Set access$300(Member x0) {
      return parameterAnnotations(x0);
   }

   // $FF: synthetic method
   static Set access$400(Iterable x0) {
      return annotationTypes(x0);
   }
}

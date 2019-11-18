package org.reflections.adapters;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import org.reflections.ReflectionUtils;
import org.reflections.util.Utils;
import org.reflections.vfs.Vfs$File;

public class JavaReflectionAdapter implements MetadataAdapter {
   public List getFields(Class cls) {
      return Lists.newArrayList(cls.getDeclaredFields());
   }

   public List getMethods(Class cls) {
      List methods = Lists.newArrayList();
      methods.addAll(Arrays.asList(cls.getDeclaredMethods()));
      methods.addAll(Arrays.asList(cls.getDeclaredConstructors()));
      return methods;
   }

   public String getMethodName(Member method) {
      return method instanceof Method ? method.getName() : (method instanceof Constructor ? "<init>" : null);
   }

   public List getParameterNames(Member member) {
      List result = Lists.newArrayList();
      Class[] parameterTypes = member instanceof Method ? ((Method)member).getParameterTypes() : (member instanceof Constructor ? ((Constructor)member).getParameterTypes() : null);
      if (parameterTypes != null) {
         Class[] var4 = parameterTypes;
         int var5 = parameterTypes.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Class paramType = var4[var6];
            String name = getName(paramType);
            result.add(name);
         }
      }

      return result;
   }

   public List getClassAnnotationNames(Class aClass) {
      return this.getAnnotationNames(aClass.getDeclaredAnnotations());
   }

   public List getFieldAnnotationNames(Field field) {
      return this.getAnnotationNames(field.getDeclaredAnnotations());
   }

   public List getMethodAnnotationNames(Member method) {
      Annotation[] annotations = method instanceof Method ? ((Method)method).getDeclaredAnnotations() : (method instanceof Constructor ? ((Constructor)method).getDeclaredAnnotations() : null);
      return this.getAnnotationNames(annotations);
   }

   public List getParameterAnnotationNames(Member method, int parameterIndex) {
      Annotation[][] annotations = method instanceof Method ? ((Method)method).getParameterAnnotations() : (method instanceof Constructor ? ((Constructor)method).getParameterAnnotations() : (Annotation[][])null);
      return this.getAnnotationNames(annotations != null ? annotations[parameterIndex] : null);
   }

   public String getReturnTypeName(Member method) {
      return ((Method)method).getReturnType().getName();
   }

   public String getFieldName(Field field) {
      return field.getName();
   }

   public Class getOfCreateClassObject(Vfs$File file) throws Exception {
      return this.getOfCreateClassObject(file, (ClassLoader[])null);
   }

   public Class getOfCreateClassObject(Vfs$File file, @Nullable ClassLoader... loaders) throws Exception {
      String name = file.getRelativePath().replace("/", ".").replace(".class", "");
      return ReflectionUtils.forName(name, loaders);
   }

   public String getMethodModifier(Member method) {
      return Modifier.toString(method.getModifiers());
   }

   public String getMethodKey(Class cls, Member method) {
      return this.getMethodName(method) + "(" + Joiner.on(", ").join(this.getParameterNames(method)) + ")";
   }

   public String getMethodFullKey(Class cls, Member method) {
      return this.getClassName(cls) + "." + this.getMethodKey(cls, method);
   }

   public boolean isPublic(Object o) {
      Integer mod = o instanceof Class ? ((Class)o).getModifiers() : o instanceof Member ? ((Member)o).getModifiers() : null;
      return mod != null && Modifier.isPublic(mod);
   }

   public String getClassName(Class cls) {
      return cls.getName();
   }

   public String getSuperclassName(Class cls) {
      Class superclass = cls.getSuperclass();
      return superclass != null ? superclass.getName() : "";
   }

   public List getInterfacesNames(Class cls) {
      Class[] classes = cls.getInterfaces();
      List names = new ArrayList(classes != null ? classes.length : 0);
      if (classes != null) {
         Class[] var4 = classes;
         int var5 = classes.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Class cls1 = var4[var6];
            names.add(cls1.getName());
         }
      }

      return names;
   }

   public boolean acceptsInput(String file) {
      return file.endsWith(".class");
   }

   private List getAnnotationNames(Annotation[] annotations) {
      List names = new ArrayList(annotations.length);
      Annotation[] var3 = annotations;
      int var4 = annotations.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Annotation annotation = var3[var5];
         names.add(annotation.annotationType().getName());
      }

      return names;
   }

   public static String getName(Class type) {
      if (type.isArray()) {
         try {
            Class cl = type;

            int dim;
            for(dim = 0; cl.isArray(); cl = cl.getComponentType()) {
               ++dim;
            }

            String var10000 = cl.getName() + Utils.repeat("[]", dim);
            return var10000;
         } catch (Throwable var3) {
            return type.getName();
         }
      } else {
         return type.getName();
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getMethodFullKey(Object var1, Object var2) {
      return this.getMethodFullKey((Class)var1, (Member)var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getMethodKey(Object var1, Object var2) {
      return this.getMethodKey((Class)var1, (Member)var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getMethodModifier(Object var1) {
      return this.getMethodModifier((Member)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object getOfCreateClassObject(Vfs$File var1) throws Exception {
      return this.getOfCreateClassObject(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getFieldName(Object var1) {
      return this.getFieldName((Field)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getReturnTypeName(Object var1) {
      return this.getReturnTypeName((Member)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getParameterAnnotationNames(Object var1, int var2) {
      return this.getParameterAnnotationNames((Member)var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getMethodAnnotationNames(Object var1) {
      return this.getMethodAnnotationNames((Member)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getFieldAnnotationNames(Object var1) {
      return this.getFieldAnnotationNames((Field)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getClassAnnotationNames(Object var1) {
      return this.getClassAnnotationNames((Class)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getParameterNames(Object var1) {
      return this.getParameterNames((Member)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getMethodName(Object var1) {
      return this.getMethodName((Member)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getMethods(Object var1) {
      return this.getMethods((Class)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getFields(Object var1) {
      return this.getFields((Class)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getInterfacesNames(Object var1) {
      return this.getInterfacesNames((Class)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getSuperclassName(Object var1) {
      return this.getSuperclassName((Class)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getClassName(Object var1) {
      return this.getClassName((Class)var1);
   }
}

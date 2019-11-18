package org.reflections.adapters;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.Descriptor;
import javassist.bytecode.Descriptor$Iterator;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.ParameterAnnotationsAttribute;
import javassist.bytecode.annotation.Annotation;
import org.reflections.ReflectionsException;
import org.reflections.util.Utils;
import org.reflections.vfs.Vfs$File;

public class JavassistAdapter implements MetadataAdapter {
   public static boolean includeInvisibleTag = true;

   public List getFields(ClassFile cls) {
      return cls.getFields();
   }

   public List getMethods(ClassFile cls) {
      return cls.getMethods();
   }

   public String getMethodName(MethodInfo method) {
      return method.getName();
   }

   public List getParameterNames(MethodInfo method) {
      String descriptor = method.getDescriptor();
      descriptor = descriptor.substring(descriptor.indexOf("(") + 1, descriptor.lastIndexOf(")"));
      return this.splitDescriptorToTypeNames(descriptor);
   }

   public List getClassAnnotationNames(ClassFile aClass) {
      return this.getAnnotationNames((AnnotationsAttribute)aClass.getAttribute("RuntimeVisibleAnnotations"), includeInvisibleTag ? (AnnotationsAttribute)aClass.getAttribute("RuntimeInvisibleAnnotations") : null);
   }

   public List getFieldAnnotationNames(FieldInfo field) {
      return this.getAnnotationNames((AnnotationsAttribute)field.getAttribute("RuntimeVisibleAnnotations"), includeInvisibleTag ? (AnnotationsAttribute)field.getAttribute("RuntimeInvisibleAnnotations") : null);
   }

   public List getMethodAnnotationNames(MethodInfo method) {
      return this.getAnnotationNames((AnnotationsAttribute)method.getAttribute("RuntimeVisibleAnnotations"), includeInvisibleTag ? (AnnotationsAttribute)method.getAttribute("RuntimeInvisibleAnnotations") : null);
   }

   public List getParameterAnnotationNames(MethodInfo method, int parameterIndex) {
      List result = Lists.newArrayList();
      List parameterAnnotationsAttributes = Lists.newArrayList(new ParameterAnnotationsAttribute[]{(ParameterAnnotationsAttribute)method.getAttribute("RuntimeVisibleParameterAnnotations"), (ParameterAnnotationsAttribute)method.getAttribute("RuntimeInvisibleParameterAnnotations")});
      if (parameterAnnotationsAttributes != null) {
         Iterator var5 = parameterAnnotationsAttributes.iterator();

         while(var5.hasNext()) {
            ParameterAnnotationsAttribute parameterAnnotationsAttribute = (ParameterAnnotationsAttribute)var5.next();
            if (parameterAnnotationsAttribute != null) {
               Annotation[][] annotations = parameterAnnotationsAttribute.getAnnotations();
               if (parameterIndex < annotations.length) {
                  Annotation[] annotation = annotations[parameterIndex];
                  result.addAll(this.getAnnotationNames(annotation));
               }
            }
         }
      }

      return result;
   }

   public String getReturnTypeName(MethodInfo method) {
      String descriptor = method.getDescriptor();
      descriptor = descriptor.substring(descriptor.lastIndexOf(")") + 1);
      return (String)this.splitDescriptorToTypeNames(descriptor).get(0);
   }

   public String getFieldName(FieldInfo field) {
      return field.getName();
   }

   public ClassFile getOfCreateClassObject(Vfs$File file) {
      InputStream inputStream = null;

      ClassFile var4;
      try {
         inputStream = file.openInputStream();
         DataInputStream dis = new DataInputStream(new BufferedInputStream(inputStream));
         var4 = new ClassFile(dis);
      } catch (IOException var8) {
         throw new ReflectionsException("could not create class file from " + file.getName(), var8);
      } finally {
         Utils.close(inputStream);
      }

      return var4;
   }

   public String getMethodModifier(MethodInfo method) {
      int accessFlags = method.getAccessFlags();
      return AccessFlag.isPrivate(accessFlags) ? "private" : (AccessFlag.isProtected(accessFlags) ? "protected" : (this.isPublic(accessFlags) ? "public" : ""));
   }

   public String getMethodKey(ClassFile cls, MethodInfo method) {
      return this.getMethodName(method) + "(" + Joiner.on(", ").join(this.getParameterNames(method)) + ")";
   }

   public String getMethodFullKey(ClassFile cls, MethodInfo method) {
      return this.getClassName(cls) + "." + this.getMethodKey(cls, method);
   }

   public boolean isPublic(Object o) {
      Integer accessFlags = o instanceof ClassFile ? ((ClassFile)o).getAccessFlags() : (o instanceof FieldInfo ? ((FieldInfo)o).getAccessFlags() : o instanceof MethodInfo ? ((MethodInfo)o).getAccessFlags() : null);
      return accessFlags != null && AccessFlag.isPublic(accessFlags);
   }

   public String getClassName(ClassFile cls) {
      return cls.getName();
   }

   public String getSuperclassName(ClassFile cls) {
      return cls.getSuperclass();
   }

   public List getInterfacesNames(ClassFile cls) {
      return Arrays.asList(cls.getInterfaces());
   }

   public boolean acceptsInput(String file) {
      return file.endsWith(".class");
   }

   private List getAnnotationNames(AnnotationsAttribute... annotationsAttributes) {
      List result = Lists.newArrayList();
      if (annotationsAttributes != null) {
         AnnotationsAttribute[] var3 = annotationsAttributes;
         int var4 = annotationsAttributes.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            AnnotationsAttribute annotationsAttribute = var3[var5];
            if (annotationsAttribute != null) {
               Annotation[] var7 = annotationsAttribute.getAnnotations();
               int var8 = var7.length;

               for(int var9 = 0; var9 < var8; ++var9) {
                  Annotation annotation = var7[var9];
                  result.add(annotation.getTypeName());
               }
            }
         }
      }

      return result;
   }

   private List getAnnotationNames(Annotation[] annotations) {
      List result = Lists.newArrayList();
      Annotation[] var3 = annotations;
      int var4 = annotations.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Annotation annotation = var3[var5];
         result.add(annotation.getTypeName());
      }

      return result;
   }

   private List splitDescriptorToTypeNames(String descriptors) {
      List result = Lists.newArrayList();
      if (descriptors != null && descriptors.length() != 0) {
         List indices = Lists.newArrayList();
         Descriptor$Iterator iterator = new Descriptor$Iterator(descriptors);

         while(iterator.hasNext()) {
            indices.add(iterator.next());
         }

         indices.add(descriptors.length());

         for(int i = 0; i < indices.size() - 1; ++i) {
            String s1 = Descriptor.toString(descriptors.substring((Integer)indices.get(i), (Integer)indices.get(i + 1)));
            result.add(s1);
         }
      }

      return result;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getMethodFullKey(Object var1, Object var2) {
      return this.getMethodFullKey((ClassFile)var1, (MethodInfo)var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getMethodKey(Object var1, Object var2) {
      return this.getMethodKey((ClassFile)var1, (MethodInfo)var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getMethodModifier(Object var1) {
      return this.getMethodModifier((MethodInfo)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object getOfCreateClassObject(Vfs$File var1) throws Exception {
      return this.getOfCreateClassObject(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getFieldName(Object var1) {
      return this.getFieldName((FieldInfo)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getReturnTypeName(Object var1) {
      return this.getReturnTypeName((MethodInfo)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getParameterAnnotationNames(Object var1, int var2) {
      return this.getParameterAnnotationNames((MethodInfo)var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getMethodAnnotationNames(Object var1) {
      return this.getMethodAnnotationNames((MethodInfo)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getFieldAnnotationNames(Object var1) {
      return this.getFieldAnnotationNames((FieldInfo)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getClassAnnotationNames(Object var1) {
      return this.getClassAnnotationNames((ClassFile)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getParameterNames(Object var1) {
      return this.getParameterNames((MethodInfo)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getMethodName(Object var1) {
      return this.getMethodName((MethodInfo)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getMethods(Object var1) {
      return this.getMethods((ClassFile)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getFields(Object var1) {
      return this.getFields((ClassFile)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public List getInterfacesNames(Object var1) {
      return this.getInterfacesNames((ClassFile)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getSuperclassName(Object var1) {
      return this.getSuperclassName((ClassFile)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getClassName(Object var1) {
      return this.getClassName((ClassFile)var1);
   }
}

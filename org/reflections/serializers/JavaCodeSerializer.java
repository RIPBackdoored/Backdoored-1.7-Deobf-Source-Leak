package org.reflections.serializers;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.reflections.ReflectionsException;
import org.reflections.scanners.TypeElementsScanner;
import org.reflections.util.Utils;

public class JavaCodeSerializer implements Serializer {
   private static final String pathSeparator = "_";
   private static final String doubleSeparator = "__";
   private static final String dotSeparator = ".";
   private static final String arrayDescriptor = "$$";
   private static final String tokenSeparator = "_";

   public Reflections read(InputStream inputStream) {
      throw new UnsupportedOperationException("read is not implemented on JavaCodeSerializer");
   }

   public File save(Reflections reflections, String name) {
      if (name.endsWith("/")) {
         name = name.substring(0, name.length() - 1);
      }

      String filename = name.replace('.', '/').concat(".java");
      File file = Utils.prepareFile(filename);
      int lastDot = name.lastIndexOf(46);
      String packageName;
      String className;
      if (lastDot == -1) {
         packageName = "";
         className = name.substring(name.lastIndexOf(47) + 1);
      } else {
         packageName = name.substring(name.lastIndexOf(47) + 1, lastDot);
         className = name.substring(lastDot + 1);
      }

      try {
         StringBuilder sb = new StringBuilder();
         sb.append("//generated using Reflections JavaCodeSerializer").append(" [").append(new Date()).append("]").append("\n");
         if (packageName.length() != 0) {
            sb.append("package ").append(packageName).append(";\n");
            sb.append("\n");
         }

         sb.append("public interface ").append(className).append(" {\n\n");
         sb.append(this.toString(reflections));
         sb.append("}\n");
         Files.write(sb.toString(), new File(filename), Charset.defaultCharset());
      } catch (IOException var9) {
         throw new RuntimeException();
      }

      return file;
   }

   public String toString(Reflections reflections) {
      if (reflections.getStore().get(TypeElementsScanner.class.getSimpleName()).isEmpty() && Reflections.log != null) {
         Reflections.log.warn("JavaCodeSerializer needs TypeElementsScanner configured");
      }

      StringBuilder sb = new StringBuilder();
      List prevPaths = Lists.newArrayList();
      int indent = 1;
      List keys = Lists.newArrayList(reflections.getStore().get(TypeElementsScanner.class.getSimpleName()).keySet());
      Collections.sort(keys);

      ArrayList typePaths;
      for(Iterator var6 = keys.iterator(); var6.hasNext(); prevPaths = typePaths) {
         String fqn = (String)var6.next();
         typePaths = Lists.newArrayList(fqn.split("\\."));

         int i;
         for(i = 0; i < Math.min(typePaths.size(), prevPaths.size()) && ((String)typePaths.get(i)).equals(prevPaths.get(i)); ++i) {
         }

         int j;
         for(j = prevPaths.size(); j > i; --j) {
            --indent;
            sb.append(Utils.repeat("\t", indent)).append("}\n");
         }

         for(j = i; j < typePaths.size() - 1; ++j) {
            sb.append(Utils.repeat("\t", indent++)).append("public interface ").append(this.getNonDuplicateName((String)typePaths.get(j), typePaths, j)).append(" {\n");
         }

         String className = (String)typePaths.get(typePaths.size() - 1);
         List annotations = Lists.newArrayList();
         List fields = Lists.newArrayList();
         Multimap methods = Multimaps.newSetMultimap(new HashMap(), new JavaCodeSerializer$1(this));
         Iterator var14 = reflections.getStore().get(TypeElementsScanner.class.getSimpleName(), fqn).iterator();

         String annotation;
         String name;
         String params;
         while(var14.hasNext()) {
            annotation = (String)var14.next();
            if (annotation.startsWith("@")) {
               annotations.add(annotation.substring(1));
            } else if (annotation.contains("(")) {
               if (!annotation.startsWith("<")) {
                  int i1 = annotation.indexOf(40);
                  name = annotation.substring(0, i1);
                  params = annotation.substring(i1 + 1, annotation.indexOf(")"));
                  String paramsDescriptor = "";
                  if (params.length() != 0) {
                     paramsDescriptor = "_" + params.replace(".", "_").replace(", ", "__").replace("[]", "$$");
                  }

                  String normalized = name + paramsDescriptor;
                  methods.put(name, normalized);
               }
            } else if (!Utils.isEmpty(annotation)) {
               fields.add(annotation);
            }
         }

         sb.append(Utils.repeat("\t", indent++)).append("public interface ").append(this.getNonDuplicateName(className, typePaths, typePaths.size() - 1)).append(" {\n");
         if (!fields.isEmpty()) {
            sb.append(Utils.repeat("\t", indent++)).append("public interface fields {\n");
            var14 = fields.iterator();

            while(var14.hasNext()) {
               annotation = (String)var14.next();
               sb.append(Utils.repeat("\t", indent)).append("public interface ").append(this.getNonDuplicateName(annotation, typePaths)).append(" {}\n");
            }

            --indent;
            sb.append(Utils.repeat("\t", indent)).append("}\n");
         }

         String nonDuplicateName;
         if (!methods.isEmpty()) {
            sb.append(Utils.repeat("\t", indent++)).append("public interface methods {\n");
            var14 = methods.entries().iterator();

            while(var14.hasNext()) {
               Entry entry = (Entry)var14.next();
               nonDuplicateName = (String)entry.getKey();
               name = (String)entry.getValue();
               params = methods.get(nonDuplicateName).size() == 1 ? nonDuplicateName : name;
               params = this.getNonDuplicateName(params, fields);
               sb.append(Utils.repeat("\t", indent)).append("public interface ").append(this.getNonDuplicateName(params, typePaths)).append(" {}\n");
            }

            --indent;
            sb.append(Utils.repeat("\t", indent)).append("}\n");
         }

         if (!annotations.isEmpty()) {
            sb.append(Utils.repeat("\t", indent++)).append("public interface annotations {\n");
            var14 = annotations.iterator();

            while(var14.hasNext()) {
               annotation = (String)var14.next();
               nonDuplicateName = this.getNonDuplicateName(annotation, typePaths);
               sb.append(Utils.repeat("\t", indent)).append("public interface ").append(nonDuplicateName).append(" {}\n");
            }

            --indent;
            sb.append(Utils.repeat("\t", indent)).append("}\n");
         }
      }

      for(int j = prevPaths.size(); j >= 1; --j) {
         sb.append(Utils.repeat("\t", j)).append("}\n");
      }

      return sb.toString();
   }

   private String getNonDuplicateName(String candidate, List prev, int offset) {
      String normalized = this.normalize(candidate);

      for(int i = 0; i < offset; ++i) {
         if (normalized.equals(prev.get(i))) {
            return this.getNonDuplicateName(normalized + "_", prev, offset);
         }
      }

      return normalized;
   }

   private String normalize(String candidate) {
      return candidate.replace(".", "_");
   }

   private String getNonDuplicateName(String candidate, List prev) {
      return this.getNonDuplicateName(candidate, prev, prev.size());
   }

   public static Class resolveClassOf(Class element) throws ClassNotFoundException {
      Class cursor = element;

      LinkedList ognl;
      for(ognl = Lists.newLinkedList(); cursor != null; cursor = cursor.getDeclaringClass()) {
         ognl.addFirst(cursor.getSimpleName());
      }

      String classOgnl = Joiner.on(".").join(ognl.subList(1, ognl.size())).replace(".$", "$");
      return Class.forName(classOgnl);
   }

   public static Class resolveClass(Class aClass) {
      Class var10000;
      try {
         var10000 = resolveClassOf(aClass);
      } catch (Exception var2) {
         throw new ReflectionsException("could not resolve to class " + aClass.getName(), var2);
      }

      return var10000;
   }

   public static Field resolveField(Class aField) {
      Field var10000;
      try {
         String name = aField.getSimpleName();
         Class declaringClass = aField.getDeclaringClass().getDeclaringClass();
         var10000 = resolveClassOf(declaringClass).getDeclaredField(name);
      } catch (Exception var3) {
         throw new ReflectionsException("could not resolve to field " + aField.getName(), var3);
      }

      return var10000;
   }

   public static Annotation resolveAnnotation(Class annotation) {
      Annotation var10000;
      try {
         String name = annotation.getSimpleName().replace("_", ".");
         Class declaringClass = annotation.getDeclaringClass().getDeclaringClass();
         Class aClass = resolveClassOf(declaringClass);
         Class aClass1 = ReflectionUtils.forName(name);
         Annotation annotation1 = aClass.getAnnotation(aClass1);
         var10000 = annotation1;
      } catch (Exception var6) {
         throw new ReflectionsException("could not resolve to annotation " + annotation.getName(), var6);
      }

      return var10000;
   }

   public static Method resolveMethod(Class aMethod) {
      String methodOgnl = aMethod.getSimpleName();

      Method var10000;
      try {
         String methodName;
         Class[] paramTypes;
         if (methodOgnl.contains("_")) {
            methodName = methodOgnl.substring(0, methodOgnl.indexOf("_"));
            String[] params = methodOgnl.substring(methodOgnl.indexOf("_") + 1).split("__");
            paramTypes = new Class[params.length];

            for(int i = 0; i < params.length; ++i) {
               String typeName = params[i].replace("$$", "[]").replace("_", ".");
               paramTypes[i] = ReflectionUtils.forName(typeName);
            }
         } else {
            methodName = methodOgnl;
            paramTypes = null;
         }

         Class declaringClass = aMethod.getDeclaringClass().getDeclaringClass();
         var10000 = resolveClassOf(declaringClass).getDeclaredMethod(methodName, paramTypes);
      } catch (Exception var7) {
         throw new ReflectionsException("could not resolve to method " + aMethod.getName(), var7);
      }

      return var10000;
   }
}

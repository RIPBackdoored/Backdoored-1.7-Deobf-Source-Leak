package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.Map.Entry;

public final class ClassInfo {
   private static final Map CACHE = new WeakHashMap();
   private static final Map CACHE_IGNORE_CASE = new WeakHashMap();
   private final Class clazz;
   private final boolean ignoreCase;
   private final IdentityHashMap nameToFieldInfoMap = new IdentityHashMap();
   final List names;

   public static ClassInfo of(Class underlyingClass) {
      return of(underlyingClass, false);
   }

   public static ClassInfo of(Class underlyingClass, boolean ignoreCase) {
      if (underlyingClass == null) {
         return null;
      } else {
         Map cache = ignoreCase ? CACHE_IGNORE_CASE : CACHE;
         ClassInfo classInfo;
         synchronized(cache) {
            classInfo = (ClassInfo)cache.get(underlyingClass);
            if (classInfo == null) {
               classInfo = new ClassInfo(underlyingClass, ignoreCase);
               cache.put(underlyingClass, classInfo);
            }
         }

         return classInfo;
      }
   }

   public Class getUnderlyingClass() {
      return this.clazz;
   }

   public final boolean getIgnoreCase() {
      return this.ignoreCase;
   }

   public FieldInfo getFieldInfo(String name) {
      if (name != null) {
         if (this.ignoreCase) {
            name = name.toLowerCase(Locale.US);
         }

         name = name.intern();
      }

      return (FieldInfo)this.nameToFieldInfoMap.get(name);
   }

   public Field getField(String name) {
      FieldInfo fieldInfo = this.getFieldInfo(name);
      return fieldInfo == null ? null : fieldInfo.getField();
   }

   public boolean isEnum() {
      return this.clazz.isEnum();
   }

   public Collection getNames() {
      return this.names;
   }

   private ClassInfo(Class srcClass, boolean ignoreCase) {
      this.clazz = srcClass;
      this.ignoreCase = ignoreCase;
      Preconditions.checkArgument(!ignoreCase || !srcClass.isEnum(), "cannot ignore case on an enum: " + srcClass);
      TreeSet nameSet = new TreeSet(new ClassInfo$1(this));
      Field[] var4 = srcClass.getDeclaredFields();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Field field = var4[var6];
         FieldInfo fieldInfo = FieldInfo.of(field);
         if (fieldInfo != null) {
            String fieldName = fieldInfo.getName();
            if (ignoreCase) {
               fieldName = fieldName.toLowerCase(Locale.US).intern();
            }

            FieldInfo conflictingFieldInfo = (FieldInfo)this.nameToFieldInfoMap.get(fieldName);
            Preconditions.checkArgument(conflictingFieldInfo == null, "two fields have the same %sname <%s>: %s and %s", ignoreCase ? "case-insensitive " : "", fieldName, field, conflictingFieldInfo == null ? null : conflictingFieldInfo.getField());
            this.nameToFieldInfoMap.put(fieldName, fieldInfo);
            nameSet.add(fieldName);
         }
      }

      Class superClass = srcClass.getSuperclass();
      if (superClass != null) {
         ClassInfo superClassInfo = of(superClass, ignoreCase);
         nameSet.addAll(superClassInfo.names);
         Iterator var13 = superClassInfo.nameToFieldInfoMap.entrySet().iterator();

         while(var13.hasNext()) {
            Entry e = (Entry)var13.next();
            String name = (String)e.getKey();
            if (!this.nameToFieldInfoMap.containsKey(name)) {
               this.nameToFieldInfoMap.put(name, e.getValue());
            }
         }
      }

      this.names = nameSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(nameSet));
   }

   public Collection getFieldInfos() {
      return Collections.unmodifiableCollection(this.nameToFieldInfoMap.values());
   }
}

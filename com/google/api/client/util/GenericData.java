package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class GenericData extends AbstractMap implements Cloneable {
   Map unknownFields;
   final ClassInfo classInfo;

   public GenericData() {
      this(EnumSet.noneOf(GenericData$Flags.class));
   }

   public GenericData(EnumSet flags) {
      this.unknownFields = ArrayMap.create();
      this.classInfo = ClassInfo.of(this.getClass(), flags.contains(GenericData$Flags.IGNORE_CASE));
   }

   public final Object get(Object name) {
      if (!(name instanceof String)) {
         return null;
      } else {
         String fieldName = (String)name;
         FieldInfo fieldInfo = this.classInfo.getFieldInfo(fieldName);
         if (fieldInfo != null) {
            return fieldInfo.getValue(this);
         } else {
            if (this.classInfo.getIgnoreCase()) {
               fieldName = fieldName.toLowerCase(Locale.US);
            }

            return this.unknownFields.get(fieldName);
         }
      }
   }

   public final Object put(String fieldName, Object value) {
      FieldInfo fieldInfo = this.classInfo.getFieldInfo(fieldName);
      if (fieldInfo != null) {
         Object oldValue = fieldInfo.getValue(this);
         fieldInfo.setValue(this, value);
         return oldValue;
      } else {
         if (this.classInfo.getIgnoreCase()) {
            fieldName = fieldName.toLowerCase(Locale.US);
         }

         return this.unknownFields.put(fieldName, value);
      }
   }

   public GenericData set(String fieldName, Object value) {
      FieldInfo fieldInfo = this.classInfo.getFieldInfo(fieldName);
      if (fieldInfo != null) {
         fieldInfo.setValue(this, value);
      } else {
         if (this.classInfo.getIgnoreCase()) {
            fieldName = fieldName.toLowerCase(Locale.US);
         }

         this.unknownFields.put(fieldName, value);
      }

      return this;
   }

   public final void putAll(Map map) {
      Iterator var2 = map.entrySet().iterator();

      while(var2.hasNext()) {
         Entry entry = (Entry)var2.next();
         this.set((String)entry.getKey(), entry.getValue());
      }

   }

   public final Object remove(Object name) {
      if (!(name instanceof String)) {
         return null;
      } else {
         String fieldName = (String)name;
         FieldInfo fieldInfo = this.classInfo.getFieldInfo(fieldName);
         if (fieldInfo != null) {
            throw new UnsupportedOperationException();
         } else {
            if (this.classInfo.getIgnoreCase()) {
               fieldName = fieldName.toLowerCase(Locale.US);
            }

            return this.unknownFields.remove(fieldName);
         }
      }
   }

   public Set entrySet() {
      return new GenericData$EntrySet(this);
   }

   public GenericData clone() {
      GenericData var10000;
      try {
         GenericData result = (GenericData)super.clone();
         Data.deepCopy(this, result);
         result.unknownFields = (Map)Data.clone(this.unknownFields);
         var10000 = result;
      } catch (CloneNotSupportedException var2) {
         throw new IllegalStateException(var2);
      }

      return var10000;
   }

   public final Map getUnknownKeys() {
      return this.unknownFields;
   }

   public final void setUnknownKeys(Map unknownFields) {
      this.unknownFields = unknownFields;
   }

   public final ClassInfo getClassInfo() {
      return this.classInfo;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object clone() throws CloneNotSupportedException {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object put(Object var1, Object var2) {
      return this.put((String)var1, var2);
   }
}

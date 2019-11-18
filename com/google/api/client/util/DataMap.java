package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.Set;

final class DataMap extends AbstractMap {
   final Object object;
   final ClassInfo classInfo;

   DataMap(Object object, boolean ignoreCase) {
      this.object = object;
      this.classInfo = ClassInfo.of(object.getClass(), ignoreCase);
      Preconditions.checkArgument(!this.classInfo.isEnum());
   }

   public DataMap$EntrySet entrySet() {
      return new DataMap$EntrySet(this);
   }

   public boolean containsKey(Object key) {
      return this.get(key) != null;
   }

   public Object get(Object key) {
      if (!(key instanceof String)) {
         return null;
      } else {
         FieldInfo fieldInfo = this.classInfo.getFieldInfo((String)key);
         return fieldInfo == null ? null : fieldInfo.getValue(this.object);
      }
   }

   public Object put(String key, Object value) {
      FieldInfo fieldInfo = this.classInfo.getFieldInfo(key);
      Preconditions.checkNotNull(fieldInfo, "no field of key " + key);
      Object oldValue = fieldInfo.getValue(this.object);
      fieldInfo.setValue(this.object, Preconditions.checkNotNull(value));
      return oldValue;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Set entrySet() {
      return this.entrySet();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object put(Object var1, Object var2) {
      return this.put((String)var1, var2);
   }
}

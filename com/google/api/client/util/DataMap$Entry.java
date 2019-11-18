package com.google.api.client.util;

import java.util.Locale;
import java.util.Map.Entry;

final class DataMap$Entry implements Entry {
   private Object fieldValue;
   private final FieldInfo fieldInfo;
   // $FF: synthetic field
   final DataMap this$0;

   DataMap$Entry(DataMap this$0, FieldInfo fieldInfo, Object fieldValue) {
      this.this$0 = this$0;
      this.fieldInfo = fieldInfo;
      this.fieldValue = Preconditions.checkNotNull(fieldValue);
   }

   public String getKey() {
      String result = this.fieldInfo.getName();
      if (this.this$0.classInfo.getIgnoreCase()) {
         result = result.toLowerCase(Locale.US);
      }

      return result;
   }

   public Object getValue() {
      return this.fieldValue;
   }

   public Object setValue(Object value) {
      Object oldValue = this.fieldValue;
      this.fieldValue = Preconditions.checkNotNull(value);
      this.fieldInfo.setValue(this.this$0.object, value);
      return oldValue;
   }

   public int hashCode() {
      return this.getKey().hashCode() ^ this.getValue().hashCode();
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (!(obj instanceof Entry)) {
         return false;
      } else {
         Entry other = (Entry)obj;
         return this.getKey().equals(other.getKey()) && this.getValue().equals(other.getValue());
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object getKey() {
      return this.getKey();
   }
}

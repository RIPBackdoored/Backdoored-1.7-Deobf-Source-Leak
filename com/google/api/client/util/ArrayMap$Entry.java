package com.google.api.client.util;

import java.util.Map.Entry;

final class ArrayMap$Entry implements Entry {
   private int index;
   // $FF: synthetic field
   final ArrayMap this$0;

   ArrayMap$Entry(ArrayMap this$0, int index) {
      this.this$0 = this$0;
      this.index = index;
   }

   public Object getKey() {
      return this.this$0.getKey(this.index);
   }

   public Object getValue() {
      return this.this$0.getValue(this.index);
   }

   public Object setValue(Object value) {
      return this.this$0.set(this.index, value);
   }

   public int hashCode() {
      Object key = this.getKey();
      Object value = this.getValue();
      return (key != null ? key.hashCode() : 0) ^ (value != null ? value.hashCode() : 0);
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (!(obj instanceof Entry)) {
         return false;
      } else {
         Entry other = (Entry)obj;
         return Objects.equal(this.getKey(), other.getKey()) && Objects.equal(this.getValue(), other.getValue());
      }
   }
}

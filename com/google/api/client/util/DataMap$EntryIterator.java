package com.google.api.client.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

final class DataMap$EntryIterator implements Iterator {
   private int nextKeyIndex;
   private FieldInfo nextFieldInfo;
   private Object nextFieldValue;
   private boolean isRemoved;
   private boolean isComputed;
   private FieldInfo currentFieldInfo;
   // $FF: synthetic field
   final DataMap this$0;

   DataMap$EntryIterator(DataMap this$0) {
      this.this$0 = this$0;
      this.nextKeyIndex = -1;
   }

   public boolean hasNext() {
      if (!this.isComputed) {
         this.isComputed = true;

         for(this.nextFieldValue = null; this.nextFieldValue == null && ++this.nextKeyIndex < this.this$0.classInfo.names.size(); this.nextFieldValue = this.nextFieldInfo.getValue(this.this$0.object)) {
            this.nextFieldInfo = this.this$0.classInfo.getFieldInfo((String)this.this$0.classInfo.names.get(this.nextKeyIndex));
         }
      }

      return this.nextFieldValue != null;
   }

   public Entry next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.currentFieldInfo = this.nextFieldInfo;
         Object currentFieldValue = this.nextFieldValue;
         this.isComputed = false;
         this.isRemoved = false;
         this.nextFieldInfo = null;
         this.nextFieldValue = null;
         return new DataMap$Entry(this.this$0, this.currentFieldInfo, currentFieldValue);
      }
   }

   public void remove() {
      Preconditions.checkState(this.currentFieldInfo != null && !this.isRemoved);
      this.isRemoved = true;
      this.currentFieldInfo.setValue(this.this$0.object, (Object)null);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object next() {
      return this.next();
   }
}

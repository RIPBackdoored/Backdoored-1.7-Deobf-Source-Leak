package com.google.api.client.util;

import java.util.AbstractSet;
import java.util.Iterator;

final class GenericData$EntrySet extends AbstractSet {
   private final DataMap$EntrySet dataEntrySet;
   // $FF: synthetic field
   final GenericData this$0;

   GenericData$EntrySet(GenericData this$0) {
      this.this$0 = this$0;
      this.dataEntrySet = (new DataMap(this$0, this$0.classInfo.getIgnoreCase())).entrySet();
   }

   public Iterator iterator() {
      return new GenericData$EntryIterator(this.this$0, this.dataEntrySet);
   }

   public int size() {
      return this.this$0.unknownFields.size() + this.dataEntrySet.size();
   }

   public void clear() {
      this.this$0.unknownFields.clear();
      this.dataEntrySet.clear();
   }
}

package com.google.api.client.util;

import java.util.Iterator;
import java.util.Map.Entry;

final class GenericData$EntryIterator implements Iterator {
   private boolean startedUnknown;
   private final Iterator fieldIterator;
   private final Iterator unknownIterator;
   // $FF: synthetic field
   final GenericData this$0;

   GenericData$EntryIterator(GenericData this$0, DataMap$EntrySet dataEntrySet) {
      this.this$0 = this$0;
      this.fieldIterator = dataEntrySet.iterator();
      this.unknownIterator = this$0.unknownFields.entrySet().iterator();
   }

   public boolean hasNext() {
      return this.fieldIterator.hasNext() || this.unknownIterator.hasNext();
   }

   public Entry next() {
      if (!this.startedUnknown) {
         if (this.fieldIterator.hasNext()) {
            return (Entry)this.fieldIterator.next();
         }

         this.startedUnknown = true;
      }

      return (Entry)this.unknownIterator.next();
   }

   public void remove() {
      if (this.startedUnknown) {
         this.unknownIterator.remove();
      }

      this.fieldIterator.remove();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object next() {
      return this.next();
   }
}

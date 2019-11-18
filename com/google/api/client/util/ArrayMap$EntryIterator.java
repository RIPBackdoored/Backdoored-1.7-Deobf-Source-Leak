package com.google.api.client.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

final class ArrayMap$EntryIterator implements Iterator {
   private boolean removed;
   private int nextIndex;
   // $FF: synthetic field
   final ArrayMap this$0;

   ArrayMap$EntryIterator(ArrayMap this$0) {
      this.this$0 = this$0;
   }

   public boolean hasNext() {
      return this.nextIndex < this.this$0.size;
   }

   public Entry next() {
      int index = this.nextIndex;
      if (index == this.this$0.size) {
         throw new NoSuchElementException();
      } else {
         ++this.nextIndex;
         return new ArrayMap$Entry(this.this$0, index);
      }
   }

   public void remove() {
      int index = this.nextIndex - 1;
      if (!this.removed && index >= 0) {
         this.this$0.remove(index);
         this.removed = true;
      } else {
         throw new IllegalArgumentException();
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object next() {
      return this.next();
   }
}

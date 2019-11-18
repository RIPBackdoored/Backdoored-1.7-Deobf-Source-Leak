package com.google.api.client.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Types$1$1 implements Iterator {
   final int length;
   int index;
   // $FF: synthetic field
   final Types$1 this$0;

   Types$1$1(Types$1 this$0) {
      this.this$0 = this$0;
      this.length = Array.getLength(this.this$0.val$value);
      this.index = 0;
   }

   public boolean hasNext() {
      return this.index < this.length;
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return Array.get(this.this$0.val$value, this.index++);
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}

package com.google.api.client.util;

import java.util.AbstractSet;
import java.util.Iterator;

final class ArrayMap$EntrySet extends AbstractSet {
   // $FF: synthetic field
   final ArrayMap this$0;

   ArrayMap$EntrySet(ArrayMap this$0) {
      this.this$0 = this$0;
   }

   public Iterator iterator() {
      return new ArrayMap$EntryIterator(this.this$0);
   }

   public int size() {
      return this.this$0.size;
   }
}

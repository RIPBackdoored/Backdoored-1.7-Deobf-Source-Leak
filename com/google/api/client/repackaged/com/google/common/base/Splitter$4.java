package com.google.api.client.repackaged.com.google.common.base;

import java.util.Iterator;

final class Splitter$4 implements Splitter$Strategy {
   // $FF: synthetic field
   final int val$length;

   Splitter$4(int var1) {
      this.val$length = var1;
   }

   public Splitter$SplittingIterator iterator(Splitter splitter, CharSequence toSplit) {
      return new Splitter$4$1(this, splitter, toSplit);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Iterator iterator(Splitter x0, CharSequence x1) {
      return this.iterator(x0, x1);
   }
}

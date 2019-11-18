package com.google.api.client.repackaged.com.google.common.base;

import java.util.Iterator;

final class Splitter$3 implements Splitter$Strategy {
   // $FF: synthetic field
   final CommonPattern val$separatorPattern;

   Splitter$3(CommonPattern var1) {
      this.val$separatorPattern = var1;
   }

   public Splitter$SplittingIterator iterator(Splitter splitter, CharSequence toSplit) {
      CommonMatcher matcher = this.val$separatorPattern.matcher(toSplit);
      return new Splitter$3$1(this, splitter, toSplit, matcher);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Iterator iterator(Splitter x0, CharSequence x1) {
      return this.iterator(x0, x1);
   }
}

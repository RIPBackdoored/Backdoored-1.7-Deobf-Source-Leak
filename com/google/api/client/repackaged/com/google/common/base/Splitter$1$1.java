package com.google.api.client.repackaged.com.google.common.base;

class Splitter$1$1 extends Splitter$SplittingIterator {
   // $FF: synthetic field
   final Splitter$1 this$0;

   Splitter$1$1(Splitter$1 var1, Splitter x0, CharSequence x1) {
      super(x0, x1);
      this.this$0 = var1;
   }

   int separatorStart(int start) {
      return this.this$0.val$separatorMatcher.indexIn(this.toSplit, start);
   }

   int separatorEnd(int separatorPosition) {
      return separatorPosition + 1;
   }
}

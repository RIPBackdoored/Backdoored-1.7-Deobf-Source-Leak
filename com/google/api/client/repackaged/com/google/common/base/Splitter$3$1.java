package com.google.api.client.repackaged.com.google.common.base;

class Splitter$3$1 extends Splitter$SplittingIterator {
   // $FF: synthetic field
   final CommonMatcher val$matcher;
   // $FF: synthetic field
   final Splitter$3 this$0;

   Splitter$3$1(Splitter$3 var1, Splitter x0, CharSequence x1, CommonMatcher var4) {
      super(x0, x1);
      this.this$0 = var1;
      this.val$matcher = var4;
   }

   public int separatorStart(int start) {
      return this.val$matcher.find(start) ? this.val$matcher.start() : -1;
   }

   public int separatorEnd(int separatorPosition) {
      return this.val$matcher.end();
   }
}

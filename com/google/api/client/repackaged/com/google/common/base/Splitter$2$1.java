package com.google.api.client.repackaged.com.google.common.base;

class Splitter$2$1 extends Splitter$SplittingIterator {
   // $FF: synthetic field
   final Splitter$2 this$0;

   Splitter$2$1(Splitter$2 var1, Splitter x0, CharSequence x1) {
      super(x0, x1);
      this.this$0 = var1;
   }

   public int separatorStart(int start) {
      int separatorLength = this.this$0.val$separator.length();
      int p = start;

      label24:
      for(int last = this.toSplit.length() - separatorLength; p <= last; ++p) {
         for(int i = 0; i < separatorLength; ++i) {
            if (this.toSplit.charAt(i + p) != this.this$0.val$separator.charAt(i)) {
               continue label24;
            }
         }

         return p;
      }

      return -1;
   }

   public int separatorEnd(int separatorPosition) {
      return separatorPosition + this.this$0.val$separator.length();
   }
}

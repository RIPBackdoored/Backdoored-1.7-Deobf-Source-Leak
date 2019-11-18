package com.google.api.client.repackaged.com.google.common.base;

class Splitter$4$1 extends Splitter$SplittingIterator {
   // $FF: synthetic field
   final Splitter$4 this$0;

   Splitter$4$1(Splitter$4 var1, Splitter x0, CharSequence x1) {
      super(x0, x1);
      this.this$0 = var1;
   }

   public int separatorStart(int start) {
      int nextChunkStart = start + this.this$0.val$length;
      return nextChunkStart < this.toSplit.length() ? nextChunkStart : -1;
   }

   public int separatorEnd(int separatorPosition) {
      return separatorPosition;
   }
}

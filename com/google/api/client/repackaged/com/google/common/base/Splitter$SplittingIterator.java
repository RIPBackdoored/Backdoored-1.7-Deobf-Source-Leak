package com.google.api.client.repackaged.com.google.common.base;

abstract class Splitter$SplittingIterator extends AbstractIterator {
   final CharSequence toSplit;
   final CharMatcher trimmer;
   final boolean omitEmptyStrings;
   int offset = 0;
   int limit;

   abstract int separatorStart(int var1);

   abstract int separatorEnd(int var1);

   protected Splitter$SplittingIterator(Splitter splitter, CharSequence toSplit) {
      this.trimmer = Splitter.access$200(splitter);
      this.omitEmptyStrings = Splitter.access$300(splitter);
      this.limit = Splitter.access$400(splitter);
      this.toSplit = toSplit;
   }

   protected String computeNext() {
      int nextStart = this.offset;

      while(true) {
         while(this.offset != -1) {
            int start = nextStart;
            int separatorPosition = this.separatorStart(this.offset);
            int end;
            if (separatorPosition == -1) {
               end = this.toSplit.length();
               this.offset = -1;
            } else {
               end = separatorPosition;
               this.offset = this.separatorEnd(separatorPosition);
            }

            if (this.offset != nextStart) {
               while(start < end && this.trimmer.matches(this.toSplit.charAt(start))) {
                  ++start;
               }

               while(end > start && this.trimmer.matches(this.toSplit.charAt(end - 1))) {
                  --end;
               }

               if (!this.omitEmptyStrings || start != end) {
                  if (this.limit == 1) {
                     end = this.toSplit.length();

                     for(this.offset = -1; end > start && this.trimmer.matches(this.toSplit.charAt(end - 1)); --end) {
                     }
                  } else {
                     --this.limit;
                  }

                  return this.toSplit.subSequence(start, end).toString();
               }

               nextStart = this.offset;
            } else {
               ++this.offset;
               if (this.offset >= this.toSplit.length()) {
                  this.offset = -1;
               }
            }
         }

         return (String)this.endOfData();
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object computeNext() {
      return this.computeNext();
   }
}

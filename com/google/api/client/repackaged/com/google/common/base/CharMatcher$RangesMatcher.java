package com.google.api.client.repackaged.com.google.common.base;

import java.util.Arrays;

class CharMatcher$RangesMatcher extends CharMatcher {
   private final String description;
   private final char[] rangeStarts;
   private final char[] rangeEnds;

   CharMatcher$RangesMatcher(String description, char[] rangeStarts, char[] rangeEnds) {
      this.description = description;
      this.rangeStarts = rangeStarts;
      this.rangeEnds = rangeEnds;
      Preconditions.checkArgument(rangeStarts.length == rangeEnds.length);

      for(int i = 0; i < rangeStarts.length; ++i) {
         Preconditions.checkArgument(rangeStarts[i] <= rangeEnds[i]);
         if (i + 1 < rangeStarts.length) {
            Preconditions.checkArgument(rangeEnds[i] < rangeStarts[i + 1]);
         }
      }

   }

   public boolean matches(char c) {
      int index = Arrays.binarySearch(this.rangeStarts, c);
      if (index >= 0) {
         return true;
      } else {
         index = ~index - 1;
         return index >= 0 && c <= this.rangeEnds[index];
      }
   }

   public String toString() {
      return this.description;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return super.apply((Character)x0);
   }
}

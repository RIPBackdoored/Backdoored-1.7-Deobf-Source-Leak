package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import java.util.BitSet;

final class CharMatcher$AnyOf extends CharMatcher {
   private final char[] chars;

   public CharMatcher$AnyOf(CharSequence chars) {
      this.chars = chars.toString().toCharArray();
      Arrays.sort(this.chars);
   }

   public boolean matches(char c) {
      return Arrays.binarySearch(this.chars, c) >= 0;
   }

   @GwtIncompatible
   void setBits(BitSet table) {
      char[] arr$ = this.chars;
      int len$ = arr$.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         char c = arr$[i$];
         table.set(c);
      }

   }

   public String toString() {
      StringBuilder description = new StringBuilder("CharMatcher.anyOf(\"");
      char[] arr$ = this.chars;
      int len$ = arr$.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         char c = arr$[i$];
         description.append(CharMatcher.access$100(c));
      }

      description.append("\")");
      return description.toString();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return super.apply((Character)x0);
   }
}

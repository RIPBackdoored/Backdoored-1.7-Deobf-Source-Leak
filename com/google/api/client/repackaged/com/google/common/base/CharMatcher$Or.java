package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

final class CharMatcher$Or extends CharMatcher {
   final CharMatcher first;
   final CharMatcher second;

   CharMatcher$Or(CharMatcher a, CharMatcher b) {
      this.first = (CharMatcher)Preconditions.checkNotNull(a);
      this.second = (CharMatcher)Preconditions.checkNotNull(b);
   }

   @GwtIncompatible
   void setBits(BitSet table) {
      this.first.setBits(table);
      this.second.setBits(table);
   }

   public boolean matches(char c) {
      return this.first.matches(c) || this.second.matches(c);
   }

   public String toString() {
      return "CharMatcher.or(" + this.first + ", " + this.second + ")";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return super.apply((Character)x0);
   }
}

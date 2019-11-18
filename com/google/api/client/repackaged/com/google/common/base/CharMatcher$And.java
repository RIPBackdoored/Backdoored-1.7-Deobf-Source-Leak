package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

final class CharMatcher$And extends CharMatcher {
   final CharMatcher first;
   final CharMatcher second;

   CharMatcher$And(CharMatcher a, CharMatcher b) {
      this.first = (CharMatcher)Preconditions.checkNotNull(a);
      this.second = (CharMatcher)Preconditions.checkNotNull(b);
   }

   public boolean matches(char c) {
      return this.first.matches(c) && this.second.matches(c);
   }

   @GwtIncompatible
   void setBits(BitSet table) {
      BitSet tmp1 = new BitSet();
      this.first.setBits(tmp1);
      BitSet tmp2 = new BitSet();
      this.second.setBits(tmp2);
      tmp1.and(tmp2);
      table.or(tmp1);
   }

   public String toString() {
      return "CharMatcher.and(" + this.first + ", " + this.second + ")";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return super.apply((Character)x0);
   }
}

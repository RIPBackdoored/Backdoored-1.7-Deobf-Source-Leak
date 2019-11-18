package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

final class CharMatcher$Is extends CharMatcher$FastMatcher {
   private final char match;

   CharMatcher$Is(char match) {
      this.match = match;
   }

   public boolean matches(char c) {
      return c == this.match;
   }

   public String replaceFrom(CharSequence sequence, char replacement) {
      return sequence.toString().replace(this.match, replacement);
   }

   public CharMatcher and(CharMatcher other) {
      return (CharMatcher)(other.matches(this.match) ? this : none());
   }

   public CharMatcher or(CharMatcher other) {
      return other.matches(this.match) ? other : super.or(other);
   }

   public CharMatcher negate() {
      return isNot(this.match);
   }

   @GwtIncompatible
   void setBits(BitSet table) {
      table.set(this.match);
   }

   public String toString() {
      return "CharMatcher.is('" + CharMatcher.access$100(this.match) + "')";
   }
}

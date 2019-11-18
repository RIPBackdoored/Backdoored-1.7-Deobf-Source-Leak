package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

final class CharMatcher$InRange extends CharMatcher$FastMatcher {
   private final char startInclusive;
   private final char endInclusive;

   CharMatcher$InRange(char startInclusive, char endInclusive) {
      Preconditions.checkArgument(endInclusive >= startInclusive);
      this.startInclusive = startInclusive;
      this.endInclusive = endInclusive;
   }

   public boolean matches(char c) {
      return this.startInclusive <= c && c <= this.endInclusive;
   }

   @GwtIncompatible
   void setBits(BitSet table) {
      table.set(this.startInclusive, this.endInclusive + 1);
   }

   public String toString() {
      return "CharMatcher.inRange('" + CharMatcher.access$100(this.startInclusive) + "', '" + CharMatcher.access$100(this.endInclusive) + "')";
   }
}

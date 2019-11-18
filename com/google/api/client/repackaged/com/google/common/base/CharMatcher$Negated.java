package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

class CharMatcher$Negated extends CharMatcher {
   final CharMatcher original;

   CharMatcher$Negated(CharMatcher original) {
      this.original = (CharMatcher)Preconditions.checkNotNull(original);
   }

   public boolean matches(char c) {
      return !this.original.matches(c);
   }

   public boolean matchesAllOf(CharSequence sequence) {
      return this.original.matchesNoneOf(sequence);
   }

   public boolean matchesNoneOf(CharSequence sequence) {
      return this.original.matchesAllOf(sequence);
   }

   public int countIn(CharSequence sequence) {
      return sequence.length() - this.original.countIn(sequence);
   }

   @GwtIncompatible
   void setBits(BitSet table) {
      BitSet tmp = new BitSet();
      this.original.setBits(tmp);
      tmp.flip(0, 65536);
      table.or(tmp);
   }

   public CharMatcher negate() {
      return this.original;
   }

   public String toString() {
      return this.original + ".negate()";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return super.apply((Character)x0);
   }
}

package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

final class CharMatcher$IsEither extends CharMatcher$FastMatcher {
   private final char match1;
   private final char match2;

   CharMatcher$IsEither(char match1, char match2) {
      this.match1 = match1;
      this.match2 = match2;
   }

   public boolean matches(char c) {
      return c == this.match1 || c == this.match2;
   }

   @GwtIncompatible
   void setBits(BitSet table) {
      table.set(this.match1);
      table.set(this.match2);
   }

   public String toString() {
      return "CharMatcher.anyOf(\"" + CharMatcher.access$100(this.match1) + CharMatcher.access$100(this.match2) + "\")";
   }
}

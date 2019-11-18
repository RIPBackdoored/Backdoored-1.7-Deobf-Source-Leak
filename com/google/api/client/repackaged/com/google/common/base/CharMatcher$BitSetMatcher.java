package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.BitSet;

@GwtIncompatible
final class CharMatcher$BitSetMatcher extends CharMatcher$NamedFastMatcher {
   private final BitSet table;

   private CharMatcher$BitSetMatcher(BitSet table, String description) {
      super(description);
      if (table.length() + 64 < table.size()) {
         table = (BitSet)table.clone();
      }

      this.table = table;
   }

   public boolean matches(char c) {
      return this.table.get(c);
   }

   void setBits(BitSet bitSet) {
      bitSet.or(this.table);
   }

   // $FF: synthetic method
   CharMatcher$BitSetMatcher(BitSet x0, String x1, CharMatcher$1 x2) {
      this(x0, x1);
   }
}

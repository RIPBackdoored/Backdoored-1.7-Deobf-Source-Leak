package com.google.api.client.repackaged.com.google.common.base;

abstract class CharMatcher$FastMatcher extends CharMatcher {
   public final CharMatcher precomputed() {
      return this;
   }

   public CharMatcher negate() {
      return new CharMatcher$NegatedFastMatcher(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return super.apply((Character)x0);
   }
}

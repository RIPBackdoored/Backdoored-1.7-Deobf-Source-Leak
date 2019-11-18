package com.google.api.client.repackaged.com.google.common.base;

abstract class CharMatcher$NamedFastMatcher extends CharMatcher$FastMatcher {
   private final String description;

   CharMatcher$NamedFastMatcher(String description) {
      this.description = (String)Preconditions.checkNotNull(description);
   }

   public final String toString() {
      return this.description;
   }
}

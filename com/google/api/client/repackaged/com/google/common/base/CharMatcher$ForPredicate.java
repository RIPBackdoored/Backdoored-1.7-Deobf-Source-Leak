package com.google.api.client.repackaged.com.google.common.base;

final class CharMatcher$ForPredicate extends CharMatcher {
   private final Predicate predicate;

   CharMatcher$ForPredicate(Predicate predicate) {
      this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
   }

   public boolean matches(char c) {
      return this.predicate.apply(c);
   }

   public boolean apply(Character character) {
      return this.predicate.apply(Preconditions.checkNotNull(character));
   }

   public String toString() {
      return "CharMatcher.forPredicate(" + this.predicate + ")";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return this.apply((Character)x0);
   }
}

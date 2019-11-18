package com.google.api.client.repackaged.com.google.common.base;

final class CharMatcher$JavaLowerCase extends CharMatcher {
   static final CharMatcher$JavaLowerCase INSTANCE = new CharMatcher$JavaLowerCase();

   private CharMatcher$JavaLowerCase() {
   }

   public boolean matches(char c) {
      return Character.isLowerCase(c);
   }

   public String toString() {
      return "CharMatcher.javaLowerCase()";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return super.apply((Character)x0);
   }
}

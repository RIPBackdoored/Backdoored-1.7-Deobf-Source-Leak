package com.google.api.client.repackaged.com.google.common.base;

final class CharMatcher$JavaLetter extends CharMatcher {
   static final CharMatcher$JavaLetter INSTANCE = new CharMatcher$JavaLetter();

   private CharMatcher$JavaLetter() {
   }

   public boolean matches(char c) {
      return Character.isLetter(c);
   }

   public String toString() {
      return "CharMatcher.javaLetter()";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return super.apply((Character)x0);
   }
}

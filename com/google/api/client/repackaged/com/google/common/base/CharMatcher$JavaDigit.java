package com.google.api.client.repackaged.com.google.common.base;

final class CharMatcher$JavaDigit extends CharMatcher {
   static final CharMatcher$JavaDigit INSTANCE = new CharMatcher$JavaDigit();

   private CharMatcher$JavaDigit() {
   }

   public boolean matches(char c) {
      return Character.isDigit(c);
   }

   public String toString() {
      return "CharMatcher.javaDigit()";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return super.apply((Character)x0);
   }
}

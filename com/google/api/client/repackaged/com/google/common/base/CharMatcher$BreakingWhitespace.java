package com.google.api.client.repackaged.com.google.common.base;

final class CharMatcher$BreakingWhitespace extends CharMatcher {
   static final CharMatcher INSTANCE = new CharMatcher$BreakingWhitespace();

   private CharMatcher$BreakingWhitespace() {
   }

   public boolean matches(char c) {
      switch(c) {
      case '\t':
      case '\n':
      case '\u000b':
      case '\f':
      case '\r':
      case ' ':
      case '\u0085':
      case '\u1680':
      case '\u2028':
      case '\u2029':
      case '\u205f':
      case '\u3000':
         return true;
      case '\u2007':
         return false;
      default:
         return c >= 8192 && c <= 8202;
      }
   }

   public String toString() {
      return "CharMatcher.breakingWhitespace()";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object x0) {
      return super.apply((Character)x0);
   }
}

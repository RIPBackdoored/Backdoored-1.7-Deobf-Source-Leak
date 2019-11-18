package com.google.api.client.repackaged.com.google.common.base;

final class CharMatcher$JavaIsoControl extends CharMatcher$NamedFastMatcher {
   static final CharMatcher$JavaIsoControl INSTANCE = new CharMatcher$JavaIsoControl();

   private CharMatcher$JavaIsoControl() {
      super("CharMatcher.javaIsoControl()");
   }

   public boolean matches(char c) {
      return c <= 31 || c >= 127 && c <= 159;
   }
}

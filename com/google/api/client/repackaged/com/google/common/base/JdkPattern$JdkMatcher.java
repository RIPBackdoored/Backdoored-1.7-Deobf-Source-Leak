package com.google.api.client.repackaged.com.google.common.base;

import java.util.regex.Matcher;

final class JdkPattern$JdkMatcher extends CommonMatcher {
   final Matcher matcher;

   JdkPattern$JdkMatcher(Matcher matcher) {
      this.matcher = (Matcher)Preconditions.checkNotNull(matcher);
   }

   boolean matches() {
      return this.matcher.matches();
   }

   boolean find() {
      return this.matcher.find();
   }

   boolean find(int index) {
      return this.matcher.find(index);
   }

   String replaceAll(String replacement) {
      return this.matcher.replaceAll(replacement);
   }

   int end() {
      return this.matcher.end();
   }

   int start() {
      return this.matcher.start();
   }
}

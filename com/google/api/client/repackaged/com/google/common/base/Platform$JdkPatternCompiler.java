package com.google.api.client.repackaged.com.google.common.base;

import java.util.regex.Pattern;

final class Platform$JdkPatternCompiler implements PatternCompiler {
   private Platform$JdkPatternCompiler() {
   }

   public CommonPattern compile(String pattern) {
      return new JdkPattern(Pattern.compile(pattern));
   }

   // $FF: synthetic method
   Platform$JdkPatternCompiler(Platform$1 x0) {
      this();
   }
}

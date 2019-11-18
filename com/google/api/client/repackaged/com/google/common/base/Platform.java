package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
final class Platform {
   private static final Logger logger = Logger.getLogger(Platform.class.getName());
   private static final PatternCompiler patternCompiler = loadPatternCompiler();

   private Platform() {
   }

   static long systemNanoTime() {
      return System.nanoTime();
   }

   static CharMatcher precomputeCharMatcher(CharMatcher matcher) {
      return matcher.precomputedInternal();
   }

   static Optional getEnumIfPresent(Class enumClass, String value) {
      WeakReference ref = (WeakReference)Enums.getEnumConstants(enumClass).get(value);
      return ref == null ? Optional.absent() : Optional.of(enumClass.cast(ref.get()));
   }

   static String formatCompact4Digits(double value) {
      return String.format(Locale.ROOT, "%.4g", value);
   }

   static boolean stringIsNullOrEmpty(@Nullable String string) {
      return string == null || string.isEmpty();
   }

   static CommonPattern compilePattern(String pattern) {
      Preconditions.checkNotNull(pattern);
      return patternCompiler.compile(pattern);
   }

   static boolean usingJdkPatternCompiler() {
      return patternCompiler instanceof Platform$JdkPatternCompiler;
   }

   private static PatternCompiler loadPatternCompiler() {
      return new Platform$JdkPatternCompiler((Platform$1)null);
   }

   private static void logPatternCompilerError(ServiceConfigurationError e) {
      logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", e);
   }
}

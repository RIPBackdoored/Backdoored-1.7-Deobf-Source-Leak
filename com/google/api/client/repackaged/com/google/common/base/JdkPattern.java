package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.regex.Pattern;

@GwtIncompatible
final class JdkPattern extends CommonPattern implements Serializable {
   private final Pattern pattern;
   private static final long serialVersionUID = 0L;

   JdkPattern(Pattern pattern) {
      this.pattern = (Pattern)Preconditions.checkNotNull(pattern);
   }

   CommonMatcher matcher(CharSequence t) {
      return new JdkPattern$JdkMatcher(this.pattern.matcher(t));
   }

   String pattern() {
      return this.pattern.pattern();
   }

   int flags() {
      return this.pattern.flags();
   }

   public String toString() {
      return this.pattern.toString();
   }

   public int hashCode() {
      return this.pattern.hashCode();
   }

   public boolean equals(Object o) {
      return !(o instanceof JdkPattern) ? false : this.pattern.equals(((JdkPattern)o).pattern);
   }
}

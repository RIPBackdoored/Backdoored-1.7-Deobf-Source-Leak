package org.reflections.util;

import com.google.common.base.Predicate;
import java.util.regex.Pattern;

public abstract class FilterBuilder$Matcher implements Predicate {
   final Pattern pattern;

   public FilterBuilder$Matcher(String regex) {
      this.pattern = Pattern.compile(regex);
   }

   public abstract boolean apply(String var1);

   public String toString() {
      return this.pattern.pattern();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object var1) {
      return this.apply((String)var1);
   }
}

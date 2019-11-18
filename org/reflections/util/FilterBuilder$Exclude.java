package org.reflections.util;

public class FilterBuilder$Exclude extends FilterBuilder$Matcher {
   public FilterBuilder$Exclude(String patternString) {
      super(patternString);
   }

   public boolean apply(String regex) {
      return !this.pattern.matcher(regex).matches();
   }

   public String toString() {
      return "-" + super.toString();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object var1) {
      return this.apply((String)var1);
   }
}

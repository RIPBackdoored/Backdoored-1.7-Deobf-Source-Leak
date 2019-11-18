package org.reflections;

import com.google.common.base.Predicate;
import java.util.regex.Pattern;

class Reflections$3 implements Predicate {
   // $FF: synthetic field
   final Pattern val$pattern;
   // $FF: synthetic field
   final Reflections this$0;

   Reflections$3(Reflections this$0, Pattern var2) {
      this.this$0 = this$0;
      this.val$pattern = var2;
   }

   public boolean apply(String input) {
      return this.val$pattern.matcher(input).matches();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object var1) {
      return this.apply((String)var1);
   }
}

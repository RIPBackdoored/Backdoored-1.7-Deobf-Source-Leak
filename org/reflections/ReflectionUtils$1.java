package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.Member;
import javax.annotation.Nullable;

final class ReflectionUtils$1 implements Predicate {
   // $FF: synthetic field
   final String val$name;

   ReflectionUtils$1(String var1) {
      this.val$name = var1;
   }

   public boolean apply(@Nullable Member input) {
      return input != null && input.getName().equals(this.val$name);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Member)var1);
   }
}

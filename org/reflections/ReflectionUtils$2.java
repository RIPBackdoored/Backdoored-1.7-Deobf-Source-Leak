package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.Member;
import javax.annotation.Nullable;

final class ReflectionUtils$2 implements Predicate {
   // $FF: synthetic field
   final String val$prefix;

   ReflectionUtils$2(String var1) {
      this.val$prefix = var1;
   }

   public boolean apply(@Nullable Member input) {
      return input != null && input.getName().startsWith(this.val$prefix);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Member)var1);
   }
}

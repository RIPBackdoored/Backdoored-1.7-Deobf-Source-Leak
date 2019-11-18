package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.Member;
import javax.annotation.Nullable;

final class ReflectionUtils$17 implements Predicate {
   // $FF: synthetic field
   final int val$mod;

   ReflectionUtils$17(int var1) {
      this.val$mod = var1;
   }

   public boolean apply(@Nullable Member input) {
      return input != null && (input.getModifiers() & this.val$mod) != 0;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Member)var1);
   }
}

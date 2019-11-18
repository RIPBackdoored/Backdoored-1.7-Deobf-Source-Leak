package org.reflections;

import com.google.common.base.Predicate;
import javax.annotation.Nullable;

final class ReflectionUtils$18 implements Predicate {
   // $FF: synthetic field
   final int val$mod;

   ReflectionUtils$18(int var1) {
      this.val$mod = var1;
   }

   public boolean apply(@Nullable Class input) {
      return input != null && (input.getModifiers() & this.val$mod) != 0;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Class)var1);
   }
}

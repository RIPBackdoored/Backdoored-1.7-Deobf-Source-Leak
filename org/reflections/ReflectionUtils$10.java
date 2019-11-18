package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.Member;
import javax.annotation.Nullable;

final class ReflectionUtils$10 implements Predicate {
   // $FF: synthetic field
   final int val$count;

   ReflectionUtils$10(int var1) {
      this.val$count = var1;
   }

   public boolean apply(@Nullable Member input) {
      return input != null && ReflectionUtils.access$200(input).length == this.val$count;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Member)var1);
   }
}

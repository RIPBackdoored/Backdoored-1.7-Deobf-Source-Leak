package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.Member;
import java.util.Arrays;
import javax.annotation.Nullable;

final class ReflectionUtils$8 implements Predicate {
   // $FF: synthetic field
   final Class[] val$types;

   ReflectionUtils$8(Class[] var1) {
      this.val$types = var1;
   }

   public boolean apply(@Nullable Member input) {
      return Arrays.equals(ReflectionUtils.access$200(input), this.val$types);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Member)var1);
   }
}

package org.reflections;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import java.lang.reflect.Member;
import javax.annotation.Nullable;

final class ReflectionUtils$11 implements Predicate {
   // $FF: synthetic field
   final Class val$annotationClass;

   ReflectionUtils$11(Class var1) {
      this.val$annotationClass = var1;
   }

   public boolean apply(@Nullable Member input) {
      return input != null && Iterables.any(ReflectionUtils.access$400(ReflectionUtils.access$300(input)), new ReflectionUtils$11$1(this));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Member)var1);
   }
}

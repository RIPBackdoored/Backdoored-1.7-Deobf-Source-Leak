package org.reflections;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import javax.annotation.Nullable;

final class ReflectionUtils$12 implements Predicate {
   // $FF: synthetic field
   final Annotation val$annotation;

   ReflectionUtils$12(Annotation var1) {
      this.val$annotation = var1;
   }

   public boolean apply(@Nullable Member input) {
      return input != null && Iterables.any(ReflectionUtils.access$300(input), new ReflectionUtils$12$1(this));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Member)var1);
   }
}

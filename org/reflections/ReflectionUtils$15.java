package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

final class ReflectionUtils$15 implements Predicate {
   // $FF: synthetic field
   final Class val$type;

   ReflectionUtils$15(Class var1) {
      this.val$type = var1;
   }

   public boolean apply(@Nullable Method input) {
      return input != null && input.getReturnType().equals(this.val$type);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Method)var1);
   }
}

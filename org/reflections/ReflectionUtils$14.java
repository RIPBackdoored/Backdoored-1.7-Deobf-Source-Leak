package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.Field;
import javax.annotation.Nullable;

final class ReflectionUtils$14 implements Predicate {
   // $FF: synthetic field
   final Class val$type;

   ReflectionUtils$14(Class var1) {
      this.val$type = var1;
   }

   public boolean apply(@Nullable Field input) {
      return input != null && this.val$type.isAssignableFrom(input.getType());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Field)var1);
   }
}

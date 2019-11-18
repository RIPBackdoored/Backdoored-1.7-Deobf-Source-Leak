package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import javax.annotation.Nullable;

final class ReflectionUtils$5 implements Predicate {
   // $FF: synthetic field
   final Class[] val$annotations;

   ReflectionUtils$5(Class[] var1) {
      this.val$annotations = var1;
   }

   public boolean apply(@Nullable AnnotatedElement input) {
      return input != null && Arrays.equals(this.val$annotations, ReflectionUtils.access$000(input.getAnnotations()));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((AnnotatedElement)var1);
   }
}

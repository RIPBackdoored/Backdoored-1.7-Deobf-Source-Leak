package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.AnnotatedElement;
import javax.annotation.Nullable;

final class ReflectionUtils$4 implements Predicate {
   // $FF: synthetic field
   final Class val$annotation;

   ReflectionUtils$4(Class var1) {
      this.val$annotation = var1;
   }

   public boolean apply(@Nullable AnnotatedElement input) {
      return input != null && input.isAnnotationPresent(this.val$annotation);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((AnnotatedElement)var1);
   }
}

package org.reflections;

import com.google.common.base.Predicate;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import javax.annotation.Nullable;

final class ReflectionUtils$6 implements Predicate {
   // $FF: synthetic field
   final Annotation val$annotation;

   ReflectionUtils$6(Annotation var1) {
      this.val$annotation = var1;
   }

   public boolean apply(@Nullable AnnotatedElement input) {
      return input != null && input.isAnnotationPresent(this.val$annotation.annotationType()) && ReflectionUtils.access$100(input.getAnnotation(this.val$annotation.annotationType()), this.val$annotation);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((AnnotatedElement)var1);
   }
}

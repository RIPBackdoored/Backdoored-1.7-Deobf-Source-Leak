package org.reflections;

import com.google.common.base.Predicate;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import javax.annotation.Nullable;

final class ReflectionUtils$7 implements Predicate {
   // $FF: synthetic field
   final Annotation[] val$annotations;

   ReflectionUtils$7(Annotation[] var1) {
      this.val$annotations = var1;
   }

   public boolean apply(@Nullable AnnotatedElement input) {
      if (input != null) {
         Annotation[] inputAnnotations = input.getAnnotations();
         if (inputAnnotations.length == this.val$annotations.length) {
            for(int i = 0; i < inputAnnotations.length; ++i) {
               if (!ReflectionUtils.access$100(inputAnnotations[i], this.val$annotations[i])) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((AnnotatedElement)var1);
   }
}

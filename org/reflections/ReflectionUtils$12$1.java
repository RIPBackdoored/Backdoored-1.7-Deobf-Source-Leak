package org.reflections;

import com.google.common.base.Predicate;
import java.lang.annotation.Annotation;
import javax.annotation.Nullable;

class ReflectionUtils$12$1 implements Predicate {
   // $FF: synthetic field
   final ReflectionUtils$12 this$0;

   ReflectionUtils$12$1(ReflectionUtils$12 this$0) {
      this.this$0 = this$0;
   }

   public boolean apply(@Nullable Annotation input) {
      return ReflectionUtils.access$100(this.this$0.val$annotation, input);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Annotation)var1);
   }
}

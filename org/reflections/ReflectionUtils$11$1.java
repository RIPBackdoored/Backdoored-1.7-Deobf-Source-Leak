package org.reflections;

import com.google.common.base.Predicate;
import javax.annotation.Nullable;

class ReflectionUtils$11$1 implements Predicate {
   // $FF: synthetic field
   final ReflectionUtils$11 this$0;

   ReflectionUtils$11$1(ReflectionUtils$11 this$0) {
      this.this$0 = this$0;
   }

   public boolean apply(@Nullable Class input) {
      return input.equals(this.this$0.val$annotationClass);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Class)var1);
   }
}

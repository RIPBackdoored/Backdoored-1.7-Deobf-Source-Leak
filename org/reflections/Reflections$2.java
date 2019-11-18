package org.reflections;

import com.google.common.base.Predicate;
import javax.annotation.Nullable;

class Reflections$2 implements Predicate {
   // $FF: synthetic field
   final Reflections this$0;

   Reflections$2(Reflections this$0) {
      this.this$0 = this$0;
   }

   public boolean apply(@Nullable String input) {
      Class type = ReflectionUtils.forName(input, Reflections.access$000(this.this$0));
      return type != null && !type.isInterface();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((String)var1);
   }
}

package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.AnnotatedElement;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

final class ReflectionUtils$3 implements Predicate {
   // $FF: synthetic field
   final String val$regex;

   ReflectionUtils$3(String var1) {
      this.val$regex = var1;
   }

   public boolean apply(@Nullable AnnotatedElement input) {
      return Pattern.matches(this.val$regex, input.toString());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((AnnotatedElement)var1);
   }
}

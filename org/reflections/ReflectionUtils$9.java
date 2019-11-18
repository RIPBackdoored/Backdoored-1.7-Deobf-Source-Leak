package org.reflections;

import com.google.common.base.Predicate;
import java.lang.reflect.Member;
import javax.annotation.Nullable;

final class ReflectionUtils$9 implements Predicate {
   // $FF: synthetic field
   final Class[] val$types;

   ReflectionUtils$9(Class[] var1) {
      this.val$types = var1;
   }

   public boolean apply(@Nullable Member input) {
      if (input != null) {
         Class[] parameterTypes = ReflectionUtils.access$200(input);
         if (parameterTypes.length == this.val$types.length) {
            for(int i = 0; i < parameterTypes.length; ++i) {
               if (!parameterTypes[i].isAssignableFrom(this.val$types[i]) || parameterTypes[i] == Object.class && this.val$types[i] != Object.class) {
                  return false;
               }
            }

            return true;
         }
      }

      return false;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(@Nullable Object var1) {
      return this.apply((Member)var1);
   }
}

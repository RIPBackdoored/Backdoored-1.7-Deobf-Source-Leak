package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import javax.annotation.Nullable;

@GwtCompatible
public final class Objects extends ExtraObjectsMethodsForWeb {
   private Objects() {
   }

   public static boolean equal(@Nullable Object a, @Nullable Object b) {
      return a == b || a != null && a.equals(b);
   }

   public static int hashCode(@Nullable Object... objects) {
      return Arrays.hashCode(objects);
   }

   /** @deprecated */
   @Deprecated
   public static Objects$ToStringHelper toStringHelper(Object self) {
      return new Objects$ToStringHelper(self.getClass().getSimpleName(), (Objects$1)null);
   }

   /** @deprecated */
   @Deprecated
   public static Objects$ToStringHelper toStringHelper(Class clazz) {
      return new Objects$ToStringHelper(clazz.getSimpleName(), (Objects$1)null);
   }

   /** @deprecated */
   @Deprecated
   public static Objects$ToStringHelper toStringHelper(String className) {
      return new Objects$ToStringHelper(className, (Objects$1)null);
   }

   /** @deprecated */
   @Deprecated
   public static Object firstNonNull(@Nullable Object first, @Nullable Object second) {
      return MoreObjects.firstNonNull(first, second);
   }
}

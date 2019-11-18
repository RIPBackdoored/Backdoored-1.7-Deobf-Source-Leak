package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public final class MoreObjects {
   public static Object firstNonNull(@Nullable Object first, @Nullable Object second) {
      return first != null ? first : Preconditions.checkNotNull(second);
   }

   public static MoreObjects$ToStringHelper toStringHelper(Object self) {
      return new MoreObjects$ToStringHelper(self.getClass().getSimpleName(), (MoreObjects$1)null);
   }

   public static MoreObjects$ToStringHelper toStringHelper(Class clazz) {
      return new MoreObjects$ToStringHelper(clazz.getSimpleName(), (MoreObjects$1)null);
   }

   public static MoreObjects$ToStringHelper toStringHelper(String className) {
      return new MoreObjects$ToStringHelper(className, (MoreObjects$1)null);
   }

   private MoreObjects() {
   }
}

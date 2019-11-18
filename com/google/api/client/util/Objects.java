package com.google.api.client.util;

public final class Objects {
   public static boolean equal(Object a, Object b) {
      return com.google.api.client.repackaged.com.google.common.base.Objects.equal(a, b);
   }

   public static Objects$ToStringHelper toStringHelper(Object self) {
      return new Objects$ToStringHelper(self.getClass().getSimpleName());
   }

   private Objects() {
   }
}

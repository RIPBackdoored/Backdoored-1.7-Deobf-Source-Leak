package com.google.api.client.util;

public final class Throwables {
   public static RuntimeException propagate(Throwable throwable) {
      return com.google.api.client.repackaged.com.google.common.base.Throwables.propagate(throwable);
   }

   public static void propagateIfPossible(Throwable throwable) {
      if (throwable != null) {
         com.google.api.client.repackaged.com.google.common.base.Throwables.throwIfUnchecked(throwable);
      }

   }

   public static void propagateIfPossible(Throwable throwable, Class declaredType) throws Throwable {
      com.google.api.client.repackaged.com.google.common.base.Throwables.propagateIfPossible(throwable, declaredType);
   }

   private Throwables() {
   }
}

package com.google.api.client.util;

public final class Joiner {
   private final com.google.api.client.repackaged.com.google.common.base.Joiner wrapped;

   public static Joiner on(char separator) {
      return new Joiner(com.google.api.client.repackaged.com.google.common.base.Joiner.on(separator));
   }

   private Joiner(com.google.api.client.repackaged.com.google.common.base.Joiner wrapped) {
      this.wrapped = wrapped;
   }

   public final String join(Iterable parts) {
      return this.wrapped.join(parts);
   }
}

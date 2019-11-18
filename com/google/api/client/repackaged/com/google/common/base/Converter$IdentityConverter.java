package com.google.api.client.repackaged.com.google.common.base;

import java.io.Serializable;

final class Converter$IdentityConverter extends Converter implements Serializable {
   static final Converter$IdentityConverter INSTANCE = new Converter$IdentityConverter();
   private static final long serialVersionUID = 0L;

   private Converter$IdentityConverter() {
   }

   protected Object doForward(Object t) {
      return t;
   }

   protected Object doBackward(Object t) {
      return t;
   }

   public Converter$IdentityConverter reverse() {
      return this;
   }

   Converter doAndThen(Converter otherConverter) {
      return (Converter)Preconditions.checkNotNull(otherConverter, "otherConverter");
   }

   public String toString() {
      return "Converter.identity()";
   }

   private Object readResolve() {
      return INSTANCE;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Converter reverse() {
      return this.reverse();
   }
}

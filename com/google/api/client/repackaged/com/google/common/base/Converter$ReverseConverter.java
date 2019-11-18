package com.google.api.client.repackaged.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$ReverseConverter extends Converter implements Serializable {
   final Converter original;
   private static final long serialVersionUID = 0L;

   Converter$ReverseConverter(Converter original) {
      this.original = original;
   }

   protected Object doForward(Object b) {
      throw new AssertionError();
   }

   protected Object doBackward(Object a) {
      throw new AssertionError();
   }

   @Nullable
   Object correctedDoForward(@Nullable Object b) {
      return this.original.correctedDoBackward(b);
   }

   @Nullable
   Object correctedDoBackward(@Nullable Object a) {
      return this.original.correctedDoForward(a);
   }

   public Converter reverse() {
      return this.original;
   }

   public boolean equals(@Nullable Object object) {
      if (object instanceof Converter$ReverseConverter) {
         Converter$ReverseConverter that = (Converter$ReverseConverter)object;
         return this.original.equals(that.original);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return ~this.original.hashCode();
   }

   public String toString() {
      return this.original + ".reverse()";
   }
}

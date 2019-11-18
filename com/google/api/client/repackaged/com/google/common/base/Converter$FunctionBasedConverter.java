package com.google.api.client.repackaged.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$FunctionBasedConverter extends Converter implements Serializable {
   private final Function forwardFunction;
   private final Function backwardFunction;

   private Converter$FunctionBasedConverter(Function forwardFunction, Function backwardFunction) {
      this.forwardFunction = (Function)Preconditions.checkNotNull(forwardFunction);
      this.backwardFunction = (Function)Preconditions.checkNotNull(backwardFunction);
   }

   protected Object doForward(Object a) {
      return this.forwardFunction.apply(a);
   }

   protected Object doBackward(Object b) {
      return this.backwardFunction.apply(b);
   }

   public boolean equals(@Nullable Object object) {
      if (!(object instanceof Converter$FunctionBasedConverter)) {
         return false;
      } else {
         Converter$FunctionBasedConverter that = (Converter$FunctionBasedConverter)object;
         return this.forwardFunction.equals(that.forwardFunction) && this.backwardFunction.equals(that.backwardFunction);
      }
   }

   public int hashCode() {
      return this.forwardFunction.hashCode() * 31 + this.backwardFunction.hashCode();
   }

   public String toString() {
      return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
   }

   // $FF: synthetic method
   Converter$FunctionBasedConverter(Function x0, Function x1, Converter$1 x2) {
      this(x0, x1);
   }
}

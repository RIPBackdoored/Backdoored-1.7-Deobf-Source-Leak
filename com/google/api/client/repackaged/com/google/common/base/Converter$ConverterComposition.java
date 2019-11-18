package com.google.api.client.repackaged.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$ConverterComposition extends Converter implements Serializable {
   final Converter first;
   final Converter second;
   private static final long serialVersionUID = 0L;

   Converter$ConverterComposition(Converter first, Converter second) {
      this.first = first;
      this.second = second;
   }

   protected Object doForward(Object a) {
      throw new AssertionError();
   }

   protected Object doBackward(Object c) {
      throw new AssertionError();
   }

   @Nullable
   Object correctedDoForward(@Nullable Object a) {
      return this.second.correctedDoForward(this.first.correctedDoForward(a));
   }

   @Nullable
   Object correctedDoBackward(@Nullable Object c) {
      return this.first.correctedDoBackward(this.second.correctedDoBackward(c));
   }

   public boolean equals(@Nullable Object object) {
      if (!(object instanceof Converter$ConverterComposition)) {
         return false;
      } else {
         Converter$ConverterComposition that = (Converter$ConverterComposition)object;
         return this.first.equals(that.first) && this.second.equals(that.second);
      }
   }

   public int hashCode() {
      return 31 * this.first.hashCode() + this.second.hashCode();
   }

   public String toString() {
      return this.first + ".andThen(" + this.second + ")";
   }
}

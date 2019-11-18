package com.google.api.client.repackaged.com.google.common.base;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Enums$StringConverter extends Converter implements Serializable {
   private final Class enumClass;
   private static final long serialVersionUID = 0L;

   Enums$StringConverter(Class enumClass) {
      this.enumClass = (Class)Preconditions.checkNotNull(enumClass);
   }

   protected Enum doForward(String value) {
      return Enum.valueOf(this.enumClass, value);
   }

   protected String doBackward(Enum enumValue) {
      return enumValue.name();
   }

   public boolean equals(@Nullable Object object) {
      if (object instanceof Enums$StringConverter) {
         Enums$StringConverter that = (Enums$StringConverter)object;
         return this.enumClass.equals(that.enumClass);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.enumClass.hashCode();
   }

   public String toString() {
      return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object doBackward(Object x0) {
      return this.doBackward((Enum)x0);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object doForward(Object x0) {
      return this.doForward((String)x0);
   }
}

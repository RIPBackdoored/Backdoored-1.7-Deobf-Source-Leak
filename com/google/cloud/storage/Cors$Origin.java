package com.google.cloud.storage;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

public final class Cors$Origin implements Serializable {
   private static final long serialVersionUID = -4447958124895577993L;
   private static final String ANY_URI = "*";
   private final String value;
   private static final Cors$Origin ANY = new Cors$Origin("*");

   private Cors$Origin(String value) {
      this.value = (String)Preconditions.checkNotNull(value);
   }

   public static Cors$Origin any() {
      return ANY;
   }

   public static Cors$Origin of(String scheme, String host, int port) {
      Cors$Origin var10000;
      try {
         var10000 = of((new URI(scheme, (String)null, host, port, (String)null, (String)null, (String)null)).toString());
      } catch (URISyntaxException var4) {
         throw new IllegalArgumentException(var4);
      }

      return var10000;
   }

   public static Cors$Origin of(String value) {
      return "*".equals(value) ? any() : new Cors$Origin(value);
   }

   public int hashCode() {
      return this.value.hashCode();
   }

   public boolean equals(Object obj) {
      return !(obj instanceof Cors$Origin) ? false : this.value.equals(((Cors$Origin)obj).value);
   }

   public String toString() {
      return this.getValue();
   }

   public String getValue() {
      return this.value;
   }
}

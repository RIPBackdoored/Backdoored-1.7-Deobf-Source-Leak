package l.c.h.h;

import java.util.ArrayList;

public final class c extends Enum {
   public static final c ur = new c("BIND", 0);
   public static final c ik = new c("ENUM", 1);
   public static final c if = new c("STRING", 2);
   public static final c iq = new c("BOOLEAN", 3);
   public static final c it = new c("INTEGER", 4);
   public static final c ie = new c("DOUBLE", 5);
   public static final c iv = new c("FLOAT", 6);
   protected ArrayList iu = new ArrayList();
   // $FF: synthetic field
   private static final c[] $VALUES = new c[]{ur, ik, if, iq, it, ie, iv};
   public static final int ii;
   public static final boolean id;

   public static c[] values() {
      return (c[])$VALUES.clone();
   }

   public static c valueOf(String var0) {
      return (c)Enum.valueOf(c.class, var0);
   }

   private c(String var1, int var2) {
      super(var1, var2);
   }

   public ArrayList r() {
      return this.iu;
   }
}

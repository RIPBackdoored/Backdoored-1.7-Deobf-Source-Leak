package l.c.h.j.c;

final class d$c extends Enum {
   public static final d$c k = new d$c("BOOK", 0);
   public static final d$c f = new d$c("SIGN", 1);
   public static final d$c q;
   // $FF: synthetic field
   private static final d$c[] $VALUES = new d$c[]{k, f, q};
   public static final int t;
   public static final boolean e;

   public static d$c[] values() {
      return (d$c[])$VALUES.clone();
   }

   public static d$c valueOf(String var0) {
      return (d$c)Enum.valueOf(d$c.class, var0);
   }

   private d$c(String var1, int var2) {
      super(var1, var2);
   }
}

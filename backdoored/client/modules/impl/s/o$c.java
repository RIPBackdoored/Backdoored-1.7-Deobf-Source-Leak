package l.c.h.j.s;

final class o$c extends Enum {
   public static final o$c fmn = new o$c("BOOST", 0);
   public static final o$c fmr = new o$c("CONTROL", 1);
   public static final o$c fjk = new o$c("FLIGHT", 2);
   // $FF: synthetic field
   private static final o$c[] $VALUES = new o$c[]{fmn, fmr, fjk};
   public static final int fjf;
   public static final boolean fjq;

   public static o$c[] values() {
      return (o$c[])$VALUES.clone();
   }

   public static o$c valueOf(String var0) {
      return (o$c)Enum.valueOf(o$c.class, var0);
   }

   private o$c(String var1, int var2) {
      super(var1, var2);
   }
}

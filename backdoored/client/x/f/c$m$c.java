package l.c.x.f;

public final class c$m$c extends Enum {
   public static final c$m$c fsq = new c$m$c("INSIDE", 0);
   public static final c$m$c fst = new c$m$c("OUTSIDE", 1);
   public static final c$m$c fse = new c$m$c("INVERTED", 2);
   public static final c$m$c fsv = new c$m$c("FAIL", 3);
   // $FF: synthetic field
   private static final c$m$c[] $VALUES = new c$m$c[]{fsq, fst, fse, fsv};
   public static final int fsu;
   public static final boolean fsi;

   public static c$m$c[] values() {
      return (c$m$c[])$VALUES.clone();
   }

   public static c$m$c valueOf(String var0) {
      return (c$m$c)Enum.valueOf(c$m$c.class, var0);
   }

   private c$m$c(String var1, int var2) {
      super(var1, var2);
   }
}

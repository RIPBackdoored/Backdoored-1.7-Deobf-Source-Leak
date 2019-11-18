package l.c.h.j.g;

final class v$c extends Enum {
   public static final v$c lm = new v$c("NORTH", 0);
   public static final v$c lj = new v$c("EAST", 1);
   public static final v$c lc = new v$c("SOUTH", 2);
   public static final v$c lo = new v$c("WEST", 3);
   // $FF: synthetic field
   private static final v$c[] $VALUES = new v$c[]{lm, lj, lc, lo};
   public static final int lp;
   public static final boolean lz;

   public static v$c[] values() {
      return (v$c[])$VALUES.clone();
   }

   public static v$c valueOf(String var0) {
      return (v$c)Enum.valueOf(v$c.class, var0);
   }

   private v$c(String var1, int var2) {
      super(var1, var2);
   }
}

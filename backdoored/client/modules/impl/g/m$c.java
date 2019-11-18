package l.c.h.j.g;

final class m$c extends Enum {
   public static final m$c dj = new m$c("ALL", 0);
   public static final m$c dc = new m$c("EXP_ONLY", 1);
   public static final m$c do = new m$c("CRYSTAL_ONLY", 2);
   public static final m$c dp = new m$c("EXP_AND_CRYSTAL_ONLY", 3);
   // $FF: synthetic field
   private static final m$c[] $VALUES = new m$c[]{dj, dc, do, dp};
   public static final int dz;
   public static final boolean db;

   public static m$c[] values() {
      return (m$c[])$VALUES.clone();
   }

   public static m$c valueOf(String var0) {
      return (m$c)Enum.valueOf(m$c.class, var0);
   }

   private m$c(String var1, int var2) {
      super(var1, var2);
   }
}

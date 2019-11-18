package l.c.x.h;

public final class c$d extends Enum {
   public static final c$d ef = new c$d("NUMSTACKS", 0);
   public static final c$d eq = new c$d("NUMITEMS", 1);
   // $FF: synthetic field
   private static final c$d[] $VALUES = new c$d[]{ef, eq};
   public static final int et;
   public static final boolean ee;

   public static c$d[] values() {
      return (c$d[])$VALUES.clone();
   }

   public static c$d valueOf(String var0) {
      return (c$d)Enum.valueOf(c$d.class, var0);
   }

   private c$d(String var1, int var2) {
      super(var1, var2);
   }
}

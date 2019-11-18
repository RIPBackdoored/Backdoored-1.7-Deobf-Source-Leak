package l.c.x.x;

final class c$f extends Enum {
   public static final c$f fit = new c$f("dev", 0);
   public static final c$f fie = new c$f("betaTester", 1);
   public static final c$f fiv = new c$f("owner", 2);
   public static final c$f fiu = new c$f("none", 3);
   // $FF: synthetic field
   private static final c$f[] $VALUES = new c$f[]{fit, fie, fiv, fiu};
   public static final int fii;
   public static final boolean fid;

   public static c$f[] values() {
      return (c$f[])$VALUES.clone();
   }

   public static c$f valueOf(String var0) {
      return (c$f)Enum.valueOf(c$f.class, var0);
   }

   private c$f(String var1, int var2) {
      super(var1, var2);
   }
}

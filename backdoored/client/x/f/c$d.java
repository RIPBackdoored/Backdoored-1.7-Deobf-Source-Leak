package l.c.x.f;

public final class c$d extends Enum {
   public static final c$d ftq = new c$d("ORTHOGONAL", 0);
   public static final c$d ftt = new c$d("DIRECT", 1);
   public static final c$d fte;
   // $FF: synthetic field
   private static final c$d[] $VALUES = new c$d[]{ftq, ftt, fte};
   public static final int ftv;
   public static final boolean ftu;

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

package l.c.h.j.v;

final class s$c extends Enum {
   public static final s$c fev = new s$c("NOHANDS", 0);
   public static final s$c feu = new s$c("NOLEFT", 1);
   public static final s$c fei = new s$c("NORIGHT", 2);
   public static final s$c fed = new s$c("ALL", 3);
   // $FF: synthetic field
   private static final s$c[] $VALUES = new s$c[]{fev, feu, fei, fed};
   public static final int fes;
   public static final boolean fem;

   public static s$c[] values() {
      return (s$c[])$VALUES.clone();
   }

   public static s$c valueOf(String var0) {
      return (s$c)Enum.valueOf(s$c.class, var0);
   }

   private s$c(String var1, int var2) {
      super(var1, var2);
   }
}

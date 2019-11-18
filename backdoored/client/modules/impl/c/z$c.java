package l.c.h.j.c;

final class z$c extends Enum {
   public static final z$c fru = new z$c("NO_ANIMATION", 0);
   public static final z$c fri = new z$c("PACKET_MINE", 1);
   // $FF: synthetic field
   private static final z$c[] $VALUES = new z$c[]{fru, fri};
   public static final int frd;
   public static final boolean frs;

   public static z$c[] values() {
      return (z$c[])$VALUES.clone();
   }

   public static z$c valueOf(String var0) {
      return (z$c)Enum.valueOf(z$c.class, var0);
   }

   private z$c(String var1, int var2) {
      super(var1, var2);
   }
}

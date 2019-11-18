package l.c.h.j.x;

final class h$c extends Enum {
   public static final h$c fcb = new h$c("twelve", 0, "12");
   public static final h$c fcy = new h$c("twentyfour", 1, "24");
   private String fcx;
   // $FF: synthetic field
   private static final h$c[] $VALUES = new h$c[]{fcb, fcy};
   public static final int fcl;
   public static final boolean fch;

   public static h$c[] values() {
      return (h$c[])$VALUES.clone();
   }

   public static h$c valueOf(String var0) {
      return (h$c)Enum.valueOf(h$c.class, var0);
   }

   private h$c(String var1, int var2, String var3) {
      super(var1, var2);
      this.fcx = var3;
   }

   public String toString() {
      return this.fcx;
   }
}

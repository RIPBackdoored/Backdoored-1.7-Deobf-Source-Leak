package l.c.h.j.c;

final class a$c extends Enum {
   public static final a$c fps = new a$c("PORTAL", 0, "Portal God Mode");
   public static final a$c fpm = new a$c("SPOOFDEATH", 1, "Spoof Death");
   public static final a$c fpj = new a$c("PACKET", 2, "Anti Packet");
   private final String fpc;
   // $FF: synthetic field
   private static final a$c[] $VALUES = new a$c[]{fps, fpm, fpj};
   public static final int fpo;
   public static final boolean fpp;

   public static a$c[] values() {
      return (a$c[])$VALUES.clone();
   }

   public static a$c valueOf(String var0) {
      return (a$c)Enum.valueOf(a$c.class, var0);
   }

   private a$c(String var1, int var2, String var3) {
      this.fpc = var3;
   }

   public String toString() {
      return this.fpc;
   }
}

package l.c.h.j.f;

final class d$c extends Enum {
   public static final d$c flq = new d$c("PRIVATE", 0);
   public static final d$c flt = new d$c("PUBLIC", 1);
   // $FF: synthetic field
   private static final d$c[] $VALUES = new d$c[]{flq, flt};
   public static final int fle;
   public static final boolean flv;

   public static d$c[] values() {
      return (d$c[])$VALUES.clone();
   }

   public static d$c valueOf(String var0) {
      return (d$c)Enum.valueOf(d$c.class, var0);
   }

   private d$c(String var1, int var2) {
      super(var1, var2);
   }
}

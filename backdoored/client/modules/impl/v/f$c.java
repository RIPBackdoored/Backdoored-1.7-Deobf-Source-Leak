package l.c.h.j.v;

final class f$c extends Enum {
   public static final f$c flu = new f$c("BEDROCK", 0);
   public static final f$c fli = new f$c("OBBY", 1);
   public static final f$c fld = new f$c("OTHER", 2);
   public static final f$c fls = new f$c("NONE", 3);
   // $FF: synthetic field
   private static final f$c[] $VALUES = new f$c[]{flu, fli, fld, fls};
   public static final int flm;
   public static final boolean flj;

   public static f$c[] values() {
      return (f$c[])$VALUES.clone();
   }

   public static f$c valueOf(String var0) {
      return (f$c)Enum.valueOf(f$c.class, var0);
   }

   private f$c(String var1, int var2) {
      super(var1, var2);
   }
}

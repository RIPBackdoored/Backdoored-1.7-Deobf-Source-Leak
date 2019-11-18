package l.c.h.j.g;

final class f$c extends Enum {
   public static final f$c sw;
   public static final f$c sn = new f$c("SPAM", 1);
   public static final f$c sr = new f$c("EMPTY", 2);
   // $FF: synthetic field
   private static final f$c[] $VALUES = new f$c[]{sw, sn, sr};
   public static final int mk;
   public static final boolean mf;

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

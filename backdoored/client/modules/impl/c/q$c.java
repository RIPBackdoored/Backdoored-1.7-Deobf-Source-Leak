package l.c.h.j.c;

final class q$c extends Enum {
   public static final q$c fwe = new q$c("OFFHAND", 0, "Offhand");
   public static final q$c fwv = new q$c("SNEAK", 1, "Sneak");
   public static final q$c fwu = new q$c("VCLIP", 2, "VClip");
   public static final q$c fwi = new q$c("WINDOWCLICK", 3, "Window Click");
   public static final q$c fwd = new q$c("ITEMSWITCH", 4, "Item Switch");
   public static final q$c fws = new q$c("USEITEM", 5, "Use Item");
   public static final q$c fwm = new q$c("HANDSPAM", 6, "Hand Spam");
   public static final q$c fwj = new q$c("ENTITY_MOVEMENT", 7, "Entity Movement");
   private final String fwc;
   // $FF: synthetic field
   private static final q$c[] $VALUES = new q$c[]{fwe, fwv, fwu, fwi, fwd, fws, fwm, fwj};
   public static final int fwo;
   public static final boolean fwp;

   public static q$c[] values() {
      return (q$c[])$VALUES.clone();
   }

   public static q$c valueOf(String var0) {
      return (q$c)Enum.valueOf(q$c.class, var0);
   }

   private q$c(String var1, int var2, String var3) {
      super(var1, var2);
      this.fwc = var3;
   }

   public String toString() {
      return this.fwc;
   }
}

package l.c.h.d;

public final class c extends Enum {
   public static final c ei = new c("MOVEMENT", 0, "Movement");
   public static final c ed = new c("RENDER", 1, "Render");
   public static final c es = new c("PLAYER", 2, "Player");
   public static final c em = new c("COMBAT", 3, "Combat");
   public static final c ej = new c("MISC", 4, "Misc");
   public static final c ec = new c("EXPLOIT", 5, "Exploits");
   public static final c eo = new c("CLIENT", 6, "Client");
   public static final c ep = new c("UI", 7, "UIs");
   public static final c ez;
   public a eb;
   // $FF: synthetic field
   private static final c[] $VALUES = new c[]{ei, ed, es, em, ej, ec, eo, ep, ez};
   public static final int ey;
   public static final boolean ex;

   public static c[] values() {
      return (c[])$VALUES.clone();
   }

   public static c valueOf(String var0) {
      return (c)Enum.valueOf(c.class, var0);
   }

   private c(String var1, int var2, String var3) {
      super(var1, var2);
      this.eb = new a(var3);
   }
}

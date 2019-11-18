package l.c.h.j.player;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;

@w$d(
   name = "Auto Dupe",
   description = "",
   category = c.PLAYER
)
public class AutoDupe extends w {
   private boolean fku = false;
   public static final int fki;
   public static final boolean fkd;

   public void d() {
      if (this.qm()) {
         if (!this.fku) {
            mc.player.sendChatMessage(".vanish dismount");
            this.fku = true;
         }
      }
   }
}

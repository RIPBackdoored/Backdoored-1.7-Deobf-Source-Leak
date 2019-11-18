package l.c.h.j.client;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.f;
import l.c.u.y;
import l.c.x.d.a;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "MsgOnToggle",
   description = "Sends message to chat on module toggle",
   category = c.CLIENT,
   defaultOn = true
)
public class MsgOnToggle extends w {
   public static final int ffv;
   public static final boolean ffu;

   @SubscribeEvent
   public void k(y var1) {
      if (this.qm() && !var1.bh.gw.equalsIgnoreCase("clickgui")) {
         a.m(var1.bh.gw + " was enabled", "green");
      }

   }

   @SubscribeEvent
   public void k(f var1) {
      if (this.qm() && !var1.js.gw.equalsIgnoreCase("clickgui")) {
         a.m(var1.js.gw + " was disabled", "red");
      }

   }
}

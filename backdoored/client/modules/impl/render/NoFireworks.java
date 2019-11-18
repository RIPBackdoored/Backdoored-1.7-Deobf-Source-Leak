package l.c.h.j.render;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.df;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "No Fireworks",
   description = "Stop people from lagging you out",
   category = c.RENDER
)
public class NoFireworks extends w {
   public static final int bv;
   public static final boolean bu;

   @SubscribeEvent
   public void k(df var1) {
      if (this.qm()) {
         var1.setCanceled(true);
      }

   }
}

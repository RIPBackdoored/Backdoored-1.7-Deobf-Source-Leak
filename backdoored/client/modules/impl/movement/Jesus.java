package l.c.h.j.movement;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.dd;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Jesus",
   description = "Walk on water",
   category = c.MOVEMENT
)
public class Jesus extends w {
   public static final int ne;
   public static final boolean nv;

   @SubscribeEvent
   public void k(dd var1) {
      if (this.qm()) {
         var1.fpt = 0.4D;
      }

   }
}

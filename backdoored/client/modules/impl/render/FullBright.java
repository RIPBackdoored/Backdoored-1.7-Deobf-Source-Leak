package l.c.h.j.render;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.dh;
import l.c.u.h;
import l.c.u.m;
import l.c.u.z;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Full Bright",
   description = "Big Brightness bois",
   category = c.RENDER
)
public class FullBright extends w {
   public static final int fqb;
   public static final boolean fqy;

   @SubscribeEvent
   public void k(h var1) {
      if (this.qm()) {
         var1.qq = 1.0F;
      }

   }

   @SubscribeEvent
   public void k(z var1) {
      if (this.qm()) {
         var1.nh = 1.0F;
      }

   }

   @SubscribeEvent
   public void k(dh var1) {
      if (this.qm()) {
         var1.fpz = 1000;
      }

   }

   @SubscribeEvent
   public void k(m var1) {
      if (this.qm()) {
         var1.fks = false;
      }

   }
}

package l.c.h.j.client;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraftforge.client.event.EntityViewRenderEvent.FOVModifier;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Anti FOV",
   description = "Cap your FOV",
   category = c.CLIENT
)
public class AntiFOV extends w {
   private j gk;
   public static final int gf;
   public static final boolean gq;

   public AntiFOV() {
      this.gk = new i("Max FOV", this, 125, 0, 360);
   }

   @SubscribeEvent
   public void k(FOVModifier var1) {
      if (this.qm()) {
         var1.setFOV(Math.min(var1.getFOV(), (float)(Integer)this.gk.ti()));
      }

   }
}

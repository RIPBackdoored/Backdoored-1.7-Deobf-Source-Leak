package l.c.h.j.render;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Anti Overlay",
   description = "Prevents Overlay",
   category = c.RENDER
)
public class AntiOverlay extends w {
   private j fjy = new f("Fire", this, true);
   private j fjx = new f("Blocks", this, true);
   private j fjl = new f("Water", this, true);
   public static final boolean fjh;
   public static final int fja;
   public static final boolean fjg;

   @SubscribeEvent
   public void k(RenderBlockOverlayEvent var1) {
      // $FF: Couldn't be decompiled
   }
}

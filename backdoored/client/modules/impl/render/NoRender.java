package l.c.h.j.render;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.s.g;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "No Render",
   description = "Dont render things",
   category = c.RENDER
)
public class NoRender extends w {
   private j fey = new f("Stop Explosions", this, true);
   private j fex = new f("Stop Particles", this, true);
   private j fel = new f("helmet", this, false);
   private j feh = new f("portal", this, false);
   private j fea = new f("crosshair", this, false);
   private j feg = new f("bosshealth", this, false);
   private j few = new f("bossinfo", this, false);
   private j fen = new f("armor", this, false);
   private j fer = new f("health", this, false);
   private j fvk = new f("food", this, false);
   private j fvf = new f("air", this, false);
   private j fvq = new f("hotbar", this, false);
   private j fvt = new f("experience", this, false);
   private j fve = new f("text", this, false);
   private j fvv = new f("horse health", this, false);
   private j fvu = new f("horse jump", this, false);
   private j fvi = new f("chat", this, false);
   private j fvd = new f("playerlist", this, false);
   private j fvs = new f("potion icon", this, false);
   private j fvm = new f("subtitles", this, false);
   private j fvj = new f("fps graph", this, false);
   private j fvc = new f("vignette", this, false);
   public static final boolean fvo;
   public static final int fvp;
   public static final boolean fvz;

   @SubscribeEvent
   public void q(g var1) {
      if (var1.packet instanceof SPacketExplosion) {
         var1.setCanceled(true);
      }

      if (this.qm() && (Boolean)this.fex.ti() && var1.packet instanceof SPacketParticles) {
         var1.setCanceled(true);
      }

   }

   @SubscribeEvent
   public void f(RenderGameOverlayEvent var1) {
      // $FF: Couldn't be decompiled
   }
}

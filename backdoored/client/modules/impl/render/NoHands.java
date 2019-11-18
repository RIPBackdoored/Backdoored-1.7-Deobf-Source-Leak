package l.c.h.j.render;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.o;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.v.s$c;
import l.c.u.q;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "No Hands",
   description = "Dont render your hands",
   category = c.RENDER
)
@w$d(
   name = "No Hands",
   description = "Dont render your hands",
   category = c.RENDER
)
public class NoHands extends w {
   private j bp;
   private j bz;
   private j bb;
   private j by;
   public static final int bx;
   public static final boolean bl;
   private j bp;
   private j bz;
   private j bb;
   private j by;
   public static final int bx;
   public static final boolean bl;

   public NoHands() {
      this.bp = new o("Blacklist", this, s$c.fev);
      this.bz = new l.c.h.h.a.d.c("Mainhand Offset", this, 1.0D, 0.0D, 2.0D);
      this.bb = new l.c.h.h.a.d.c("Offhand Offset", this, 1.0D, 0.0D, 2.0D);
      this.by = new l.c.h.h.a.d.c("Transparency", this, 1.0D, 0.0D, 1.0D);
   }

   @SubscribeEvent
   public void k(RenderSpecificHandEvent var1) {
      if (this.qm()) {
         if (this.bp.ti() == s$c.fev) {
            var1.setCanceled(true);
         }

         if (this.bp.ti() == s$c.feu && var1.getHand() == EnumHand.OFF_HAND) {
            var1.setCanceled(true);
         }

         if (this.bp.ti() == s$c.fei && var1.getHand() == EnumHand.MAIN_HAND) {
            var1.setCanceled(true);
         }
      }

   }

   @SubscribeEvent
   public void k(q param1) {
      // $FF: Couldn't be decompiled
   }

   public NoHands() {
      this.bp = new o("Blacklist", this, s$c.fev);
      this.bz = new l.c.h.h.a.d.c("Mainhand Offset", this, 1.0D, 0.0D, 2.0D);
      this.bb = new l.c.h.h.a.d.c("Offhand Offset", this, 1.0D, 0.0D, 2.0D);
      this.by = new l.c.h.h.a.d.c("Transparency", this, 1.0D, 0.0D, 1.0D);
   }

   @SubscribeEvent
   public void k(RenderSpecificHandEvent var1) {
      if (this.qm()) {
         if (this.bp.ti() == s$c.fev) {
            var1.setCanceled(true);
         }

         if (this.bp.ti() == s$c.feu && var1.getHand() == EnumHand.OFF_HAND) {
            var1.setCanceled(true);
         }

         if (this.bp.ti() == s$c.fei && var1.getHand() == EnumHand.MAIN_HAND) {
            var1.setCanceled(true);
         }
      }

   }

   @SubscribeEvent
   public void k(q param1) {
      // $FF: Couldn't be decompiled
   }
}

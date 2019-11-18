package l.c.h.j.player;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.e;
import l.c.u.p;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Instant Portal",
   description = "ez pz",
   category = c.PLAYER
)
public class InstantPortal extends w {
   private j fdn = new i("Cooldown", this, 2, 0, 10);
   private j fdr = new i("Wait Time", this, 2, 0, 80);
   public static final int fsk;
   public static final boolean fsf;

   @SubscribeEvent
   public void k(e var1) {
      if (var1.entityPlayer == null || var1.entityPlayer.getUniqueID().equals(mc.player.getUniqueID())) {
         var1.zv = (Integer)this.fdn.ti();
      }

   }

   @SubscribeEvent
   public void k(p var1) {
      if (this.qm() && (var1.entity == null || var1.entity.getUniqueID().equals(mc.player.getUniqueID()))) {
         var1.bk = (Integer)this.fdr.ti();
      }

   }
}

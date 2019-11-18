package l.c.h.j.movement;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.g;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Pull Down",
   description = "Fast fall",
   category = c.MOVEMENT
)
public class PullDown extends w {
   private boolean fqx;
   private j fql;
   public static final boolean fqh;
   public static final int fqa;
   public static final boolean fqg;

   public PullDown() {
      this.fqx = false;
      this.fql = new g("Speed", this, 10.0F, 0.0F, 20.0F);
   }

   public void d() {
      if (this.fqx && mc.player.onGround) {
         this.fqx = false;
      }

      if (this.qm() && !mc.player.isElytraFlying() && !mc.player.capabilities.isFlying) {
         if (!mc.world.isAirBlock(mc.player.getPosition().add(0, -1, 0)) || !mc.world.isAirBlock(mc.player.getPosition().add(0, -2, 0))) {
            boolean var10000 = true;
         }

         boolean var1 = false;
         if (!mc.player.onGround) {
            mc.player.motionY = (double)(-(Float)this.fql.ti());
         }

      }
   }

   @SubscribeEvent
   public void k(LivingJumpEvent var1) {
      if (var1.getEntityLiving().equals(mc.player)) {
         this.fqx = true;
      }

   }
}

package l.c.h.j.movement;

import l.c.q;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.du$a;
import l.c.x.u;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Speed",
   description = "Speeeeeeeeeeeeeeed",
   category = c.MOVEMENT
)
public class Speed extends w {
   private j fyw;
   public static final boolean fyn;
   public static final int fyr;
   public static final boolean fxk;

   public Speed() {
      this.fyw = new f("Only Forward", this, false);
   }

   @SubscribeEvent
   public void k(du$a var1) {
      if (this.qm()) {
         this.k(0.405D, 0.2F, 1.0064D);
      }
   }

   private void k(double var1, float var3, double var4) {
      if (!(Boolean)this.fyw.ti() && mc.player.moveForward != 0.0F || mc.player.moveForward > 0.0F) {
         boolean var10000 = true;
      }

      boolean var6 = false;
      if (mc.player.moveStrafing != 0.0F) {
         mc.player.setSprinting(true);
         if (mc.player.onGround) {
            mc.player.motionY = var1;
            float var7 = u.fb();
            EntityPlayerSP var12 = mc.player;
            var12.motionX -= (double)(MathHelper.sin(var7) * var3);
            var12 = mc.player;
            var12.motionZ += (double)(MathHelper.cos(var7) * var3);
         }

         double var13 = Math.sqrt(mc.player.motionX * mc.player.motionX + mc.player.motionZ * mc.player.motionZ);
         double var9 = (double)u.fb();
         mc.player.motionX = -Math.sin(var9) * var4 * var13;
         mc.player.motionZ = Math.cos(var9) * var4 * var13;
      }

   }

   public void k(double var1, double var3, EntityPlayerSP var5) {
      MovementInput var6 = q.mc.player.movementInput;
      float var7 = var6.moveForward;
      float var8 = var6.moveStrafe;
      float var9 = q.mc.player.rotationYaw;
      if ((double)var7 != 0.0D) {
         boolean var10001;
         if ((double)var7 > 0.0D) {
            var10001 = true;
         }

         var9 += (float)45;
         if ((double)var8 < 0.0D) {
            if ((double)var7 > 0.0D) {
               var10001 = true;
            }

            var9 += (float)-45;
         }

         var8 = 0.0F;
         if ((double)var7 > 0.0D) {
            var7 = 1.0F;
         }

         if ((double)var7 < 0.0D) {
            var7 = -1.0F;
         }
      }

      if ((double)var8 > 0.0D) {
         var8 = 1.0F;
      }

      if ((double)var8 < 0.0D) {
         var8 = -1.0F;
      }

      var5.motionX = var1 + (double)var7 * 0.2D * Math.cos(Math.toRadians((double)(var9 + 90.0F))) + (double)var8 * 0.2D * Math.sin(Math.toRadians((double)(var9 + 90.0F)));
      var5.motionZ = var3 + ((double)var7 * 0.2D * Math.sin(Math.toRadians((double)(var9 + 90.0F))) - (double)var8 * 0.2D * Math.cos(Math.toRadians((double)(var9 + 90.0F))));
   }
}

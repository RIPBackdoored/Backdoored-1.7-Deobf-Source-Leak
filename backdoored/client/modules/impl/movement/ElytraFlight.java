package l.c.h.j.movement;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.o;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.s.o$c;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.util.math.MathHelper;

@w$d(
   name = "ElytraFlight",
   description = "Rockets aren't needed",
   category = c.MOVEMENT
)
public class ElytraFlight extends w {
   private j fdp;
   private j fdz;
   private j fdb;
   private j fdy;
   public static final boolean fdx;
   public static final int fdl;
   public static final boolean fdh;

   public ElytraFlight() {
      this.fdp = new o("Mode", this, o$c.fmn);
      this.fdz = new l.c.h.h.a.d.c("Boost-Speed", this, 0.05D, 0.01D, 0.2D);
      this.fdb = new l.c.h.h.a.d.c("Flight-Speed", this, 0.05D, 0.01D, 0.2D);
      this.fdy = new l.c.h.h.a.d.c("Control-Speed", this, 0.9D, 0.01D, 4.0D);
   }

   public void d() {
      if (mc.player.isElytraFlying() && this.qm()) {
         EntityPlayerSP var10000;
         float var1;
         if (this.fdp.ti() == o$c.fmn) {
            if (mc.player.capabilities.isFlying) {
               mc.player.capabilities.isFlying = false;
            }

            if (mc.player.isInWater()) {
               mc.player.connection.sendPacket(new CPacketEntityAction(mc.player, Action.START_FALL_FLYING));
            }

            var1 = (float)Math.toRadians((double)mc.player.rotationYaw);
            if (mc.gameSettings.keyBindForward.isKeyDown()) {
               var10000 = mc.player;
               var10000.motionX -= (double)MathHelper.sin(var1) * (Double)this.fdz.ti();
               var10000 = mc.player;
               var10000.motionZ += (double)MathHelper.cos(var1) * (Double)this.fdz.ti();
            }

            if (mc.gameSettings.keyBindBack.isKeyDown()) {
               var10000 = mc.player;
               var10000.motionX += (double)MathHelper.sin(var1) * (Double)this.fdz.ti();
               var10000 = mc.player;
               var10000.motionZ -= (double)MathHelper.cos(var1) * (Double)this.fdz.ti();
            }
         }

         if (this.fdp.ti() == o$c.fjk) {
            mc.player.capabilities.isFlying = true;
            mc.player.jumpMovementFactor = ((Double)this.fdb.ti()).floatValue();
            if (mc.gameSettings.keyBindJump.isKeyDown()) {
               var10000 = mc.player;
               var10000.motionY += (Double)this.fdb.ti();
            }

            if (mc.gameSettings.keyBindSneak.isKeyDown()) {
               var10000 = mc.player;
               var10000.motionY -= (Double)this.fdb.ti();
            }
         }

         if (this.fdp.ti() == o$c.fmr) {
            mc.player.motionY = 0.0D;
            mc.player.motionX = 0.0D;
            mc.player.motionZ = 0.0D;
            var1 = (float)Math.toRadians((double)mc.player.rotationYaw);
            float var2 = (float)Math.toRadians((double)mc.player.rotationPitch);
            if (mc.gameSettings.keyBindForward.isKeyDown()) {
               mc.player.motionX = -((double)(MathHelper.sin(var1) * MathHelper.cos(var2)) * (Double)this.fdy.ti());
               mc.player.motionZ = (double)(MathHelper.cos(var1) * MathHelper.cos(var2)) * (Double)this.fdy.ti();
               mc.player.motionY = -((double)MathHelper.sin(var2) * (Double)this.fdy.ti());
            }

            if (mc.gameSettings.keyBindBack.isKeyDown()) {
               mc.player.motionX = (double)(MathHelper.sin(var1) * MathHelper.cos(var2)) * (Double)this.fdy.ti();
               mc.player.motionZ = -((double)(MathHelper.cos(var1) * MathHelper.cos(var2)) * (Double)this.fdy.ti());
               mc.player.motionY = (double)MathHelper.sin(var2) * (Double)this.fdy.ti();
            }

            if (mc.gameSettings.keyBindLeft.isKeyDown()) {
               mc.player.motionZ = (double)(MathHelper.sin(var1) * MathHelper.cos(var2)) * (Double)this.fdy.ti();
               mc.player.motionX = (double)(MathHelper.cos(var1) * MathHelper.cos(var2)) * (Double)this.fdy.ti();
            }

            if (mc.gameSettings.keyBindRight.isKeyDown()) {
               mc.player.motionZ = -((double)MathHelper.sin(var1) * (Double)this.fdy.ti());
               mc.player.motionX = -((double)MathHelper.cos(var1) * (Double)this.fdy.ti());
            }

            if (mc.gameSettings.keyBindJump.isKeyDown()) {
               mc.player.motionY = (Double)this.fdy.ti();
            }

            if (mc.gameSettings.keyBindSneak.isKeyDown()) {
               mc.player.motionY = -(Double)this.fdy.ti();
            }
         }

      }
   }

   public void i() {
      if (this.fdp.ti() == o$c.fjk) {
         mc.addScheduledTask(this::eq);
      }
   }

   public void j() {
      if (this.fdp.ti() == o$c.fjk) {
         mc.player.capabilities.isFlying = false;
         mc.player.connection.sendPacket(new CPacketEntityAction(mc.player, Action.START_FALL_FLYING));
      }

   }

   // $FF: synthetic method
   private void eq() {
      if (mc.player != null && mc.player.isElytraFlying() && this.qm() && this.fdp.ti() == o$c.fjk) {
         mc.player.connection.sendPacket(new CPacketEntityAction(mc.player, Action.START_FALL_FLYING));
      }

   }
}

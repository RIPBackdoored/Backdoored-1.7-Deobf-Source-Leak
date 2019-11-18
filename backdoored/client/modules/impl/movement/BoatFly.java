package l.c.h.j.movement;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.client.CPacketPlayer.PositionRotation;
import net.minecraft.util.math.MathHelper;

@w$d(
   name = "BoatFly",
   description = "Experimental boatfly",
   category = c.MOVEMENT
)
public class BoatFly extends w {
   public static final boolean fjt;
   public static final int fje;
   public static final boolean fjv;

   public void d() {
      if (this.qm()) {
         if (mc.player.isRiding()) {
            boolean var2 = mc.gameSettings.keyBindForward.isKeyDown();
            boolean var3 = mc.gameSettings.keyBindLeft.isKeyDown();
            boolean var4 = mc.gameSettings.keyBindRight.isKeyDown();
            boolean var5 = mc.gameSettings.keyBindBack.isKeyDown();
            boolean var10000;
            boolean var1;
            if (var3 && var4) {
               if (var2) {
                  var10000 = false;
               }

               if (var5) {
                  var10000 = true;
               }

               var1 = true;
            }

            if (var2 && var5) {
               if (var3) {
                  var10000 = true;
               }

               if (var4) {
                  var10000 = true;
               }

               var1 = true;
            }

            if (var3) {
               var10000 = true;
            }

            if (var4) {
               var10000 = true;
            }

            int var10 = 0;
            if (var2) {
               var10 /= 2;
            }

            if (var5) {
               var10 = 180 - var10 / 2;
            }

            if (var10 != -1 && var5) {
               float var6 = mc.player.rotationYaw + (float)var10;
               mc.player.getRidingEntity().motionX = this.k(var6) * 0.20000000298023224D;
               mc.player.getRidingEntity().motionZ = this.f(var6) * 0.20000000298023224D;
            }

            mc.player.motionY = 0.0D;
            mc.player.getRidingEntity().motionY = 0.0D;
            mc.player.connection.sendPacket(new PositionRotation(mc.player.getRidingEntity().posX + mc.player.getRidingEntity().motionX, mc.player.getRidingEntity().posY, mc.player.getRidingEntity().posZ + mc.player.getRidingEntity().motionZ, mc.player.rotationYaw, mc.player.rotationPitch, false));
            mc.player.getRidingEntity().motionY = 0.0D;
            if (mc.gameSettings.keyBindJump.isKeyDown()) {
               mc.player.getRidingEntity().motionY = 0.3D;
            }

            if (mc.gameSettings.keyBindSprint.isKeyDown()) {
               mc.player.getRidingEntity().motionY = -0.3D;
            }

            mc.player.connection.sendPacket(new CPacketVehicleMove());
            mc.player.connection.sendPacket(new CPacketSteerBoat(true, true));
            mc.player.connection.sendPacket(new PositionRotation(mc.player.getRidingEntity().posX + mc.player.getRidingEntity().motionX, mc.player.getRidingEntity().posY - 42069.0D, mc.player.getRidingEntity().posZ + mc.player.getRidingEntity().motionZ, mc.player.rotationYaw, mc.player.rotationPitch, true));
            mc.player.getRidingEntity().posY -= 42069.0D;
            mc.player.connection.sendPacket(new CPacketVehicleMove());
            mc.player.connection.sendPacket(new CPacketSteerBoat(true, true));
         }

      }
   }

   private double[] u(int var1) {
      return new double[]{(double)mc.player.rotationYaw, (double)var1};
   }

   public double k(float var1) {
      return (double)MathHelper.sin(-var1 * 0.017453292F);
   }

   public double f(float var1) {
      return (double)MathHelper.cos(var1 * 0.017453292F);
   }
}

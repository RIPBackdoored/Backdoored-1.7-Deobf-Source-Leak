package l.c.h.j.player;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.k;
import l.c.x.d.a;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Scaffold",
   description = "Automatically bridges for you",
   category = c.PLAYER
)
public class Scaffold extends w {
   private j qkz = new i("Radius", this, 0, 0, 2);
   private j qkb = new f("Down", this, true);
   private j qky = new f("Tower", this, true);
   public static final boolean qkx;
   public static final int qkl;
   public static final boolean qkh;

   public void d() {
      if (this.qm()) {
         int var1 = mc.player.inventory.currentItem;
         int var2 = k.ee();
         if (var2 != -1) {
            mc.player.inventory.currentItem = var2;
         }

         a.m("No blocks found in hotbar!", "red");
         this.f(false);
      }
   }

   @SubscribeEvent
   public void k(LivingUpdateEvent var1) {
      if (this.qm() && (Boolean)this.qkb.ti()) {
         if (var1.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer var2 = (EntityPlayer)var1.getEntityLiving();
            if (var2.isSneaking()) {
               if (Math.abs(mc.player.posX) - (double)((int)Math.abs(mc.player.posX)) < 0.1D || Math.abs(mc.player.posX) - (double)((int)Math.abs(mc.player.posX)) > 0.9D) {
                  mc.player.posX = (double)Math.round(Math.abs(mc.player.posX) - (double)((int)Math.abs(mc.player.posX)));
               }

               if (Math.abs(mc.player.posZ) - (double)((int)Math.abs(mc.player.posZ)) < 0.1D || Math.abs(mc.player.posZ) - (double)((int)Math.abs(mc.player.posZ)) > 0.9D) {
                  mc.player.posZ = (double)Math.round(Math.abs(mc.player.posZ) - (double)((int)Math.abs(mc.player.posZ)));
               }
            }
         }

      }
   }

   @SubscribeEvent
   public void k(LivingJumpEvent var1) {
      if (this.qm() && (Boolean)this.qky.ti()) {
         EntityPlayerSP var10000 = mc.player;
         var10000.motionY += 0.1D;
      }

   }
}

package l.c.h.j.combat;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.g;
import l.c.h.j.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.g.x;
import l.c.x.k;
import l.c.x.d.a;
import net.minecraft.init.Items;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

@w$d(
   name = "Auto Bed Bomb",
   description = "Automatically suicide bomb with beds",
   category = c.COMBAT
)
public class AutoBedBomb extends w {
   private final j fys = new g("Range", this, 5.0F, 1.0F, 10.0F);
   public static final int fym;
   public static final boolean fyj;

   public void i() {
      if (mc.objectMouseOver != null && mc.objectMouseOver.sideHit != null) {
         w var1 = i.k(x.class);
         boolean var2 = false;
         if (var1 != null) {
            var2 = var1.qm();
            var1.f(false);
         }

         this.f(false);
         if (var1 != null) {
            var1.f(var2);
         }

      }
   }

   private boolean tz() {
      BlockPos var1 = null;
      if (mc.objectMouseOver != null && mc.objectMouseOver.sideHit != null) {
         var1 = mc.objectMouseOver.getBlockPos().offset(mc.objectMouseOver.sideHit);
         int var2 = k.f(Items.BED);
         if (var2 == -1) {
            a.m("A bed was not found in your hotbar!", "red");
            this.f(false);
            return false;
         } else {
            mc.player.inventory.currentItem = var2;
            k.t(var1);
            mc.player.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(var1, EnumFacing.UP, EnumHand.MAIN_HAND, 0.5F, 0.5F, 0.5F));
            return true;
         }
      } else {
         return false;
      }
   }
}

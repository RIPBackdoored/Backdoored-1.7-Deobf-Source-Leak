package l.c.h.j.player;

import l.c.q;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.dp;
import l.c.x.k;
import l.c.x.d.a;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Auto Wither",
   description = "2 tick withers",
   category = c.PLAYER
)
public class AutoWither extends w {
   private Item item;
   private Item item;
   private BlockPos blockPos;
   private int fic;
   public static final boolean fio;
   public static final int fip;
   public static final boolean fiz;

   public AutoWither() {
      this.item = (new ItemStack(Blocks.SOUL_SAND)).getItem();
      this.item = (new ItemStack(Blocks.SKULL)).getItem();
      this.blockPos = new BlockPos(0, 0, 0);
      this.fic = -1;
   }

   public void i() {
      ++this.fic;
      this.tg();
      ++this.fic;
   }

   @SubscribeEvent
   public void k(dp var1) {
      if (this.qm() && this.fic <= 1) {
         if (this.fic == 0) {
            this.tg();
         }

         if (this.fic == 1) {
            this.tw();
            this.fic = -1;
            this.f(false);
         } else {
            ++this.fic;
         }
      } else {
         this.fic = -1;
         this.f(false);
      }
   }

   private boolean tg() {
      if (mc.objectMouseOver == null || mc.objectMouseOver.sideHit == null) {
         this.blockPos = mc.player.getPosition().add(2, 0, 0);
      }

      this.blockPos = mc.objectMouseOver.getBlockPos().offset(mc.objectMouseOver.sideHit);
      int var1 = k.f(this.item);
      int var2 = this.tn();
      if (var2 != -1 && var1 != -1) {
         mc.player.inventory.currentItem = k.f(this.item);
         k.t(this.blockPos);
         if (tr()) {
            k.t(this.blockPos.add(0, 1, 0));
            k.t(this.blockPos.add(1, 1, 0));
            k.t(this.blockPos.add(-1, 1, 0));
         }

         k.t(this.blockPos.add(0, 1, 0));
         k.t(this.blockPos.add(0, 1, 1));
         k.t(this.blockPos.add(0, 1, -1));
         return true;
      } else {
         if (var2 == -1) {
            String var10000 = "Wither Skull";
         }

         String var3 = "Soul Sand";
         a.m(var3 + " was not found in your hotbar!", "red");
         this.f(false);
         return false;
      }
   }

   private boolean tw() {
      int var1 = this.tn();
      if (var1 != -1) {
         mc.player.inventory.currentItem = var1;
         if (tr()) {
            k.t(this.blockPos.add(0, 2, 0));
            k.t(this.blockPos.add(1, 2, 0));
            k.t(this.blockPos.add(-1, 2, 0));
         }

         k.t(this.blockPos.add(0, 2, 0));
         k.t(this.blockPos.add(0, 2, 1));
         k.t(this.blockPos.add(0, 2, -1));
         return true;
      } else {
         return false;
      }
   }

   private int tn() {
      byte var1 = 0;
      if (var1 < 9) {
         ItemStack var2 = q.mc.player.inventory.getStackInSlot(var1);
         if (var2.getItem().getItemStackDisplayName(var2).equals("Wither Skeleton Skull")) {
            return var1;
         }

         int var6 = var1 + 1;
      }

      return -1;
   }

   public static boolean tr() {
      EnumFacing var0 = mc.player.getHorizontalFacing();
      return var0 != EnumFacing.EAST && var0 != EnumFacing.WEST;
   }
}

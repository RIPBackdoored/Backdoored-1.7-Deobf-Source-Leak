package l.c.h.j.combat;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.h.a.o;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.j.g$c;
import l.c.x.k;
import l.c.x.d.a;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

@w$d(
   name = "Auto32k",
   description = "Instantly places shulker and hopper and grabs a 32k sword",
   category = c.COMBAT
)
public class Auto32k extends w {
   private j ftc;
   private j fto;
   private boolean ftp;
   private boolean ftz;
   private BlockPos blockPos;
   private int fty;
   public static final boolean ftx;
   public static final int ftl;
   public static final boolean fth;

   public Auto32k() {
      this.ftc = new o("Mode", this, g$c.fia);
      this.fto = new f("SecretClose", this, false);
      this.ftp = false;
      this.ftz = false;
   }

   public void i() {
      if (mc.objectMouseOver != null && mc.objectMouseOver.sideHit != null) {
         if (!this.tz()) {
            this.f(false);
         }

      }
   }

   private boolean tz() {
      this.blockPos = null;
      if (mc.objectMouseOver != null && mc.objectMouseOver.sideHit != null) {
         this.blockPos = mc.objectMouseOver.getBlockPos().offset(mc.objectMouseOver.sideHit);
         if (k.f(Item.getItemById(154)) == -1) {
            a.m("A hopper was not found in your hotbar!", "red");
            this.f(false);
            return false;
         } else {
            short var1 = 219;
            if (var1 <= 234) {
               if (k.f(Item.getItemById(var1)) != -1) {
                  ;
               }

               if (var1 == 234) {
                  a.m("A shulker was not found in your hotbar!", "red");
                  this.f(false);
                  return false;
               }

               int var5 = var1 + 1;
            }

            if (this.ftc.ti() == g$c.fih) {
               this.tx();
            }

            if (this.ftc.ti() == g$c.fia) {
               this.tb();
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public void d() {
      if (this.qm()) {
         int var6;
         if (this.ftp || !e(mc.player.inventory.getCurrentItem())) {
            byte var1 = 0;
            if (var1 < mc.player.openContainer.inventorySlots.size()) {
               if (e(((Slot)mc.player.openContainer.inventorySlots.get(var1)).getStack())) {
                  mc.playerController.windowClick(mc.player.openContainer.windowId, var1, 0, ClickType.QUICK_MOVE, mc.player);
                  byte var2 = 0;
                  if (var2 < 9) {
                     if (e(mc.player.inventory.getStackInSlot(var2))) {
                        mc.player.inventory.currentItem = var2;
                     }

                     int var8 = var2 + 1;
                  }

                  if ((Boolean)this.fto.ti()) {
                     mc.player.closeScreen();
                  }

                  this.ftp = false;
                  this.f(false);
                  return;
               }

               var6 = var1 + 1;
            }
         }

         if (this.ftz && mc.player.openContainer != null) {
            short var7 = 219;
            if (var7 <= 234) {
               if (k.f(Item.getItemById(var7)) != -1) {
                  mc.playerController.windowClick(mc.player.inventoryContainer.windowId, k.f(Item.getItemById(var7)), 0, ClickType.QUICK_MOVE, mc.player);
                  this.ftz = false;
                  mc.player.closeScreen();
                  this.ty();
                  return;
               }

               var6 = var7 + 1;
            }
         }

      }
   }

   private void tb() {
      if (k.ee() == -1) {
         a.m("No blocks found in hotbar!", "red");
         this.f(false);
      } else if (k.f(Item.getItemById(23)) == -1) {
         a.m("No dispenser found in hotbar!", "red");
         this.f(false);
      } else if (k.f(Item.getItemById(152)) == -1) {
         a.m("No redstone block found in hotbar!", "red");
         this.f(false);
      } else {
         mc.player.inventory.currentItem = k.f(Item.getItemById(154));
         k.t(this.blockPos);
         this.fty = MathHelper.floor((double)(mc.player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
         switch(this.fty) {
         case 0:
            new BlockPos(this.blockPos.add(0, 0, 1));
         case 1:
            new BlockPos(this.blockPos.add(-1, 0, 0));
         case 2:
            new BlockPos(this.blockPos.add(0, 0, -1));
         default:
            BlockPos var1 = new BlockPos(this.blockPos.add(1, 0, 0));
            mc.player.inventory.currentItem = k.ee();
            k.t(var1);
            switch(this.fty) {
            case 0:
               new BlockPos(this.blockPos.add(0, 1, 1));
            case 1:
               new BlockPos(this.blockPos.add(-1, 1, 0));
            case 2:
               new BlockPos(this.blockPos.add(0, 1, -1));
            default:
               var1 = new BlockPos(this.blockPos.add(1, 1, 0));
               mc.player.inventory.currentItem = k.f(Item.getItemById(23));
               k.t(var1);
               mc.player.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(var1, EnumFacing.UP, EnumHand.MAIN_HAND, 0.5F, 0.5F, 0.5F));
               this.ftz = true;
            }
         }
      }
   }

   private void ty() {
      switch(this.fty) {
      case 0:
         new BlockPos(this.blockPos.add(0, 2, 1));
      case 1:
         new BlockPos(this.blockPos.add(-1, 2, 0));
      case 2:
         new BlockPos(this.blockPos.add(0, 2, -1));
      default:
         BlockPos var1 = new BlockPos(this.blockPos.add(1, 2, 0));
         mc.player.inventory.currentItem = k.f(Item.getItemById(152));
         k.t(var1);
         this.tl();
      }
   }

   private void tx() {
      mc.player.inventory.currentItem = k.f(Item.getItemById(154));
      k.t(this.blockPos);
      short var1 = 219;
      if (var1 <= 234) {
         if (k.f(Item.getItemById(var1)) != -1) {
            mc.player.inventory.currentItem = k.f(Item.getItemById(var1));
         }

         int var5 = var1 + 1;
      }

      k.t(new BlockPos(this.blockPos.getX(), this.blockPos.getY() + 1, this.blockPos.getZ()));
      this.tl();
   }

   private void tl() {
      if ((Boolean)this.fto.ti()) {
         w.k("Secret Close", false);
         w.k("Secret Close", true);
      }

      mc.player.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(this.blockPos, EnumFacing.UP, EnumHand.MAIN_HAND, 0.5F, 0.5F, 0.5F));
      this.ftp = true;
   }

   static boolean e(ItemStack var0) {
      if (var0 == null) {
         return false;
      } else if (var0.getTagCompound() == null) {
         return false;
      } else if (var0.getEnchantmentTagList().getTagType() == 0) {
         return false;
      } else {
         NBTTagList var1 = (NBTTagList)var0.getTagCompound().getTag("ench");
         byte var2 = 0;
         if (var2 < var1.tagCount()) {
            NBTTagCompound var3 = var1.getCompoundTagAt(var2);
            if (var3.getInteger("id") == 16) {
               int var4 = var3.getInteger("lvl");
               if (var4 >= 16) {
                  return true;
               }
            } else {
               int var8 = var2 + 1;
            }
         }

         return false;
      }
   }
}

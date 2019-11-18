package l.c.v;

import l.c.x.d.a;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class l extends d {
   boolean fxj = false;
   int fxc = 0;
   boolean fxo = false;
   int fxp = 0;
   BlockPos[] blockPos;
   public static final boolean fxb;
   public static final int fxy;
   public static final boolean fxx;

   public l() {
      super("nomadbase", "fitbase", "autonomadbase");
   }

   public boolean k(String[] var1) {
      if (var1.length == 0) {
         this.fxp = 0;
         this.fxj = true;
      }

      if (var1.length > 1 && var1[0].equalsIgnoreCase("delay") || var1[0].equalsIgnoreCase("setdelay")) {
         this.fxc = Integer.valueOf(var1[1]);
         if (this.fxc == 0) {
            this.fxo = false;
         }

         this.fxo = true;
      }

      return true;
   }

   @SubscribeEvent
   public void f(ClientTickEvent var1) {
      if (this.fxj) {
         if (this.fxo && this.fxp % this.fxc != 0) {
            ++this.fxp;
         } else {
            BlockPos[] var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(1, -1, -1)), new BlockPos(this.mc.player.getPosition().add(-1, -1, 1)), new BlockPos(this.mc.player.getPosition().add(1, -1, 1)), new BlockPos(this.mc.player.getPosition().add(-1, -1, -1)), new BlockPos(this.mc.player.getPosition().add(-1, -1, -1)), new BlockPos(this.mc.player.getPosition().add(1, -1, 1)), new BlockPos(this.mc.player.getPosition().add(-1, -1, 1)), new BlockPos(this.mc.player.getPosition().add(1, -1, -1)), new BlockPos(this.mc.player.getPosition().add(0, -1, -2)), new BlockPos(this.mc.player.getPosition().add(1, -1, -2)), new BlockPos(this.mc.player.getPosition().add(-1, -1, -2)), new BlockPos(this.mc.player.getPosition().add(0, -1, 2)), new BlockPos(this.mc.player.getPosition().add(1, -1, 2)), new BlockPos(this.mc.player.getPosition().add(-1, -1, 2)), new BlockPos(this.mc.player.getPosition().add(2, -1, 0)), new BlockPos(this.mc.player.getPosition().add(2, -1, 1)), new BlockPos(this.mc.player.getPosition().add(2, -1, -1)), new BlockPos(this.mc.player.getPosition().add(-2, -1, 0)), new BlockPos(this.mc.player.getPosition().add(-2, -1, 1)), new BlockPos(this.mc.player.getPosition().add(-2, -1, -1))};
            var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(2, 1, 1)), new BlockPos(this.mc.player.getPosition().add(2, 1, -1)), new BlockPos(this.mc.player.getPosition().add(-2, 1, 1)), new BlockPos(this.mc.player.getPosition().add(-2, 1, -1)), new BlockPos(this.mc.player.getPosition().add(1, 1, 2)), new BlockPos(this.mc.player.getPosition().add(-1, 1, 2)), new BlockPos(this.mc.player.getPosition().add(1, 1, -2)), new BlockPos(this.mc.player.getPosition().add(-1, 1, -2))};
            var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(2, 2, 1)), new BlockPos(this.mc.player.getPosition().add(2, 2, -1)), new BlockPos(this.mc.player.getPosition().add(-2, 2, 1)), new BlockPos(this.mc.player.getPosition().add(-2, 2, -1)), new BlockPos(this.mc.player.getPosition().add(1, 2, 2)), new BlockPos(this.mc.player.getPosition().add(-1, 2, 2)), new BlockPos(this.mc.player.getPosition().add(1, 2, -2)), new BlockPos(this.mc.player.getPosition().add(-1, 2, -2))};
            var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(2, 2, 0)), new BlockPos(this.mc.player.getPosition().add(-2, 2, 0)), new BlockPos(this.mc.player.getPosition().add(0, 2, 2)), new BlockPos(this.mc.player.getPosition().add(0, 2, -2))};
            int var6 = MathHelper.floor((double)(this.mc.player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(2, 0, 0)), new BlockPos(this.mc.player.getPosition().add(2, 0, 1)), new BlockPos(this.mc.player.getPosition().add(2, 0, -1)), new BlockPos(this.mc.player.getPosition().add(-2, 0, 0)), new BlockPos(this.mc.player.getPosition().add(-2, 0, 1)), new BlockPos(this.mc.player.getPosition().add(-2, 0, -1)), new BlockPos(this.mc.player.getPosition().add(0, 0, 2)), new BlockPos(this.mc.player.getPosition().add(1, 0, 2)), new BlockPos(this.mc.player.getPosition().add(-1, 0, 2)), new BlockPos(this.mc.player.getPosition().add(1, 0, -2)), new BlockPos(this.mc.player.getPosition().add(-1, 0, -2))};
            var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(0, 3, -2)), new BlockPos(this.mc.player.getPosition().add(1, 3, -2)), new BlockPos(this.mc.player.getPosition().add(-1, 3, -2)), new BlockPos(this.mc.player.getPosition().add(0, 3, -1)), new BlockPos(this.mc.player.getPosition().add(1, 3, -1)), new BlockPos(this.mc.player.getPosition().add(-1, 3, -1)), new BlockPos(this.mc.player.getPosition().add(0, 3, 0)), new BlockPos(this.mc.player.getPosition().add(1, 3, 0)), new BlockPos(this.mc.player.getPosition().add(-1, 3, 0)), new BlockPos(this.mc.player.getPosition().add(0, 3, 1)), new BlockPos(this.mc.player.getPosition().add(1, 3, 1)), new BlockPos(this.mc.player.getPosition().add(-1, 3, 1))};
            if (var6 == 1) {
               var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(2, 0, 1)), new BlockPos(this.mc.player.getPosition().add(2, 0, -1)), new BlockPos(this.mc.player.getPosition().add(-2, 0, 0)), new BlockPos(this.mc.player.getPosition().add(-2, 0, 1)), new BlockPos(this.mc.player.getPosition().add(-2, 0, -1)), new BlockPos(this.mc.player.getPosition().add(0, 0, 2)), new BlockPos(this.mc.player.getPosition().add(1, 0, 2)), new BlockPos(this.mc.player.getPosition().add(-1, 0, 2)), new BlockPos(this.mc.player.getPosition().add(0, 0, -2)), new BlockPos(this.mc.player.getPosition().add(1, 0, -2)), new BlockPos(this.mc.player.getPosition().add(-1, 0, -2))};
               var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(2, 3, 0)), new BlockPos(this.mc.player.getPosition().add(2, 3, 1)), new BlockPos(this.mc.player.getPosition().add(2, 3, -1)), new BlockPos(this.mc.player.getPosition().add(1, 3, 0)), new BlockPos(this.mc.player.getPosition().add(1, 3, 1)), new BlockPos(this.mc.player.getPosition().add(1, 3, -1)), new BlockPos(this.mc.player.getPosition().add(0, 3, 0)), new BlockPos(this.mc.player.getPosition().add(0, 3, 1)), new BlockPos(this.mc.player.getPosition().add(0, 3, -1)), new BlockPos(this.mc.player.getPosition().add(-1, 3, 0)), new BlockPos(this.mc.player.getPosition().add(-1, 3, 1)), new BlockPos(this.mc.player.getPosition().add(-1, 3, -1))};
            }

            if (var6 == 2) {
               var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(2, 0, 0)), new BlockPos(this.mc.player.getPosition().add(2, 0, 1)), new BlockPos(this.mc.player.getPosition().add(2, 0, -1)), new BlockPos(this.mc.player.getPosition().add(-2, 0, 0)), new BlockPos(this.mc.player.getPosition().add(-2, 0, 1)), new BlockPos(this.mc.player.getPosition().add(-2, 0, -1)), new BlockPos(this.mc.player.getPosition().add(1, 0, 2)), new BlockPos(this.mc.player.getPosition().add(-1, 0, 2)), new BlockPos(this.mc.player.getPosition().add(0, 0, -2)), new BlockPos(this.mc.player.getPosition().add(1, 0, -2)), new BlockPos(this.mc.player.getPosition().add(-1, 0, -2))};
               var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(0, 3, 2)), new BlockPos(this.mc.player.getPosition().add(1, 3, 2)), new BlockPos(this.mc.player.getPosition().add(-1, 3, 2)), new BlockPos(this.mc.player.getPosition().add(0, 3, 1)), new BlockPos(this.mc.player.getPosition().add(1, 3, 1)), new BlockPos(this.mc.player.getPosition().add(-1, 3, 1)), new BlockPos(this.mc.player.getPosition().add(0, 3, 0)), new BlockPos(this.mc.player.getPosition().add(1, 3, 0)), new BlockPos(this.mc.player.getPosition().add(-1, 3, 0)), new BlockPos(this.mc.player.getPosition().add(0, 3, -1)), new BlockPos(this.mc.player.getPosition().add(1, 3, -1)), new BlockPos(this.mc.player.getPosition().add(-1, 3, -1))};
            }

            var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(2, 0, 0)), new BlockPos(this.mc.player.getPosition().add(2, 0, 1)), new BlockPos(this.mc.player.getPosition().add(2, 0, -1)), new BlockPos(this.mc.player.getPosition().add(-2, 0, 1)), new BlockPos(this.mc.player.getPosition().add(-2, 0, -1)), new BlockPos(this.mc.player.getPosition().add(0, 0, 2)), new BlockPos(this.mc.player.getPosition().add(1, 0, 2)), new BlockPos(this.mc.player.getPosition().add(-1, 0, 2)), new BlockPos(this.mc.player.getPosition().add(0, 0, -2)), new BlockPos(this.mc.player.getPosition().add(1, 0, -2)), new BlockPos(this.mc.player.getPosition().add(-1, 0, -2))};
            var10000 = new BlockPos[]{new BlockPos(this.mc.player.getPosition().add(-2, 3, 0)), new BlockPos(this.mc.player.getPosition().add(-2, 3, 1)), new BlockPos(this.mc.player.getPosition().add(-2, 3, -1)), new BlockPos(this.mc.player.getPosition().add(-1, 3, 0)), new BlockPos(this.mc.player.getPosition().add(-1, 3, 1)), new BlockPos(this.mc.player.getPosition().add(-1, 3, -1)), new BlockPos(this.mc.player.getPosition().add(0, 3, 0)), new BlockPos(this.mc.player.getPosition().add(0, 3, 1)), new BlockPos(this.mc.player.getPosition().add(0, 3, -1)), new BlockPos(this.mc.player.getPosition().add(1, 3, 0)), new BlockPos(this.mc.player.getPosition().add(1, 3, 1)), new BlockPos(this.mc.player.getPosition().add(1, 3, -1))};
            byte var10 = -1;
            byte var11 = 0;
            if (var11 < 9) {
               if (this.mc.player.inventory.getStackInSlot(var11) != ItemStack.EMPTY && this.mc.player.inventory.getStackInSlot(var11).getItem() instanceof ItemBlock) {
                  if (!Block.getBlockFromItem(this.mc.player.inventory.getStackInSlot(var11).getItem()).getDefaultState().isFullBlock()) {
                     ;
                  }

                  var10 = var11;
               }

               int var18 = var11 + 1;
            }

            if (var10 != -1) {
               this.mc.player.inventory.currentItem = var10;
            }

            a.m("No blocks found in hotbar!", "red");
            this.fxj = false;
         }
      }
   }

   public String v() {
      return "-nomadbase or -nomadbase setdelay <0/1/2/..> (6 is the best)";
   }
}

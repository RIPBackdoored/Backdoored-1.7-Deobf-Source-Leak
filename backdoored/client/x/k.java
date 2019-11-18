package l.c.x;

import l.c.q;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class k implements q {
   public static final boolean fjp;
   public static final int fjz;
   public static final boolean fjb;

   public static void t(BlockPos var0) {
      k(EnumHand.MAIN_HAND, var0);
   }

   public static void k(EnumHand param0, BlockPos param1) {
      // $FF: Couldn't be decompiled
   }

   public static int f(Block var0) {
      return f((new ItemStack(var0)).getItem());
   }

   public static int f(Item param0) {
      // $FF: Couldn't be decompiled
   }

   public static double[] k(double param0, double param2, double param4, EntityPlayer param6) {
      // $FF: Couldn't be decompiled
   }

   public static void k(float var0, float var1) {
      mc.player.rotationYaw = var0;
      mc.player.rotationPitch = var1;
   }

   public static void k(double[] var0) {
      mc.player.rotationYaw = (float)var0[0];
      mc.player.rotationPitch = (float)var0[1];
   }

   public static void e(BlockPos var0) {
      k(k((double)var0.getX(), (double)var0.getY(), (double)var0.getZ(), mc.player));
   }

   public static BlockPos k(EntityPlayer var0, int var1, int var2, int var3) {
      int[] var4 = new int[]{(int)var0.posX, (int)var0.posY, (int)var0.posZ};
      if (var0.posX < 0.0D && var0.posZ < 0.0D) {
         new BlockPos(var4[0] + var1 - 1, var4[1] + var2, var4[2] + var3 - 1);
      }

      if (var0.posX < 0.0D && var0.posZ > 0.0D) {
         new BlockPos(var4[0] + var1 - 1, var4[1] + var2, var4[2] + var3);
      }

      if (var0.posX > 0.0D && var0.posZ < 0.0D) {
         new BlockPos(var4[0] + var1, var4[1] + var2, var4[2] + var3 - 1);
         throw null;
      } else {
         BlockPos var5 = new BlockPos(var4[0] + var1, var4[1] + var2, var4[2] + var3);
         return var5;
      }
   }

   public static int ee() {
      byte var0 = 0;
      if (var0 < 9) {
         if (mc.player.inventory.getStackInSlot(var0) != ItemStack.EMPTY && mc.player.inventory.getStackInSlot(var0).getItem() instanceof ItemBlock) {
            if (!Block.getBlockFromItem(mc.player.inventory.getStackInSlot(var0).getItem()).getDefaultState().isFullBlock()) {
               ;
            }

            return var0;
         }

         int var4 = var0 + 1;
      }

      return -1;
   }
}

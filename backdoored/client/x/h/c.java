package l.c.x.h;

import l.c.q;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class c implements q {
   public static final boolean hz;
   public static final int hb;
   public static final boolean hy;

   public static int k(Item var0, boolean var1) {
      byte var2;
      if (var1) {
         var2 = 0;
      }

      if (var2 <= 44) {
         if (mc.player.inventoryContainer.getSlot(var2).getStack().getItem() == var0) {
            return var2;
         }

         int var3 = var2 + 1;
      }

      return -1;
   }

   public static void k(Block var0, boolean var1) {
   }

   public static int f(Item var0, boolean var1) {
      return k(var0, var1, c$d.ef);
   }

   public static void k(Block var0, boolean var1, c$d var2) {
      k((new ItemStack(var0)).getItem(), var1, var2);
   }

   public static int k(Item var0, boolean var1, c$d var2) {
      int var3 = 0;
      byte var4 = 9;
      if (var1) {
         var4 = 0;
      }

      if (var4 <= 44) {
         ItemStack var6 = mc.player.inventoryContainer.getSlot(var4).getStack();
         if (var6.getItem() == var0) {
            if (var2 == c$d.ef) {
               ++var3;
            }

            var3 += var6.getCount();
         }

         int var5 = var4 + 1;
      }

      return var3;
   }
}

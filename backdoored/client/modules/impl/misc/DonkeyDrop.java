package l.c.h.j.misc;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.ContainerHorseInventory;
import net.minecraft.item.ItemStack;

@w$d(
   name = "Donkey Drop",
   description = "Drop all items in donkeys inv",
   category = c.MISC
)
public class DonkeyDrop extends w {
   public static final boolean rk;
   public static final int rf;
   public static final boolean rq;

   public void d() {
      if (this.qm() && mc.player.getRidingEntity() instanceof AbstractHorse && mc.player.openContainer instanceof ContainerHorseInventory) {
         byte var1 = 2;
         if (var1 < 17) {
            ItemStack var2 = (ItemStack)mc.player.openContainer.getInventory().get(var1);
            if (!var2.isEmpty() && var2.getItem() != Items.AIR) {
               mc.playerController.windowClick(mc.player.openContainer.windowId, var1, 0, ClickType.PICKUP, mc.player);
               mc.playerController.windowClick(mc.player.openContainer.windowId, -999, 0, ClickType.PICKUP, mc.player);
            }

            int var6 = var1 + 1;
         }
      }

      this.f(false);
   }
}

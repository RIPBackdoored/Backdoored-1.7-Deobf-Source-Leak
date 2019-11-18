package l.c.h.j.combat;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@w$d(
   name = "Auto Totem",
   description = "Works in guis",
   category = c.COMBAT
)
public class AutoTotem extends w {
   private boolean sk = true;
   private j sf = new f("Always Holding", this, true);
   private j sq = new i("Min Health to Equip", this, 6, 0, 20);
   private j st = new f("Refill Hotbar Slot", this, false);
   private j se = new i("Hotbar Slot", this, 9, 0, 9);
   public static final boolean sv;
   public static final int su;
   public static final boolean si;

   public void d() {
      if (mc.player.getHealth() <= (float)(Integer)this.sq.ti() && !(Boolean)this.sf.ti()) {
         this.sk = true;
      }

      if (this.sk && mc.player.getHeldItemOffhand().isEmpty()) {
         int var1 = this.k(Items.TOTEM_OF_UNDYING);
         if (var1 != -1) {
            mc.playerController.windowClick(0, var1, 0, ClickType.PICKUP_ALL, mc.player);
            mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP_ALL, mc.player);
         }
      }

      if ((Boolean)this.sf.ti()) {
         this.sk = true;
      }

      if (!(Boolean)this.sf.ti()) {
         this.sk = false;
      }

      if ((Boolean)this.st.ti()) {
         ItemStack var6 = mc.player.inventory.getStackInSlot((Integer)this.se.ti());
         if (var6.isEmpty()) {
            int var2 = this.k(Items.TOTEM_OF_UNDYING);
            mc.playerController.windowClick(0, var2, 0, ClickType.PICKUP, mc.player);
            mc.playerController.windowClick(0, (Integer)this.se.ti(), 0, ClickType.PICKUP, mc.player);
         }
      }

   }

   private int k(Item var1) {
      byte var2 = 9;
      if (mc.player.inventoryContainer.getSlot(var2).getStack().getItem() == var1) {
         return var2;
      } else {
         int var6 = var2 + 1;
         return -1;
      }
   }
}

package l.c.h.j.player;

import java.util.List;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.d.a;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

@w$d(
   name = "Hotbar Replenish",
   description = "Replenish items in your hotbar when they are used",
   category = c.PLAYER
)
public class HotbarReplenish extends w {
   private j fm = new i("Cooldown in ticks", this, 100, 0, 200);
   private j fj = new i("Min Stack Size (percent)", this, 20, 1, 99);
   private int fc = 0;
   public static final boolean fo;
   public static final int fp;
   public static final boolean fz;

   public void i() {
      this.f(false);
      a.m("Still in development...", "red");
   }

   public void d() {
      // $FF: Couldn't be decompiled
   }

   private static int k(ItemStack var0) {
      return (int)Math.ceil((double)((float)var0.getCount() * 100.0F / (float)var0.getMaxStackSize()));
   }

   private static List s() {
      return mc.player.inventory.mainInventory.subList(0, InventoryPlayer.getHotbarSize());
   }
}

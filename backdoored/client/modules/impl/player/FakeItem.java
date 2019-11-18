package l.c.h.j.player;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.s.g;
import net.minecraft.inventory.ClickType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Fake Item",
   description = "Always be holding your first item",
   category = c.PLAYER
)
public class FakeItem extends w {
   private boolean bq;
   public static final int bt;
   public static final boolean be;

   @SubscribeEvent
   public void f(g param1) {
      // $FF: Couldn't be decompiled
   }

   private static void fs() {
      mc.playerController.windowClick(mc.player.inventoryContainer.windowId, 9, mc.player.inventory.currentItem, ClickType.SWAP, mc.player);
   }
}

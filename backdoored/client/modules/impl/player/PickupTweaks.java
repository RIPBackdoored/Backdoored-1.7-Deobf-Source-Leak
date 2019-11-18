package l.c.h.j.player;

import java.util.Iterator;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;

@w$d(
   name = "Pickup Tweaks",
   description = "Improve item picking up",
   category = c.PLAYER
)
public class PickupTweaks extends w {
   public static final boolean hx;
   public static final int hl;
   public static final boolean hh;

   public void d() {
      if (this.qm()) {
         Iterator var1 = mc.world.loadedEntityList.iterator();
         if (var1.hasNext()) {
            Entity var2 = (Entity)var1.next();
            if (var2 instanceof EntityItem) {
               EntityItem var3 = (EntityItem)var2;
               var2.setAlwaysRenderNameTag(true);
               int var4 = var3.getAge();
               int var5 = var3.lifespan;
               double var6 = (double)(var4 / var5);
               var6 *= 100.0D;
               var2.setCustomNameTag(String.valueOf(var6));
            }
         }
      }

   }
}

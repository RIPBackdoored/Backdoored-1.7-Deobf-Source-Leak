package l.c.h.j.render;

import java.util.Iterator;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.n.h;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityTameable;

@w$d(
   name = "Mob Owner",
   description = "Show you owners of mobs",
   category = c.RENDER
)
public class MobOwner extends w {
   public static final boolean fht;
   public static final int fhe;
   public static final boolean fhv;

   public void d() {
      if (this.qm()) {
         Iterator var1 = mc.world.loadedEntityList.iterator();
         if (var1.hasNext()) {
            Entity var2 = (Entity)var1.next();
            if (var2 instanceof EntityTameable) {
               EntityTameable var3 = (EntityTameable)var2;
               if (var3.isTamed() && var3.getOwner() != null) {
                  var3.setAlwaysRenderNameTag(true);
                  var3.setCustomNameTag("Owner: " + var3.getOwner().getDisplayName().getFormattedText());
               }
            }

            if (var2 instanceof AbstractHorse) {
               AbstractHorse var7 = (AbstractHorse)var2;
               if (var7.isTame() && var7.getOwnerUniqueId() != null) {
                  var7.setAlwaysRenderNameTag(true);
                  var7.setCustomNameTag("Owner: " + h.o(var7.getOwnerUniqueId().toString()));
               }
            }
         }

      }
   }

   public void j() {
      // $FF: Couldn't be decompiled
   }
}

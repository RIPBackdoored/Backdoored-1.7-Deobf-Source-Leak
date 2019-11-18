package l.c.h.j.combat;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.k;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

@w$d(
   name = "Web Aura",
   description = "Trap people camping in holes",
   category = c.COMBAT
)
public class WebAura extends w {
   private j ix;
   public static final boolean il;
   public static final int ih;
   public static final boolean ia;

   public WebAura() {
      this.ix = new l.c.h.h.a.d.c("Range", this, 4.0D, 1.0D, 10.0D);
   }

   public void d() {
      if (this.qm()) {
         int var1 = k.f(Blocks.WEB);
         if (var1 != -1) {
            List var2 = (List)mc.world.playerEntities.stream().filter(this::k).collect(Collectors.toList());
            if (var2.size() > 0) {
               mc.player.inventory.currentItem = var1;
            }

            Iterator var3 = var2.iterator();
            if (var3.hasNext()) {
               EntityPlayer var4 = (EntityPlayer)var3.next();
               BlockPos var5 = new BlockPos((int)var4.posX, (int)var4.posY, (int)var4.posZ);
               if (mc.world.getBlockState(var5).getMaterial().isReplaceable()) {
                  k.t(var5);
               }

               if (mc.world.getBlockState(var5.add(1, 0, 0)).getMaterial().isReplaceable()) {
                  k.t(var5.add(1, 0, 0));
               }

               if (mc.world.getBlockState(var5.add(0, 0, 1)).getMaterial().isReplaceable()) {
                  k.t(var5.add(0, 0, 1));
               }

               if (mc.world.getBlockState(var5.add(0, 0, -1)).getMaterial().isReplaceable()) {
                  k.t(var5.add(0, 0, -1));
               }

               if (mc.world.getBlockState(var5.add(-1, 0, 0)).getMaterial().isReplaceable()) {
                  k.t(var5.add(-1, 0, 0));
               }
            }

         }
      }
   }

   // $FF: synthetic method
   private boolean k(EntityPlayer var1) {
      if ((double)mc.player.getDistance(var1) <= (Double)this.ix.ti()) {
         EntityPlayerSP var10000 = mc.player;
         boolean var10002 = true;
      }

      return false;
   }
}

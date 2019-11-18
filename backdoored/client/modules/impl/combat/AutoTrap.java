package l.c.h.j.combat;

import java.time.Instant;
import java.util.Iterator;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.g;
import l.c.x.k;
import l.c.x.d.a;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

@w$d(
   name = "Auto Trap",
   description = "Trap nearby players",
   category = c.COMBAT
)
public class AutoTrap extends w {
   private j yh = new l.c.h.h.a.d.c("Range", this, 8.0D, 0.0D, 15.0D);
   private j ya = new i("Millisecond delay", this, 1000, 100, 1500);
   private Instant yg;
   public static final boolean yw;
   public static final int yn;
   public static final boolean yr;

   public AutoTrap() {
      this.yg = Instant.EPOCH;
   }

   public void d() {
      if (this.qm()) {
         Instant var1 = Instant.now();
         if (g.f(this.yg, var1, new Long((long)(Integer)this.ya.ti()))) {
            int var2 = mc.player.inventory.currentItem;
            int var3 = k.f(Item.getItemFromBlock(Blocks.OBSIDIAN));
            if (var3 == -1) {
               this.f(false);
               a.m("Obsidian was not found in your hotbar!", "red");
            } else {
               mc.player.inventory.currentItem = var3;
               Iterator var4 = mc.world.playerEntities.iterator();
               if (var4.hasNext()) {
                  EntityPlayer var5 = (EntityPlayer)var4.next();
                  if (l.c.x.x.g.q(var5)) {
                     ;
                  }

                  if ((double)mc.player.getDistance(var5) <= (Double)this.yh.ti() && var5 != mc.player && !l.c.x.x.g.q(var5)) {
                     BlockPos[] var6 = new BlockPos[]{k.k(var5, 1, 0, 0), k.k(var5, 1, 1, 0), k.k(var5, 0, 1, 1), k.k(var5, -1, 1, 0), k.k(var5, 0, 1, -1), k.k(var5, 0, 2, -1), k.k(var5, 0, 2, 0)};
                     int var8 = var6.length;
                     byte var9 = 0;
                     if (var9 < var8) {
                        BlockPos var10 = var6[var9];
                        if (mc.world.getBlockState(var10).getMaterial().isReplaceable() && mc.world.getEntitiesWithinAABBExcludingEntity((Entity)null, new AxisAlignedBB(var10)).isEmpty()) {
                           k.t(var10);
                           this.yg = var1;
                           return;
                        }

                        int var14 = var9 + 1;
                     }
                  }
               }

               mc.player.inventory.currentItem = var2;
            }
         }
      }
   }
}

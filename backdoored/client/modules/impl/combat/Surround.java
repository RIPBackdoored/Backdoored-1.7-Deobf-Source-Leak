package l.c.h.j.combat;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.k;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

@w$d(
   name = "Surround",
   description = "Surrounds your feet with obsidian",
   category = c.COMBAT
)
public class Surround extends w {
   private BlockPos blockPos = new BlockPos(0, -100, 0);
   public static final boolean dx;
   public static final int dl;
   public static final boolean dh;

   public void d() {
      if (this.qm() && mc.player.onGround) {
         int var1 = mc.player.inventory.currentItem;
         int var2 = k.f(Blocks.OBSIDIAN);
         if (var2 != -1) {
            BlockPos var3 = new BlockPos(mc.player.getPositionVector());
            if (var3.equals(this.blockPos)) {
               BlockPos[] var4 = new BlockPos[]{var3.add(0, -1, 1), var3.add(1, -1, 0), var3.add(0, -1, -1), var3.add(-1, -1, 0), var3.add(0, 0, 1), var3.add(1, 0, 0), var3.add(0, 0, -1), var3.add(-1, 0, 0)};
               int var6 = var4.length;
               byte var7 = 0;
               if (var7 < var6) {
                  BlockPos var8 = var4[var7];
                  if (mc.world.getBlockState(var8).getMaterial().isReplaceable() && mc.world.getEntitiesWithinAABBExcludingEntity((Entity)null, new AxisAlignedBB(var8)).isEmpty()) {
                     mc.player.inventory.currentItem = var2;
                     k.t(var8);
                  }

                  int var12 = var7 + 1;
               }

               mc.player.inventory.currentItem = var1;
            }

            this.f(false);
         }

      }
   }

   public void i() {
      this.blockPos = new BlockPos(mc.player.getPositionVector());
   }
}

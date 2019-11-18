package l.c.h.j.combat;

import java.util.Iterator;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.k;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

@w$d(
   name = "Hole Filler",
   description = "Fill holes that enemies could jump into",
   category = c.COMBAT
)
public class HoleFiller extends w {
   private j fct = new l.c.h.h.a.d.c("Radius", this, 3.0D, 1.0D, 5.0D);
   private j fce = new l.c.h.h.a.d.c("Range", this, 5.0D, 1.0D, 10.0D);
   public static final boolean fcv;
   public static final int fcu;
   public static final boolean fci;

   public void d() {
      if (this.qm()) {
         Iterator var1 = mc.world.playerEntities.iterator();
         if (var1.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var1.next();
            if (!var2.getUniqueID().equals(mc.player.getUniqueID())) {
               double var3 = (Double)this.fct.ti();
               BlockPos var5 = var2.getPosition();
               Iterable var6 = BlockPos.getAllInBox(var5.add(-var3, -var3, -var3), var5.add(var3, var3, var3));
               Iterator var7 = var6.iterator();
               if (var7.hasNext()) {
                  BlockPos var8 = (BlockPos)var7.next();
                  if (mc.player.getDistanceSqToCenter(var8) > (Double)this.fce.ti()) {
                     ;
                  }

                  if (mc.world.getBlockState(var8).getMaterial().isReplaceable() && mc.world.getBlockState(var8.add(0, 1, 0)).getMaterial().isReplaceable()) {
                     if (mc.world.getBlockState(var8.add(0, -1, 0)).getMaterial().isSolid() && mc.world.getBlockState(var8.add(1, 0, 0)).getMaterial().isSolid() && mc.world.getBlockState(var8.add(0, 0, 1)).getMaterial().isSolid() && mc.world.getBlockState(var8.add(-1, 0, 0)).getMaterial().isSolid() && mc.world.getBlockState(var8.add(0, 0, -1)).getMaterial().isSolid() && mc.world.getBlockState(var8.add(0, 0, 0)).getMaterial() == Material.AIR && mc.world.getBlockState(var8.add(0, 1, 0)).getMaterial() == Material.AIR && mc.world.getBlockState(var8.add(0, 2, 0)).getMaterial() == Material.AIR) {
                        boolean var10000 = true;
                     }

                     boolean var9 = false;
                     if (var9 && mc.world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(var8)).isEmpty()) {
                        int var10 = k.f(Blocks.OBSIDIAN);
                        if (var10 != -1) {
                           int var11 = mc.player.inventory.currentItem;
                           mc.player.inventory.currentItem = var10;
                           k.t(var8);
                           mc.player.inventory.currentItem = var11;
                        }
                     }
                  }
               }
            }
         }
      }

   }
}

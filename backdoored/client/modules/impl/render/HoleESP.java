package l.c.h.j.render;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.v.f$c;
import l.c.x.f.g;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.opengl.GL11;

@w$d(
   name = "Hole ESP",
   description = "See holes to camp in during pvp",
   category = c.RENDER
)
public class HoleESP extends w {
   private final j cb = new i("Hole Radius", this, 10, 1, 50);
   private final j cy = new f("Hole height 3", this, false);
   private final j cx = new i("Max Y", this, 125, 0, 125);
   private final j cl = new i("Max Holes", this, 20, 1, 50);
   private HashMap ch = new HashMap();
   public static final boolean ca;
   public static final int cg;
   public static final boolean cw;

   public void d() {
      if (this.qm()) {
         this.ch.clear();
         Iterable var1 = BlockPos.getAllInBox(mc.player.getPosition().add(-(Integer)this.cb.ti(), -(Integer)this.cb.ti(), -(Integer)this.cb.ti()), mc.player.getPosition().add((Integer)this.cb.ti(), (Integer)this.cb.ti(), (Integer)this.cb.ti()));
         byte var2 = 0;
         Iterator var3 = var1.iterator();
         if (var3.hasNext()) {
            BlockPos var4 = (BlockPos)var3.next();
            if (var2 <= (Integer)this.cl.ti()) {
               f$c var5 = this.k(var4, (Boolean)this.cy.ti());
               if (var5 != f$c.fls) {
                  this.ch.put(var4, var5);
                  int var9 = var2 + 1;
               }

               throw null;
            }
         }
      }
   }

   public f$c k(BlockPos var1) {
      return this.k(var1, false);
   }

   public f$c k(BlockPos var1, boolean var2) {
      if (var1.getY() > (Integer)this.cx.ti()) {
         return f$c.fls;
      } else {
         IBlockState[] var3 = new IBlockState[]{mc.world.getBlockState(var1), mc.world.getBlockState(var1.add(0, 1, 0)), mc.world.getBlockState(var1.add(0, 2, 0)), mc.world.getBlockState(var1.add(0, -1, 0)), mc.world.getBlockState(var1.add(1, 0, 0)), mc.world.getBlockState(var1.add(0, 0, 1)), mc.world.getBlockState(var1.add(-1, 0, 0)), mc.world.getBlockState(var1.add(0, 0, -1))};
         boolean var10000;
         if (!var3[0].getMaterial().blocksMovement() && !var3[1].getMaterial().blocksMovement()) {
            if (var3[2].getMaterial().blocksMovement()) {
            }

            if (var3[3].getBlock().equals(Blocks.BEDROCK) && var3[4].getBlock().equals(Blocks.BEDROCK) && var3[5].getBlock().equals(Blocks.BEDROCK) && var3[6].getBlock().equals(Blocks.BEDROCK) && var3[7].getBlock().equals(Blocks.BEDROCK)) {
               if (var3[2].getMaterial().blocksMovement()) {
               }

               var10000 = true;
            }
         }

         boolean var4 = false;
         if (var4) {
            return f$c.flu;
         } else {
            if (!var3[0].getMaterial().blocksMovement() && !var3[1].getMaterial().blocksMovement()) {
               if (var3[2].getMaterial().blocksMovement()) {
               }

               if ((var3[3].getBlock().equals(Blocks.BEDROCK) || var3[3].getBlock().equals(Blocks.OBSIDIAN)) && (var3[4].getBlock().equals(Blocks.BEDROCK) || var3[4].getBlock().equals(Blocks.OBSIDIAN)) && (var3[5].getBlock().equals(Blocks.BEDROCK) || var3[5].getBlock().equals(Blocks.OBSIDIAN)) && (var3[6].getBlock().equals(Blocks.BEDROCK) || var3[6].getBlock().equals(Blocks.OBSIDIAN)) && (var3[7].getBlock().equals(Blocks.BEDROCK) || var3[7].getBlock().equals(Blocks.OBSIDIAN))) {
                  var10000 = true;
               }
            }

            boolean var5 = false;
            if (var5) {
               return f$c.fli;
            } else {
               if (!var3[0].getMaterial().blocksMovement() && !var3[1].getMaterial().blocksMovement()) {
                  if (var3[2].getMaterial().blocksMovement()) {
                  }

                  if (var3[3].getMaterial().isSolid() && var3[4].getMaterial().isSolid() && var3[5].getMaterial().isSolid() && var3[6].getMaterial().isSolid() && var3[7].getMaterial().isSolid()) {
                     var10000 = true;
                  }
               }

               boolean var6 = false;
               return var6 ? f$c.fld : f$c.fls;
            }
         }
      }
   }

   public void n() {
      if (this.qm()) {
         g.k(255.0F, 0.0F, 255.0F, 1.0F);
         if (this.ch != null) {
            byte var1 = 0;
            byte var2 = 0;
            byte var3 = 0;
            Iterator var4 = this.ch.entrySet().iterator();
            if (var4.hasNext()) {
               Entry var5 = (Entry)var4.next();
               f$c var6 = (f$c)var5.getValue();
               GL11.glLineWidth(2.0F);
               AxisAlignedBB var7 = g.v((BlockPos)var5.getKey());
               GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);
               if (var6 == f$c.flu) {
                  RenderGlobal.renderFilledBox(var7, 1.0F, 0.0F, 0.0F, 1.0F);
                  RenderGlobal.drawSelectionBoundingBox(var7, 1.0F, 0.0F, 0.0F, 1.0F);
                  int var11 = var1 + 1;
               }

               if (var6 == f$c.fli) {
                  RenderGlobal.renderFilledBox(var7, 1.0F, 1.0F, 0.0F, 1.0F);
                  RenderGlobal.drawSelectionBoundingBox(var7, 1.0F, 1.0F, 0.0F, 1.0F);
                  int var12 = var2 + 1;
               }

               if (var6 == f$c.fld) {
                  RenderGlobal.renderFilledBox(var7, 1.0F, 1.0F, 1.0F, 1.0F);
                  RenderGlobal.drawSelectionBoundingBox(var7, 1.0F, 1.0F, 1.0F, 1.0F);
                  int var13 = var3 + 1;
               }
            }
         }

         g.ec();
      }
   }
}

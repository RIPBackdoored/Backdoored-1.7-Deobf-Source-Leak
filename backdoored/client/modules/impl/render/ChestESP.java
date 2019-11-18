package l.c.h.j.render;

import java.util.Iterator;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.f.g;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

@w$d(
   name = "Chest ESP",
   description = "yes",
   category = c.RENDER
)
public class ChestESP extends w {
   private j fbs = new f("No Nether", this, false);
   private j fbm = new f("Chams", this, true);
   private j fbj = new f("Outlines", this, true);
   private j fbc = new f("Chests", this, true);
   private j fbo = new f("Ender Chests", this, true);
   private j fbp = new f("Beds", this, true);
   private j fbz = new l.c.h.h.a.d.c("Chests R", this, 1.0D, 0.0D, 1.0D);
   private j fbb = new l.c.h.h.a.d.c("Chests G", this, 1.0D, 0.0D, 1.0D);
   private j fby = new l.c.h.h.a.d.c("Chests B", this, 0.0D, 0.0D, 1.0D);
   private j fbx = new l.c.h.h.a.d.c("Chests A", this, 1.0D, 0.0D, 1.0D);
   private j fbl = new l.c.h.h.a.d.c("Beds R", this, 1.0D, 0.0D, 1.0D);
   private j fbh = new l.c.h.h.a.d.c("Beds G", this, 1.0D, 0.0D, 1.0D);
   private j fba = new l.c.h.h.a.d.c("Beds B", this, 0.0D, 0.0D, 1.0D);
   private j fbg = new l.c.h.h.a.d.c("Beds A", this, 1.0D, 0.0D, 1.0D);
   private j fbw = new l.c.h.h.a.d.c("E Chests R", this, 0.0D, 0.0D, 1.0D);
   private j fbn = new l.c.h.h.a.d.c("E Chests G", this, 1.0D, 0.0D, 1.0D);
   private j fbr = new l.c.h.h.a.d.c("E Chests B", this, 0.0D, 0.0D, 1.0D);
   private j fyk = new l.c.h.h.a.d.c("E Chests A", this, 1.0D, 0.0D, 1.0D);
   public static final boolean fyf;
   public static final int fyq;
   public static final boolean fyt;

   public void n() {
      if (this.qm()) {
         if (!(Boolean)this.fbs.ti() || mc.player.dimension != -1) {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(2848);
            GL11.glLineWidth(2.0F);
            GL11.glDisable(3553);
            GL11.glEnable(2884);
            GL11.glDisable(2929);
            double var1 = mc.getRenderManager().viewerPosX;
            double var3 = mc.getRenderManager().viewerPosY;
            double var5 = mc.getRenderManager().viewerPosZ;
            GL11.glPushMatrix();
            GL11.glTranslated(-var1, -var3, -var5);
            Iterator var7 = mc.world.loadedTileEntityList.iterator();

            while(var7.hasNext()) {
               TileEntity var8 = (TileEntity)var7.next();
               boolean var10000;
               if ((Boolean)this.fbc.ti() && var8 instanceof TileEntityChest) {
                  var10000 = true;
               }

               boolean var9 = false;
               if ((Boolean)this.fbp.ti() && var8 instanceof TileEntityBed) {
                  var10000 = true;
               }

               boolean var10 = false;
               if ((Boolean)this.fbo.ti() && var8 instanceof TileEntityEnderChest) {
                  var10000 = true;
               }

               boolean var11 = false;
               float var12 = 0.0F;
               float var13 = 0.0F;
               float var14 = 0.0F;
               float var15 = 0.0F;
               if (var9) {
                  var12 = ((Double)this.fbz.ti()).floatValue();
                  var13 = ((Double)this.fbb.ti()).floatValue();
                  var14 = ((Double)this.fby.ti()).floatValue();
                  var15 = ((Double)this.fbx.ti()).floatValue();
               }

               if (var10) {
                  var12 = ((Double)this.fbl.ti()).floatValue();
                  var13 = ((Double)this.fbh.ti()).floatValue();
                  var14 = ((Double)this.fba.ti()).floatValue();
                  var15 = ((Double)this.fbg.ti()).floatValue();
               }

               if (var11) {
                  var12 = ((Double)this.fbw.ti()).floatValue();
                  var13 = ((Double)this.fbn.ti()).floatValue();
                  var14 = ((Double)this.fbr.ti()).floatValue();
                  var15 = ((Double)this.fyk.ti()).floatValue();
               }

               AxisAlignedBB var16 = g.v(var8.getPos());
               if (var8 instanceof TileEntityChest) {
                  TileEntityChest var17 = (TileEntityChest)var8;
                  if (var17.adjacentChestXPos != null) {
                     continue;
                  }

                  if (var17.adjacentChestZPos != null) {
                     ;
                  }

                  if (var17.adjacentChestXNeg != null) {
                     var16 = var16.union(g.v(var17.adjacentChestXNeg.getPos()));
                  }

                  if (var17.adjacentChestZNeg != null) {
                     var16 = var16.union(g.v(var17.adjacentChestZNeg.getPos()));
                  }
               }

               GL11.glColor4f(var12, var13, var14, var15);
               if ((Boolean)this.fbm.ti()) {
                  g.f(var16);
               }

               if ((Boolean)this.fbj.ti()) {
                  g.q(var16);
               }

               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               break;
            }

            GL11.glPopMatrix();
            GL11.glEnable(2929);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glDisable(2848);
         }
      }
   }
}

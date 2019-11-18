package l.c.h.j.client;

import l.c.f.d;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.g;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "BetterHighlightBox",
   description = "Better Highlight Box",
   category = c.CLIENT
)
public class BetterHighlightBox extends w {
   private j wi = new g("Width", this, 5.0F, 0.0F, 50.0F);
   private j wd = new i("Red", this, 0, 0, 255);
   private j ws = new i("Green", this, 0, 0, 255);
   private j wm = new i("Blue", this, 0, 0, 255);
   private j wj = new l.c.h.h.a.d.c("Alpha", this, 0.4D, 0.0D, 1.0D);
   public static final int wc;
   public static final boolean wo;

   @SubscribeEvent
   public void k(DrawBlockHighlightEvent var1) {
      if (this.qm()) {
         float var2 = var1.getPartialTicks();
         EntityPlayer var3 = var1.getPlayer();
         RayTraceResult var4 = var1.getTarget();
         if (var4.typeOfHit == Type.BLOCK) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
            GlStateManager.glLineWidth((Float)this.wi.ti());
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask(false);
            BlockPos var5 = var4.getBlockPos();
            IBlockState var6 = mc.world.getBlockState(var5);
            if (var6.getMaterial() != Material.AIR && mc.world.getWorldBorder().contains(var5)) {
               double var7 = var3.lastTickPosX + (var3.posX - var3.lastTickPosX) * (double)var2;
               double var9 = var3.lastTickPosY + (var3.posY - var3.lastTickPosY) * (double)var2;
               double var11 = var3.lastTickPosZ + (var3.posZ - var3.lastTickPosZ) * (double)var2;
               d.drawSelectionBoundingBox(var6.getSelectedBoundingBox(mc.world, var5).grow(0.0020000000949949026D).offset(-var7, -var9, -var11), (float)Math.min(Math.abs((Integer)this.wd.ti() - 255), 244), (float)Math.min(Math.abs((Integer)this.ws.ti() - 255), 244), (float)Math.min(Math.abs((Integer)this.wm.ti() - 255), 244), ((Double)this.wj.ti()).floatValue());
            }

            GlStateManager.depthMask(true);
            GlStateManager.disableBlend();
         }

         var1.setCanceled(true);
      }

   }
}

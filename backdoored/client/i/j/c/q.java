package l.c.i.j.c;

import l.c.i.d.a;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;

public class q extends a {
   public static final int qtj;
   public static final boolean qtc;

   public q() {
      super("Player Preview Element");
   }

   public void k(int var1, int var2, float var3) {
      this.g().fqs = 25;
      this.g().fqm = 25;
      super.k(var1, var2, var3);
      if (this.ey()) {
         EntityPlayerSP var4 = mc.player;
         GlStateManager.pushMatrix();
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         RenderHelper.enableStandardItemLighting();
         GlStateManager.enableAlpha();
         GlStateManager.shadeModel(7424);
         GlStateManager.enableAlpha();
         GlStateManager.enableDepth();
         GlStateManager.rotate(0.0F, 0.0F, 5.0F, 0.0F);
         GlStateManager.enableColorMaterial();
         GlStateManager.pushMatrix();
         GlStateManager.translate((float)this.a().fqs + (float)this.g().fqs, (float)this.a().fqm + (float)this.g().fqm, 50.0F);
         GlStateManager.scale(-50.0F, 50.0F, 50.0F);
         GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
         GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
         RenderHelper.enableStandardItemLighting();
         GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
         GlStateManager.rotate(-((float)Math.atan((double)((float)this.a().fqm / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.translate(0.0F, 0.0F, 0.0F);
         RenderManager var5 = Minecraft.getMinecraft().getRenderManager();
         var5.setPlayerViewY(180.0F);
         var5.setRenderShadow(false);
         var5.renderEntity(var4, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
         var5.setRenderShadow(true);
         GlStateManager.popMatrix();
         GlStateManager.disableRescaleNormal();
         GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
         GlStateManager.disableTexture2D();
         GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
         GlStateManager.depthFunc(515);
         GlStateManager.resetColor();
         GlStateManager.disableDepth();
         GlStateManager.popMatrix();
      }
   }
}

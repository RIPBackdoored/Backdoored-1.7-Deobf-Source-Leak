package l.c.x.f;

import java.awt.Color;
import l.c.q;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class j implements q {
   public static final int flg;
   public static final boolean flw;

   public static void q(int param0, int param1, int param2, int param3, int param4) {
      // $FF: Couldn't be decompiled
   }

   public static void k(int var0, int var1, int var2, int var3, Color var4) {
      GL11.glDisable(3553);
      GL11.glColor4f((float)var4.getRed(), (float)var4.getBlue(), (float)var4.getGreen(), (float)var4.getAlpha());
      GL11.glPushMatrix();
      GL11.glLineWidth(1.0F);
      GL11.glBegin(1);
      GL11.glVertex2d((double)var0, (double)var1);
      GL11.glVertex2d((double)(var0 + var2), (double)var1);
      GL11.glVertex2d((double)(var0 + var2), (double)(var1 + var3));
      GL11.glVertex2d((double)var0, (double)(var1 + var3));
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
   }

   public static void k(int var0, int var1, Block var2) {
      k(var0, var1, new ItemStack(var2));
   }

   public static void k(int var0, int var1, ItemStack var2) {
      RenderHelper.enableStandardItemLighting();
      GlStateManager.enableRescaleNormal();
      GlStateManager.color(1.0F, 1.0F, 1.0F);
      GlStateManager.translate(0.0F, 0.0F, 700.0F);
      RenderHelper.enableGUIStandardItemLighting();
      mc.getRenderItem().renderItemAndEffectIntoGUI(var2, var0, var1);
      mc.getRenderItem().renderItemOverlays(mc.fontRenderer, var2, var0, var1);
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableDepth();
      GlStateManager.disableRescaleNormal();
      GlStateManager.popMatrix();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }
}

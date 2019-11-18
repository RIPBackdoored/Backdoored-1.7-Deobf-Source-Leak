package l.c.x.y;

import l.c.q;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.lwjgl.opengl.GL11;

public class c {
   public static final int qqn;
   public static final boolean qqr;

   public static void k(String var0, Vec3d var1) {
      float var2 = (Float)ObfuscationReflectionHelper.getPrivateValue(RenderManager.class, q.mc.getRenderManager(), new String[]{"playerViewX", "field_78732_j"});
      float var3 = (Float)ObfuscationReflectionHelper.getPrivateValue(RenderManager.class, q.mc.getRenderManager(), new String[]{"playerViewY", "field_78735_i"});
      float var4 = 1.6F;
      float var5 = (float)(0.01666666753590107D * q.mc.player.getDistance(var1.x, var1.y, var1.z) / 2.0D);
      GL11.glTranslatef((float)var1.x, (float)var1.y, (float)var1.z);
      GL11.glNormal3f(0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-var3, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(var2, 1.0F, 0.0F, 0.0F);
      GL11.glScalef(-var5, -var5, var5);
      GL11.glDepthMask(false);
      GL11.glDisable(2896);
      Tessellator var6 = Tessellator.getInstance();
      BufferBuilder var7 = var6.getBuffer();
      int var8 = (int)(-q.mc.player.getDistance(var1.x, var1.y, var1.z)) / (int)var4;
      GL11.glDisable(3553);
      int var9 = q.mc.fontRenderer.getStringWidth(var0) / 2;
      q.mc.fontRenderer.drawStringWithShadow(var0, (float)(-var9), (float)var8, 16777215);
      q.mc.entityRenderer.disableLightmap();
      GL11.glLineWidth(1.0F);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2896);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glPopMatrix();
   }
}

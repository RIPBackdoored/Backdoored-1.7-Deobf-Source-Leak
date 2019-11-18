package l.c.x.f;

import java.awt.Color;
import l.c.q;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.lwjgl.opengl.GL11;

public class g {
   public static final boolean fxl;
   public static final int fxh;
   public static final boolean fxa;
   public static final boolean fxl;
   public static final int fxh;
   public static final boolean fxa;

   public g() {
   }

   public static void k(BlockPos var0, double var1, Color var3) throws Exception {
      double var4 = (Double)ObfuscationReflectionHelper.getPrivateValue(RenderManager.class, q.mc.getRenderManager(), new String[]{"renderPosX", "field_78725_b"});
      double var6 = (Double)ObfuscationReflectionHelper.getPrivateValue(RenderManager.class, q.mc.getRenderManager(), new String[]{"renderPosY", "field_78726_c"});
      double var8 = (Double)ObfuscationReflectionHelper.getPrivateValue(RenderManager.class, q.mc.getRenderManager(), new String[]{"renderPosZ", "field_78723_d"});
      double var10 = (double)var0.getX() + 0.5D - var4;
      double var12 = (double)var0.getY() - var6;
      double var14 = (double)var0.getZ() + 0.5D - var8;
      GL11.glPushMatrix();
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(3042);
      GL11.glLineWidth(2.0F);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4d((double)((float)var3.getRed() / 255.0F), (double)((float)var3.getGreen() / 255.0F), (double)((float)var3.getBlue() / 255.0F), 0.25D);
      GL11.glBegin(9);
      byte var16 = 0;
      if (var16 <= 360) {
         GL11.glVertex3d(var10 + Math.sin((double)var16 * 3.141592653589793D / 180.0D) * var1, var12, var14 + Math.cos((double)var16 * 3.141592653589793D / 180.0D) * var1);
         int var19 = var16 + 1;
      }

      GL11.glEnd();
      GL11.glLineWidth(2.0F);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void k(AxisAlignedBB var0, int var1, int var2, int var3, float var4) {
      GL11.glPushMatrix();
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(3042);
      GL11.glLineWidth(2.0F);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glColor4d((double)((float)var1 / 255.0F), (double)((float)var2 / 255.0F), (double)((float)var3 / 255.0F), (double)var4);
      k(var0, 0.0F, 0.0F, 0.0F, 0.0F);
      GL11.glColor4d((double)((float)var1 / 255.0F), (double)((float)var2 / 255.0F), (double)((float)var3 / 255.0F), (double)var4);
      k(var0);
      GL11.glLineWidth(2.0F);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void k(BlockPos var0, int var1, int var2, int var3, float var4, double var5, double var7) {
      double var9 = (double)var0.getX();
      double var11 = (double)var0.getY();
      double var13 = (double)var0.getZ();
      k(new AxisAlignedBB(var9, var11, var13, var9 + var7, var11 + 1.0D, var13 + var5), var1, var2, var3, var4);
   }

   public static void k(AxisAlignedBB var0, float var1, float var2, float var3, float var4) {
      Tessellator var5 = Tessellator.getInstance();
      BufferBuilder var6 = var5.getBuffer();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
   }

   public static void k(AxisAlignedBB var0) {
      Tessellator var1 = Tessellator.getInstance();
      BufferBuilder var2 = var1.getBuffer();
      var2.begin(3, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(3, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(1, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var1.draw();
   }

   public static void k(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var13);
      k(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
   }

   public static void f(AxisAlignedBB var0) {
      GL11.glBegin(7);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glEnd();
   }

   public static void q(AxisAlignedBB var0) {
      GL11.glBegin(1);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
   }

   public static void ej() {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glLineWidth(2.0F);
      GL11.glDisable(3553);
      GL11.glEnable(2884);
      GL11.glDisable(2929);
      double var0 = q.mc.getRenderManager().viewerPosX;
      double var2 = q.mc.getRenderManager().viewerPosY;
      double var4 = q.mc.getRenderManager().viewerPosZ;
      GL11.glPushMatrix();
      GL11.glTranslated(-var0, -var2, -var4);
   }

   public static void k(float var0, float var1, float var2, float var3) {
      ej();
   }

   public static void ec() {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
      GL11.glEnable(2929);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static AxisAlignedBB v(BlockPos var0) {
      return q.mc.world.getBlockState(var0).getBoundingBox(q.mc.world, var0).offset(var0);
   }

   public static void k(int param0, int param1, int param2, int param3, int param4, int param5) {
      // $FF: Couldn't be decompiled
   }

   public g() {
   }

   public static void k(BlockPos var0, double var1, Color var3) throws Exception {
      double var4 = (Double)ObfuscationReflectionHelper.getPrivateValue(RenderManager.class, q.mc.getRenderManager(), new String[]{"renderPosX", "field_78725_b"});
      double var6 = (Double)ObfuscationReflectionHelper.getPrivateValue(RenderManager.class, q.mc.getRenderManager(), new String[]{"renderPosY", "field_78726_c"});
      double var8 = (Double)ObfuscationReflectionHelper.getPrivateValue(RenderManager.class, q.mc.getRenderManager(), new String[]{"renderPosZ", "field_78723_d"});
      double var10 = (double)var0.getX() + 0.5D - var4;
      double var12 = (double)var0.getY() - var6;
      double var14 = (double)var0.getZ() + 0.5D - var8;
      GL11.glPushMatrix();
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(3042);
      GL11.glLineWidth(2.0F);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4d((double)((float)var3.getRed() / 255.0F), (double)((float)var3.getGreen() / 255.0F), (double)((float)var3.getBlue() / 255.0F), 0.25D);
      GL11.glBegin(9);
      byte var16 = 0;
      if (var16 <= 360) {
         GL11.glVertex3d(var10 + Math.sin((double)var16 * 3.141592653589793D / 180.0D) * var1, var12, var14 + Math.cos((double)var16 * 3.141592653589793D / 180.0D) * var1);
         int var19 = var16 + 1;
      }

      GL11.glEnd();
      GL11.glLineWidth(2.0F);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void k(AxisAlignedBB var0, int var1, int var2, int var3, float var4) {
      GL11.glPushMatrix();
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(3042);
      GL11.glLineWidth(2.0F);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glColor4d((double)((float)var1 / 255.0F), (double)((float)var2 / 255.0F), (double)((float)var3 / 255.0F), (double)var4);
      k(var0, 0.0F, 0.0F, 0.0F, 0.0F);
      GL11.glColor4d((double)((float)var1 / 255.0F), (double)((float)var2 / 255.0F), (double)((float)var3 / 255.0F), (double)var4);
      k(var0);
      GL11.glLineWidth(2.0F);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void k(BlockPos var0, int var1, int var2, int var3, float var4, double var5, double var7) {
      double var9 = (double)var0.getX();
      double var11 = (double)var0.getY();
      double var13 = (double)var0.getZ();
      k(new AxisAlignedBB(var9, var11, var13, var9 + var7, var11 + 1.0D, var13 + var5), var1, var2, var3, var4);
   }

   public static void k(AxisAlignedBB var0, float var1, float var2, float var3, float var4) {
      Tessellator var5 = Tessellator.getInstance();
      BufferBuilder var6 = var5.getBuffer();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
      var6.begin(7, DefaultVertexFormats.POSITION_TEX);
      var6.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var6.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var5.draw();
   }

   public static void k(AxisAlignedBB var0) {
      Tessellator var1 = Tessellator.getInstance();
      BufferBuilder var2 = var1.getBuffer();
      var2.begin(3, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(3, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(1, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var1.draw();
   }

   public static void k(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var13);
      k(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
   }

   public static void f(AxisAlignedBB var0) {
      GL11.glBegin(7);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glEnd();
   }

   public static void q(AxisAlignedBB var0) {
      GL11.glBegin(1);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
      GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
   }

   public static void ej() {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glLineWidth(2.0F);
      GL11.glDisable(3553);
      GL11.glEnable(2884);
      GL11.glDisable(2929);
      double var0 = q.mc.getRenderManager().viewerPosX;
      double var2 = q.mc.getRenderManager().viewerPosY;
      double var4 = q.mc.getRenderManager().viewerPosZ;
      GL11.glPushMatrix();
      GL11.glTranslated(-var0, -var2, -var4);
   }

   public static void k(float var0, float var1, float var2, float var3) {
      ej();
   }

   public static void ec() {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
      GL11.glEnable(2929);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   public static AxisAlignedBB v(BlockPos var0) {
      return q.mc.world.getBlockState(var0).getBoundingBox(q.mc.world, var0).offset(var0);
   }

   public static void k(int param0, int param1, int param2, int param3, int param4, int param5) {
      // $FF: Couldn't be decompiled
   }
}

package l.c.x;

import com.google.common.hash.Hashing;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.FloatBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import l.c.q;
import l.c.x.f.a;
import l.c.x.j.c;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector4f;

public class u {
   private static Minecraft mc;
   public static final Block[] block;
   private static final Random xs;
   public static final boolean xm;
   public static final int xj;
   public static final boolean xc;

   public static boolean k(Block var0) {
      return ArrayUtils.contains(block, var0);
   }

   public static String k(Vec3d var0, boolean... var1) {
      if (var1.length > 0) {
         boolean var10000 = var1[0];
      }

      boolean var2 = true;
      StringBuilder var3 = new StringBuilder();
      var3.append('(');
      var3.append((int)Math.floor(var0.x));
      var3.append(", ");
      if (var2) {
         var3.append((int)Math.floor(var0.y));
         var3.append(", ");
      }

      var3.append((int)Math.floor(var0.z));
      var3.append(")");
      return var3.toString();
   }

   public static String f(BlockPos var0) {
      return k(new Vec3d(var0));
   }

   public static void k(String var0, int var1, int var2, float var3) {
      char[] var5 = var0.toCharArray();
      int var6 = var5.length;
      byte var7 = 0;
      if (var7 < var6) {
         char var8 = var5[var7];
         String var9 = String.valueOf(var8);
         int var4 = var1 + var1;
         int var13 = var7 + 1;
      }

   }

   public static Color k(long var0, float var2) {
      float var3 = (float)(System.nanoTime() + var0) / 1.0E10F % 1.0F;
      Color var4 = new Color((int)Long.parseLong(Integer.toHexString(Color.HSBtoRGB(var3, 1.0F, 1.0F)), 16));
      return new Color((float)var4.getRed() / 255.0F * var2, (float)var4.getGreen() / 255.0F * var2, (float)var4.getBlue() / 255.0F * var2, (float)var4.getAlpha() / 255.0F);
   }

   public static double k(double var0, int var2) {
      double var3 = Math.pow(10.0D, (double)var2);
      return (double)Math.round(var0 * var3) / var3;
   }

   public static void b(String var0) {
      StringSelection var1 = new StringSelection(var0);
      Clipboard var2 = Toolkit.getDefaultToolkit().getSystemClipboard();
      var2.setContents(var1, var1);
   }

   public static boolean f(String var0, String var1) {
      boolean var10000;
      try {
         BufferedWriter var2 = new BufferedWriter(new FileWriter(var0));
         var2.write(var1);
         var2.close();
         var10000 = true;
      } catch (Exception var6) {
         var6.printStackTrace();
         return false;
      }

      return var10000;
   }

   public static a k(Vec3d var0) {
      Entity var1 = mc.getRenderViewEntity();
      if (var1 == null) {
         return new a(0.0D, 0.0D, false);
      } else {
         new ActiveRenderInfo();
         Vec3d var3 = mc.player.getPositionEyes(mc.getRenderPartialTicks());
         Vec3d var4 = ActiveRenderInfo.projectViewFromEntity(var1, (double)mc.getRenderPartialTicks());
         float var5 = (float)(var3.x + var4.x - (double)((float)var0.x));
         float var6 = (float)(var3.y + var4.y - (double)((float)var0.y));
         float var7 = (float)(var3.z + var4.z - (double)((float)var0.z));
         Vector4f var8 = new Vector4f(var5, var6, var7, 1.0F);
         Matrix4f var9 = new Matrix4f();
         var9.load((FloatBuffer)ObfuscationReflectionHelper.getPrivateValue(ActiveRenderInfo.class, new ActiveRenderInfo(), new String[]{"MODELVIEW", "field_178812_b"}));
         Matrix4f var10 = new Matrix4f();
         var10.load((FloatBuffer)ObfuscationReflectionHelper.getPrivateValue(ActiveRenderInfo.class, new ActiveRenderInfo(), new String[]{"PROJECTION", "field_178813_c"}));
         k(var8, var9);
         k(var8, var10);
         if (var8.w > 0.0F) {
            var8.x *= -100000.0F;
            throw null;
         } else {
            float var11 = 1.0F / var8.w;
            var8.x *= var11;
            var8.y *= var11;
            ScaledResolution var18 = new ScaledResolution(mc);
            float var12 = (float)var18.getScaledWidth() / 2.0F;
            float var13 = (float)var18.getScaledHeight() / 2.0F;
            var8.x = var12 + 0.5F * var8.x * (float)var18.getScaledWidth() + 0.5F;
            var8.y = var13 - (0.5F * var8.y * (float)var18.getScaledHeight() + 0.5F);
            boolean var14 = true;
            if (var8.x < 0.0F || var8.y < 0.0F || var8.x > (float)var18.getScaledWidth() || var8.y > (float)var18.getScaledHeight()) {
               var14 = false;
            }

            return new a((double)var8.x, (double)var8.y, var14);
         }
      }
   }

   private static void k(Vector4f var0, Matrix4f var1) {
      float var2 = var0.x;
      float var3 = var0.y;
      float var4 = var0.z;
      var0.x = var2 * var1.m00 + var3 * var1.m10 + var4 * var1.m20 + var1.m30;
      var0.y = var2 * var1.m01 + var3 * var1.m11 + var4 * var1.m21 + var1.m31;
      var0.z = var2 * var1.m02 + var3 * var1.m12 + var4 * var1.m22 + var1.m32;
      var0.w = var2 * var1.m03 + var3 * var1.m13 + var4 * var1.m23 + var1.m33;
   }

   public static float fb() {
      float var0 = mc.player.rotationYaw;
      if (mc.player.moveForward < 0.0F) {
         var0 += 180.0F;
      }

      float var1 = 1.0F;
      if (mc.player.moveForward < 0.0F) {
         var1 = -0.5F;
      }

      if (mc.player.moveForward > 0.0F) {
         var1 = 0.5F;
      }

      if (mc.player.moveStrafing > 0.0F) {
         var0 -= 90.0F * var1;
      }

      if (mc.player.moveStrafing < 0.0F) {
         var0 += 90.0F * var1;
      }

      var0 *= 0.017453292F;
      return var0;
   }

   private static String p() {
      String var0 = System.getenv("os") + System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + System.getProperty("user.language") + System.getenv("SystemRoot") + System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_LEVEL") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");
      return Hashing.sha512().hashString(var0, StandardCharsets.UTF_8).toString();
   }

   private static String q(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static boolean t(String var0) {
      String var1 = p();
      String var2 = q(var1);
      return var2.equalsIgnoreCase(var0);
   }

   private static void z() {
      if (xs.nextBoolean() && !t(l.c.a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + l.c.a.qfj);
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new c("Invalid License");
      }
   }

   static {
      mc = q.mc;
      block = new Block[]{Blocks.WHITE_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.SILVER_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.BLACK_SHULKER_BOX};
      xs = new Random();
   }
}

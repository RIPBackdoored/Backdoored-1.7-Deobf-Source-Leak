package l.c.h.j.client;

import  l. c. h. j. x. s;
import com.google.common.hash.Hashing;
import java.awt.Color;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.dk;
import l.c.x.u;
import l.c.x.d.a;
import l.c.x.f.g;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import org.lwjgl.opengl.GL11;

@w$d(
   name = "Logout Spots",
   description = "Show the logout spots of other players",
   category = c.CLIENT
)
public class LogoutSpots extends w {
   private HashMap oh = new HashMap();
   private final j oa = new i("Red", this, 0, 0, 255);
   private final j og = new i("Green", this, 0, 0, 255);
   private final j ow = new i("Blue", this, 0, 0, 255);
   private final j on = new i("Alpha", this, 255, 0, 255);
   public static final int or;
   public static final boolean pk;

   @SubscribeEvent
   public void k(dk var1) {
      EntityPlayer var2 = mc.world.getPlayerEntityByUUID(var1.tj.getId());
      if (var2 != null && mc.player != null && !mc.player.equals(var2)) {
         AxisAlignedBB var3 = var2.getEntityBoundingBox();
         String var4 = var2.getDisplayNameString();
         if (this.oh.get(var4) != null) {
            this.oh.remove(var4);
         }

         this.oh.put(var4, var3);
         if (this.qm()) {
            a.m(String.format("PlayerPreviewElement '%s' disconnected at %s", var4, u.k(var2.getPositionVector())), "red");
            z();
         }
      }

   }

   @SubscribeEvent
   public void f(ClientTickEvent var1) {
      if (mc.world == null && this.oh.size() != 0) {
         this.oh.clear();
         z();
      }

   }

   public void n() {
      if (this.qm()) {
         Color var1 = new Color((Integer)this.oa.ti(), (Integer)this.og.ti(), (Integer)this.ow.ti(), (Integer)this.on.ti());
         this.oh.forEach( s::k);
      }
   }

   private static String p() {
      String var0 = System.getenv("os") + System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + System.getProperty("user.language") + System.getenv("SystemRoot") + System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_LEVEL") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");
      return Hashing.sha512().hashString(var0, StandardCharsets.UTF_8).toString();
   }

   private static String q(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static boolean t(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static void z() {
      if (!t(l.c.a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + l.c.a.qfj);
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new l.c.x.j.c("Invalid License");
      }
   }

   // $FF: synthetic method
   private static void k(Color var0, String var1, AxisAlignedBB var2) {
      Vec3d var3 = var2.getCenter();
      if (mc.player.getDistanceSq(var3.x, var3.y, var3.z) > 2500.0D) {
         Vec3d var4 = var3.subtract(new Vec3d(mc.getRenderManager().viewerPosX, mc.getRenderManager().viewerPosY, mc.getRenderManager().viewerPosZ)).normalize();
         var3 = new Vec3d(mc.getRenderManager().viewerPosX + var4.x * 50.0D, mc.getRenderManager().viewerPosY + var4.y * 50.0D, mc.getRenderManager().viewerPosZ + var4.z * 50.0D);
      }

      double var12 = mc.player.getDistance(var3.x, var3.y, var3.z) / 4.0D;
      var12 = Math.max(1.6D, var12);
      RenderManager var6 = mc.getRenderManager();
      GL11.glPushMatrix();
      GL11.glTranslated(-var6.viewerPosX, -var6.viewerPosY, -var6.viewerPosZ);
      GL11.glTranslatef((float)var3.x + 0.5F, (float)var3.y + 0.5F, (float)var3.z + 0.5F);
      GL11.glNormal3f(0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-var6.playerViewY, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(var6.playerViewX, 1.0F, 0.0F, 0.0F);
      GL11.glScaled(-var12, -var12, var12);
      GL11.glDisable(2896);
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      String var7 = var1 + " (" + mc.player.getDistance(var2.getCenter().x, var2.getCenter().y, var2.getCenter().z) + "m)";
      int var8 = mc.fontRenderer.getStringWidth(var7) / 2;
      mc.fontRenderer.drawStringWithShadow(var7, (float)(-var8), (float)(-(mc.fontRenderer.FONT_HEIGHT - 1)), var0.getRGB());
      GL11.glDisable(3042);
      GL11.glEnable(2896);
      GL11.glPopMatrix();
      g.k((float)(var0.getRed() / 255), (float)(var0.getBlue() / 255), (float)(var0.getRed() / 255), (float)var0.getAlpha());
      g.q(var2);
      g.ec();
   }
}

package l.c.h.j.client;

import java.io.File;
import java.nio.IntBuffer;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.x.m;
import l.c.u.a;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

@w$d(
   name = "Better Screenshot",
   description = "Asyncronous Screenshots",
   category = c.CLIENT
)
public class BetterScreenshot extends w {
   private IntBuffer da;
   private int[] dg;
   public static final boolean dw;
   public static final int dn;
   public static final boolean dr;

   @SubscribeEvent
   public void k(a var1) {
      if (this.qm()) {
         var1.setCanceled(true);
         this.k(var1.fuf, var1.fut, var1.fue, var1.framebuffer);
         var1.iTextComponent = new TextComponentString("Creating screenshot...");
      }

   }

   public void k(File var1, int var2, int var3, Framebuffer var4) {
      File var5 = new File(var1, "screenshots");
      var5.mkdir();
      if (OpenGlHelper.isFramebufferEnabled()) {
         var2 = var4.framebufferTextureWidth;
         var3 = var4.framebufferTextureHeight;
      }

      int var6 = var2 * var3;
      if (this.da == null || this.da.capacity() < var6) {
         this.da = BufferUtils.createIntBuffer(var6);
         this.dg = new int[var6];
      }

      GL11.glPixelStorei(3333, 1);
      GL11.glPixelStorei(3317, 1);
      this.da.clear();
      if (OpenGlHelper.isFramebufferEnabled()) {
         GlStateManager.bindTexture(var4.framebufferTexture);
         GL11.glGetTexImage(3553, 0, 32993, 33639, this.da);
      }

      GL11.glReadPixels(0, 0, var2, var3, 32993, 33639, this.da);
      this.da.get(this.dg);
      (new Thread(new m(var2, var3, this.dg, mc.getFramebuffer(), var5), "Screenshot creation thread")).start();
   }
}

package l.c.c.d;

import java.util.ArrayList;
import java.util.List;
import l.c.q;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class c extends GuiScreen {
   private static final ResourceLocation resourceLocation = new ResourceLocation("backdoored", "textures/white.png");
   public boolean sm = false;
   public boolean sj = false;
   public int sc;
   public int so;
   public int sp;
   public int sz;
   public String sb;
   public boolean sy;
   private float[] sx;
   public String sl = "FFFFFF";
   public static ArrayList sh;
   public static final int sa;
   public static final boolean sg;

   c(int var1, int var2, int var3, int var4, String var5, boolean var6, float[] var7) {
      this.sc = var1;
      this.so = var2;
      this.sp = var3;
      this.sz = var4;
      this.sb = var5;
      this.sy = var6;
      this.sx = var7;
      sh.add(this);
      this.mc = q.mc;
   }

   public void q(int var1, int var2) {
      byte var3 = 1;
      q.mc.renderEngine.bindTexture(resourceLocation);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.0F, 0.0F);
      GL11.glColor4f(this.sx[0], this.sx[1], this.sx[2], this.sx[3]);
      List var4 = this.mc.fontRenderer.listFormattedStringToWidth(this.sb, this.sp - (var3 + 1));
      boolean var5 = false;
      int var6 = var4.size() * this.mc.fontRenderer.FONT_HEIGHT + 15;
      if (var6 > this.mc.fontRenderer.FONT_HEIGHT + 15) {
         var5 = true;
         this.sz = var6;
      }

      this.drawTexturedModalRect(this.sc, this.so, 0, 0, this.sp, this.sz);
      GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
      this.drawTexturedModalRect(this.sc + var3, this.so + var3, 0, 0, this.sp - var3 * 2, this.sz - var3 * 2);
      GL11.glPopMatrix();
      GL11.glPopAttrib();
      this.mc.fontRenderer.drawSplitString(this.sb, this.sc + var3 + 1 + (this.sp - (var3 + 1) - this.mc.fontRenderer.getStringWidth((String)var4.get(0))) / 2, this.so + this.sz / 2 - this.mc.fontRenderer.FONT_HEIGHT * var4.size() / 2, this.sp - (var3 + 1), Integer.parseInt(this.sl, 16));
      this.t(var1, var2);
   }

   public void t(int var1, int var2) {
   }
}

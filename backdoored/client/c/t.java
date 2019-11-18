package l.c.c;

import java.io.IOException;
import java.util.Iterator;
import l.c.q;
import l.c.c.d.c;
import l.c.c.d.v;
import l.c.h.j.w;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.opengl.GL11;

public class t extends GuiScreen {
   public static int frm = 0;
   public static int frj = 0;
   public static final boolean frc;
   public static final int fro;
   public static final boolean frp;

   public t() {
      this.allowUserInput = true;
   }

   public void func_73866_w_() {
      super.initGui();
      this.allowUserInput = true;
   }

   protected void func_73869_a(char var1, int var2) throws IOException {
   }

   public void func_73863_a(int var1, int var2, float var3) {
      frm = var1;
      frj = var2;
      Iterator var4 = j.f().iterator();
      if (var4.hasNext()) {
         c var5 = (c)var4.next();
         if (var5.sy) {
            var5.q(var1, var2);
         }
      }

      this.e(var1, var2);
      super.drawScreen(var1, var2, var3);
   }

   private void e(int var1, int var2) {
      c var3 = j.k(var1, var2);
      if (var3 != null) {
         w var4 = j.k(var3);
         if (var4 != null) {
            q.mc.renderEngine.bindTexture(j.resourceLocation);
            GL11.glPushAttrib(1048575);
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 0.0F, 0.0F);
            GL11.glColor4f(255.0F, 255.0F, 255.0F, 1.0F);
            int var5 = this.fontRenderer.getStringWidth(var4.gr) + 1;
            int var6 = this.fontRenderer.FONT_HEIGHT + 1;
            this.drawTexturedModalRect(var1 + 5, var2 + 5, var5, var6, var5, var6);
            GL11.glPopMatrix();
            GL11.glPopAttrib();
            this.fontRenderer.drawString(var4.gr, var1 + 6, var2 + 6, 0);
         }
      }

   }

   protected void func_73864_a(int var1, int var2, int var3) throws IOException {
      Iterator var4 = j.f().iterator();
      if (var4.hasNext()) {
         c var5 = (c)var4.next();
         if (!var5.sy) {
            ;
         }

         boolean var10001;
         if (var2 <= var5.so + var5.sz) {
            Iterator var6 = v.r().iterator();
            if (var6.hasNext()) {
               v var7 = (v)var6.next();
               if (var5.sb.equals(var7.sb)) {
                  w var10000 = var7.tv();
                  if (!var7.tv().qm()) {
                     var10001 = true;
                  }

                  var10000.f(false);
                  return;
               }
            }

            if (!var5.sm) {
               var10001 = true;
            }

            var5.sm = false;
            return;
         }

         if (var1 >= var5.sc && var1 <= var5.sc + var5.sp && var2 >= var5.so && var2 <= var5.so + var5.sz && var3 == 1) {
            if (!var5.sj) {
               var10001 = true;
            }

            var5.sj = false;
            return;
         }
      }

      super.mouseClicked(var1, var2, var3);
   }

   public boolean func_73868_f() {
      return false;
   }
}

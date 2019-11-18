package l.c.h.j.ui;

import java.time.LocalTime;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import org.lwjgl.opengl.GL11;

@w$d(
   name = "Time",
   description = "Display time",
   category = c.UI
)
public class Time extends w {
   private final j fwx = new f("Ingame Time", this, false);
   private final j fwl;
   private final j fwh;
   private final j fwa;
   private final j fwg;
   public static final boolean fww;
   public static final int fwn;
   public static final boolean fwr;

   public Time() {
      this.fwl = new i("Radius", this, 1, 0, mc.displayWidth);
      this.fwh = new i("x", this, 1, 0, (int)Math.round((double)mc.displayWidth * 1.2D));
      this.fwa = new i("y", this, 1, 0, (int)Math.round((double)mc.displayHeight * 1.2D));
      this.fwg = new l.c.h.h.a.d.c("Circle Accuracy", this, 1.0D, 0.5D, 2.0D);
   }

   private static LocalTime e(boolean param0) {
      // $FF: Couldn't be decompiled
   }

   public void w() {
      if (this.qm()) {
         GL11.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
         GL11.glDisable(3553);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glPushMatrix();
         GL11.glTranslated((double)(Integer)this.fwh.ti(), (double)(Integer)this.fwa.ti(), 0.0D);
         GL11.glLineWidth(1.0F);
         LocalTime var1 = e((Boolean)this.fwx.ti());
         double var2 = (double)var1.getSecond() + (double)(System.currentTimeMillis() % 1000L) / 1000.0D;
         double var4 = (double)var1.getMinute() + var2 / 60.0D;
         double var6 = (double)var1.getHour() + var4 / 60.0D;
         if (!(Boolean)this.fwx.ti()) {
            k(1.0F, var2 / 60.0D * 100.0D, (double)(Integer)this.fwl.ti());
         }

         k(4.0F, var4 / 60.0D * 100.0D, (double)(Integer)this.fwl.ti() * 0.75D);
         k(6.0F, var6 % 12.0D / 12.0D * 100.0D, (double)(Integer)this.fwl.ti() * 0.5D);
         GL11.glEnable(2848);
         GL11.glLineWidth(1.0F);
         GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
         k((double)(Integer)this.fwl.ti(), false, (Double)this.fwg.ti());
         GL11.glDisable(2848);
         GL11.glPopMatrix();
         GL11.glEnable(3553);
      }
   }

   private static void k(float var0, double var1, double var3) {
      double var5 = e(var1);
      GL11.glLineWidth(var0);
      GL11.glBegin(1);
      GL11.glVertex2d(0.0D, 0.0D);
      GL11.glVertex2d(-var3 * Math.sin(var5), var3 * Math.cos(var5));
      GL11.glEnd();
   }

   private static double e(double var0) {
      return var0 / 100.0D * 3.141592653589793D * 2.0D + 3.141592653589793D;
   }

   private static void k(double var0, boolean var2, double var3) {
      double var5 = 6.283185307179586D;
      int var7 = (int)Math.max(15.0D, var0 * var5 / 15.0D);
      var7 = (int)((double)var7 * var3);
      if (var2) {
         boolean var10000 = true;
      }

      GL11.glBegin(2);
      byte var8 = 0;
      if (var8 <= var7) {
         if (var2) {
            GL11.glVertex2d(0.0D, 0.0D);
         }

         GL11.glVertex2d(var0 * Math.cos((double)var8 * var5 / (double)var7), var0 * Math.sin((double)var8 * var5 / (double)var7));
         int var10 = var8 + 1;
      }

      GL11.glEnd();
   }

   private static void v(double var0) {
      double var2 = 6.283185307179586D;
      int var4 = (int)Math.max(15.0D, var0 * var2 / 15.0D);
      var4 *= 2;
      GL11.glBegin(4);
      byte var5 = 0;
      if (var5 <= var4) {
         GL11.glVertex2d(0.0D, 0.0D);
         GL11.glVertex2d(var0 * Math.cos((double)var5 * var2 / (double)var4), var0 * Math.sin((double)var5 * var2 / (double)var4));
         int var8 = var5 + 1;
      }

      GL11.glEnd();
   }
}

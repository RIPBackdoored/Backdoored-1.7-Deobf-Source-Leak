package l.c.i.d;

import java.awt.Color;
import l.c.i.j.j;
import net.minecraft.client.gui.ScaledResolution;

public abstract class a extends c {
   private boolean fhj = false;
   protected l.c.x.x.a fhc = new l.c.x.x.a(0, 0);
   private static final Color fho = new Color(255, 0, 0, 127);
   public static final boolean fhp;
   public static final int fhz;
   public static final boolean fhb;
   private boolean fhj = false;
   protected l.c.x.x.a fhc = new l.c.x.x.a(0, 0);
   private static final Color fho = new Color(255, 0, 0, 127);
   public static final boolean fhp;
   public static final int fhz;
   public static final boolean fhb;

   public a(String var1) {
      this.k(true);
   }

   public void k(int var1, int var2, float var3) {
      if (this.ey()) {
         if (mc.currentScreen instanceof j) {
            label44: {
               if (l.c.a.qfo.v(var1, var2) == this || this.fhj) {
                  if (!this.h()) {
                     l.c.x.f.j.q(this.a().fqs - 1, this.a().fqm - 1, this.a().fqs + this.g().fqs + 1, this.a().fqm + this.g().fqm + 1, fho.getRGB());
                  }

                  l.c.x.f.j.q(this.a().fqs - 1, this.a().fqm - 1, this.a().fqs + this.g().fqs + 1, this.a().fqm + this.g().fqm + 1, Color.DARK_GRAY.getRGB());
                  if (this.fhj) {
                     break label44;
                  }

                  int var4 = mc.fontRenderer.getStringWidth(this.m()) + 1;
                  int var5 = mc.fontRenderer.FONT_HEIGHT + 1;
                  if (!this.h()) {
                     l.c.x.f.j.q(var1 + 5, var2 + 5, var1 + 5 + var4, var2 + 5 + var5, fho.getRGB());
                  }

                  l.c.x.f.j.q(var1 + 5, var2 + 5, var1 + 5 + var4, var2 + 5 + var5, Color.WHITE.getRGB());
                  mc.fontRenderer.drawString(this.m(), var1 + 6, var2 + 6, 0);
               }

               if (!this.h()) {
                  l.c.x.f.j.q(this.a().fqs - 1, this.a().fqm - 1, this.a().fqs + this.g().fqs + 1, this.a().fqm + this.g().fqm + 1, fho.getRGB());
               }

               l.c.x.f.j.q(this.a().fqs - 1, this.a().fqm - 1, this.a().fqs + this.g().fqs + 1, this.a().fqm + this.g().fqm + 1, Color.GRAY.getRGB());
            }
         }

         this.eb();
      }
   }

   public void k(int var1, int var2, int var3) {
      if (l.c.a.qfo.v(var1, var2) == this) {
         boolean var10000 = true;
      }

      boolean var4 = false;
      if (var3 == 1 && var4) {
         if (!this.h()) {
            boolean var10001 = true;
         }

         this.k(false);
      }

      if (var4) {
         this.fhj = true;
         this.fhc.fqs = var1 - this.a().fqs;
         this.fhc.fqm = var2 - this.a().fqm;
         l.c.a.qfo.e(this);
      }

   }

   public void f(int var1, int var2, int var3) {
      this.fhj = false;
   }

   public void q(int var1, int var2, int var3) {
      if (this.fhj) {
         this.a().fqs = var1 - this.fhc.fqs;
         this.a().fqm = var2 - this.fhc.fqm;
         this.eb();
      }

   }

   protected void eb() {
      if (this.a().fqs < 0) {
         this.a().fqs = 0;
      }

      if (this.a().fqm < 0) {
         this.a().fqm = 0;
      }

      ScaledResolution var1 = new ScaledResolution(mc);
      if (this.a().fqs + this.g().fqs > var1.getScaledWidth()) {
         this.a().fqs = var1.getScaledWidth() - this.g().fqs;
      }

      if (this.a().fqm + this.g().fqm > var1.getScaledHeight()) {
      }
   }

   public a(String var1) {
      this.k(true);
   }

   public void k(int var1, int var2, float var3) {
      if (this.ey()) {
         if (mc.currentScreen instanceof j) {
            label44: {
               if (l.c.a.qfo.v(var1, var2) == this || this.fhj) {
                  if (!this.h()) {
                     l.c.x.f.j.q(this.a().fqs - 1, this.a().fqm - 1, this.a().fqs + this.g().fqs + 1, this.a().fqm + this.g().fqm + 1, fho.getRGB());
                  }

                  l.c.x.f.j.q(this.a().fqs - 1, this.a().fqm - 1, this.a().fqs + this.g().fqs + 1, this.a().fqm + this.g().fqm + 1, Color.DARK_GRAY.getRGB());
                  if (this.fhj) {
                     break label44;
                  }

                  int var4 = mc.fontRenderer.getStringWidth(this.m()) + 1;
                  int var5 = mc.fontRenderer.FONT_HEIGHT + 1;
                  if (!this.h()) {
                     l.c.x.f.j.q(var1 + 5, var2 + 5, var1 + 5 + var4, var2 + 5 + var5, fho.getRGB());
                  }

                  l.c.x.f.j.q(var1 + 5, var2 + 5, var1 + 5 + var4, var2 + 5 + var5, Color.WHITE.getRGB());
                  mc.fontRenderer.drawString(this.m(), var1 + 6, var2 + 6, 0);
               }

               if (!this.h()) {
                  l.c.x.f.j.q(this.a().fqs - 1, this.a().fqm - 1, this.a().fqs + this.g().fqs + 1, this.a().fqm + this.g().fqm + 1, fho.getRGB());
               }

               l.c.x.f.j.q(this.a().fqs - 1, this.a().fqm - 1, this.a().fqs + this.g().fqs + 1, this.a().fqm + this.g().fqm + 1, Color.GRAY.getRGB());
            }
         }

         this.eb();
      }
   }

   public void k(int var1, int var2, int var3) {
      if (l.c.a.qfo.v(var1, var2) == this) {
         boolean var10000 = true;
      }

      boolean var4 = false;
      if (var3 == 1 && var4) {
         if (!this.h()) {
            boolean var10001 = true;
         }

         this.k(false);
      }

      if (var4) {
         this.fhj = true;
         this.fhc.fqs = var1 - this.a().fqs;
         this.fhc.fqm = var2 - this.a().fqm;
         l.c.a.qfo.e(this);
      }

   }

   public void f(int var1, int var2, int var3) {
      this.fhj = false;
   }

   public void q(int var1, int var2, int var3) {
      if (this.fhj) {
         this.a().fqs = var1 - this.fhc.fqs;
         this.a().fqm = var2 - this.fhc.fqm;
         this.eb();
      }

   }

   protected void eb() {
      if (this.a().fqs < 0) {
         this.a().fqs = 0;
      }

      if (this.a().fqm < 0) {
         this.a().fqm = 0;
      }

      ScaledResolution var1 = new ScaledResolution(mc);
      if (this.a().fqs + this.g().fqs > var1.getScaledWidth()) {
         this.a().fqs = var1.getScaledWidth() - this.g().fqs;
      }

      if (this.a().fqm + this.g().fqm > var1.getScaledHeight()) {
      }
   }

   public void t(boolean var1) {
      this.fhj = var1;
   }

   public boolean ey() {
      boolean var10000 = true;
      return false;
   }
}

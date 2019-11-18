package l.c.i.j;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import l.c.i.d.c;
import net.minecraft.client.gui.FontRenderer;

public class a extends l.c.i.d.a {
   public static final boolean fmf;
   public static final int fmq;
   public static final boolean fmt;

   public a() {
      super("Element Picker");
   }

   public void k(int var1, int var2, float var3) {
      if (mc.currentScreen instanceof j) {
         List var4 = (List)l.c.a.qfo.qqh.stream().filter(this::f).collect(Collectors.toList());
         this.a().fqs = var4.size() * (mc.fontRenderer.FONT_HEIGHT + 2) - 2;
         l.c.x.f.j.q(this.a().fqs, this.a().fqm, this.g().fqs, this.g().fqm, Color.BLACK.getRGB());
         mc.fontRenderer.drawString("Element Picket", this.a().fqs + 2, this.a().fqm + 2, Color.WHITE.getRGB());
         int var5 = mc.fontRenderer.FONT_HEIGHT + 2;
         l.c.x.f.j.q(this.a().fqs + 2, this.a().fqm + 2 + var5, this.g().fqs - 2, this.g().fqm - 2, Color.WHITE.getRGB());
         Iterator var6 = var4.iterator();
         if (var6.hasNext()) {
            c var7 = (c)var6.next();
            FontRenderer var10000 = mc.fontRenderer;
            String var10001 = var7.m();
            int var10002 = this.a().fqs + 2;
            int var10003 = this.a().fqm + var5;
            if (var7.h()) {
               Color.GRAY.getRGB();
            }

            var10000.drawString(var10001, var10002, var10003, Color.WHITE.getRGB());
            var5 += mc.fontRenderer.FONT_HEIGHT + 2;
         }

         this.g().fqm = var5 + mc.fontRenderer.FONT_HEIGHT + 2;
      }

      this.eb();
   }

   public void f(int var1, int var2, int var3) {
      super.f(var1, var2, var3);
      if (this.f(var1, var2)) {
         List var4 = (List)l.c.a.qfo.qqh.stream().filter(this::k).collect(Collectors.toList());
         int var5 = mc.fontRenderer.FONT_HEIGHT + 2;
         Iterator var6 = var4.iterator();
         if (var6.hasNext()) {
            c var7 = (c)var6.next();
            if (var1 >= this.a().fqs + 2 && var2 >= this.a().fqm + var5 && var1 <= this.a().fqs + 2 + mc.fontRenderer.getStringWidth(var7.m()) && var2 <= this.a().fqm + var5 + mc.fontRenderer.FONT_HEIGHT) {
               boolean var10000 = true;
            }

            boolean var8 = false;
            if (var8) {
               if (!var7.h()) {
                  boolean var10001 = true;
               }

               var7.k(false);
            }

            var5 += mc.fontRenderer.FONT_HEIGHT + 2;
         }
      }

   }

   // $FF: synthetic method
   private boolean k(c var1) {
      if (var1 != this) {
         boolean var10000 = true;
      }

      return false;
   }

   // $FF: synthetic method
   private boolean f(c var1) {
      if (var1 != this) {
         boolean var10000 = true;
      }

      return false;
   }
}

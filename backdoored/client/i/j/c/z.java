package l.c.i.j.c;

import  l. c. i. j. c. z;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import l.c.h.j.i;
import l.c.i.d.a;
import l.c.x.b;

public class z extends a {
   public static final boolean fmd;
   public static final int fms;
   public static final boolean fmm;

   public z() {
      super("Enabled Hacks");
   }

   public void k(int var1, int var2, float var3) {
      super.k(var1, var2, var3);
      if (this.ey()) {
         List var4 = (List)i.qg().stream().filter( z::k).collect(Collectors.toList());
         int var5 = 0;
         byte var6 = 0;
         Iterator var7 = var4.iterator();
         if (var7.hasNext()) {
            l.c.h.j.w var8 = (l.c.h.j.w)var7.next();
            b.k(var8.gw, this.a().fqs, this.a().fqm + var6);
            int var13 = var6 + mc.fontRenderer.FONT_HEIGHT + 2;
            int var9 = mc.fontRenderer.getStringWidth(var8.gw);
            if (var9 > var5) {
               var5 = var9;
            }
         }

         int var14 = var4.size() * (mc.fontRenderer.FONT_HEIGHT + 2);
         var14 -= 2;
         this.f(new l.c.x.x.a(var5, var14));
      }
   }

   // $FF: synthetic method
   private static boolean k(l.c.h.j.w var0) {
      if (var0.qm() && (Boolean)var0.wk.ti()) {
         boolean var10000 = true;
      }

      return false;
   }
}

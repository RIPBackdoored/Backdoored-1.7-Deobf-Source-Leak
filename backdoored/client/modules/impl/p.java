package l.c.h.j;

import java.util.Comparator;
import l.c.f.h;

class p implements Comparator {
   public static final int fbi;
   public static final boolean fbd;

   public int k(w var1, w var2) {
      int var3 = h.fontRenderer.getStringWidth(var1.gw);
      int var4 = h.fontRenderer.getStringWidth(var2.gw);
      return Integer.compare(var4, var3);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compare(Object var1, Object var2) {
      return this.k((w)var1, (w)var2);
   }
}

package l.c.v;

import java.util.Iterator;
import l.c.h.j.i;
import l.c.x.d.a;

public class n extends d {
   public static final boolean qka;
   public static final int qkg;
   public static final boolean qkw;

   public n() {
      super("toggle", "t");
   }

   public boolean k(String[] var1) {
      StringBuilder var2 = new StringBuilder();
      int var4 = var1.length;
      byte var5 = 0;
      String var6 = var1[var5];
      var2.append(var6);
      int var11 = var5 + 1;
      Iterator var3 = i.qg().iterator();
      if (var3.hasNext()) {
         l.c.h.j.w var10 = (l.c.h.j.w)var3.next();
         if (var2.toString().equalsIgnoreCase(var10.gw.replace(" ", ""))) {
            if (!var10.qm()) {
               boolean var10001 = true;
            }

            var10.f(false);
            return true;
         }
      }

      a.m(var2.toString() + " not found!", "red");
      return false;
   }

   public String v() {
      return "-t <hackname>";
   }
}

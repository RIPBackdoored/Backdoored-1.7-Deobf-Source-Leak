package l.c.v;

import java.util.Iterator;
import l.c.h.j.i;
import l.c.x.d.a;

public class k extends d {
   public static final boolean fda;
   public static final int fdg;
   public static final boolean fdw;

   public k() {
      super("drawn", "shown", "visible");
   }

   public boolean k(String[] var1) {
      if (var1.length < 1) {
         a.fs("Invalid args!");
         return false;
      } else {
         StringBuilder var2 = new StringBuilder();
         int var4 = var1.length;
         byte var5 = 0;
         String var6;
         if (var5 < var4) {
            var6 = var1[var5];
            var2.append(var6);
            int var11 = var5 + 1;
         }

         String var3 = var2.toString();
         Iterator var10 = i.qg().iterator();
         if (var10.hasNext()) {
            l.c.h.j.w var12 = (l.c.h.j.w)var10.next();
            if (var3.equalsIgnoreCase(var12.gw.replace(" ", ""))) {
               l.c.h.h.j var10000 = var12.wk;
               if (!(Boolean)var12.wk.ti()) {
                  boolean var10001 = true;
               }

               var10000.k(false);
               var6 = "not ";
               if ((Boolean)var12.wk.ti()) {
                  var6 = "";
               }

               a.fs("Hack '" + var3 + "' is now " + var6 + "drawn");
               return true;
            }
         }

         a.fs("Could not find hack '" + var3 + "'");
         return false;
      }
   }

   public String v() {
      return "-drawn Twerk";
   }
}

package l.c.v;

import java.util.Iterator;
import l.c.h.j.i;
import l.c.x.d.a;

public class p extends d {
   public static final boolean fcd;
   public static final int fcs;
   public static final boolean fcm;

   public p() {
      super("unbind");
   }

   public boolean k(String[] var1) {
      if (var1.length < 1) {
         a.fs("Invalid args!");
         return false;
      } else {
         StringBuilder var2 = new StringBuilder();
         int var4 = var1.length;
         byte var5 = 0;
         if (var5 < var4) {
            String var6 = var1[var5];
            var2.append(var6);
            throw null;
         } else {
            String var3 = var2.toString();
            Iterator var10 = i.qg().iterator();
            if (var10.hasNext()) {
               l.c.h.j.w var11 = (l.c.h.j.w)var10.next();
               if (var3.equalsIgnoreCase(var11.gw.replace(" ", ""))) {
                  var11.wf.k("NONE");
                  a.fs("Bound " + var3 + " to " + (String)var11.wf.ti());
               }
            }

            a.fs("Could not find hack '" + var3 + "'");
            return false;
         }
      }
   }

   public String v() {
      return "-unbind Twerk";
   }
}

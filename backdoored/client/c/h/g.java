package l.c.c.h;

import  l. c. c. h. g;
import java.util.Iterator;
import l.c.c.d.v;

public class g extends a {
   public static final boolean fbe;
   public static final int fbv;
   public static final boolean fbu;

   public void qo() {
      Iterator var1 = v.r().iterator();
      if (var1.hasNext()) {
         v var2 = (v)var1.next();
         if (var2.tv().qm()) {
            var2.sl = "FF0000";
         }

         var2.sl = "FFFFFF";
         if (var2.sj) {
            var2.vq().forEach( g::f);
            Iterator var3 = var2.vf().er().iterator();
            if (var3.hasNext()) {
               v var4 = (v)var3.next();
               if (var4 != var2) {
                  var4.vq().forEach( g::k);
               }
            }

            var2.sj = false;
         }
      }

   }

   // $FF: synthetic method
   private static void k(l.c.c.d.a var0) {
      var0.sy = false;
   }

   // $FF: synthetic method
   private static void f(l.c.c.d.a var0) {
      if (!var0.sy) {
         boolean var10001 = true;
      }

      var0.sy = false;
   }
}

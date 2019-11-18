package l.c.h.h;

import java.util.ArrayList;
import java.util.Iterator;
import l.c.h.j.w;

public class v {
   static ArrayList flc = new ArrayList();
   public static final boolean flo;
   public static final int flp;
   public static final boolean flz;

   public static ArrayList eo() {
      return flc;
   }

   public static ArrayList f(w var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = flc.iterator();
      if (var2.hasNext()) {
         j var3 = (j)var2.next();
         if (var3.tv() == var0) {
            var1.add(var3);
         }
      }

      return var1;
   }
}

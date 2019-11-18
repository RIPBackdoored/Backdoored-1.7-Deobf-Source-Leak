package l.c.h.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l.c.z.d;

public class i {
   private static List ra = new i$d();
   static Map rg = new HashMap();
   private static Boolean rw = null;
   public static p rn = new p();
   public static t rr = new t();
   public static final boolean fkk;
   public static final int fkf;
   public static final boolean fkq;

   public static List qg() {
      return ra;
   }

   public static w r(String var0) {
      Iterator var1 = ra.iterator();
      if (var1.hasNext()) {
         w var2 = (w)var1.next();
         if (var2.gw.equalsIgnoreCase(var0)) {
            return var2;
         }
      }

      throw new RuntimeException(d.i(10) + var0 + d.i(11));
   }

   public static w k(Class var0) {
      Iterator var1 = ra.iterator();
      if (var1.hasNext()) {
         w var2 = (w)var1.next();
         if (var2.getClass() == var0) {
            return var2;
         }
      }

      throw new RuntimeException(d.i(12) + var0.getName() + d.i(11));
   }

   public static HashMap qw() {
      HashMap var0 = new HashMap();
      Iterator var1 = ra.iterator();
      if (var1.hasNext()) {
         w var2 = (w)var1.next();
         if (var0.containsKey(var2.gn)) {
            ((List)var0.get(var2.gn)).add(var2);
         }

         var0.put(var2.gn, new ArrayList(Arrays.asList(var2)));
      }

      return var0;
   }

   public static void q(boolean var0) {
      if (var0) {
         if (rw != null && rw) {
            return;
         }

         ra.sort(rr);
      }

      if (rw == null || rw) {
         ra.sort(rn);
         rw = false;
      }

   }
}

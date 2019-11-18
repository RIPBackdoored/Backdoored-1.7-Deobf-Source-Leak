package l.c.v;

import java.util.Arrays;
import java.util.Iterator;
import l.c.h.j.i;
import l.c.x.d.a;

public class s extends d {
   public static final boolean fgc;
   public static final int fgo;
   public static final boolean fgp;

   public s() {
      super("bind", "keybind");
   }

   public boolean k(String[] var1) {
      if (var1.length <= 0) {
         a.fs("Please specify a hack!");
         return false;
      } else {
         StringBuilder var2 = new StringBuilder();
         int var4 = var1.length;
         byte var5 = 0;
         String var6;
         int var12;
         if (var5 < var4) {
            var6 = var1[var5];
            var2.append(var6);
            var12 = var5 + 1;
         }

         Iterator var3 = i.qg().iterator();
         l.c.h.j.w var11;
         if (var3.hasNext()) {
            var11 = (l.c.h.j.w)var3.next();
            if (var2.toString().equalsIgnoreCase(var11.gw.replace(" ", ""))) {
               a.fs(var11.gw + ": " + (String)var11.wf.ti());
               return true;
            }
         }

         var2 = new StringBuilder();
         String[] var10 = (String[])Arrays.copyOf(var1, var1.length - 1);
         var4 = var10.length;
         var5 = 0;
         var2.append(var6);
         var12 = var5 + 1;
         var3 = i.qg().iterator();
         if (var3.hasNext()) {
            var11 = (l.c.h.j.w)var3.next();
            if (var2.toString().equalsIgnoreCase(var11.gw.replace(" ", ""))) {
               var11.wf.k(var1[var1.length - 1].toUpperCase());
               a.fs("Set keybind of hack '" + var11.gw + "' to '" + (String)var11.wf.ti() + "'");
               return true;
            }
         }

         a.m(var2.toString() + " not found!", "red");
         return false;
      }
   }

   public String v() {
      return "-t <hackname>";
   }
}

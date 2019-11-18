package l.c.k;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import l.c.a;
import l.c.h.h.v;
import l.c.h.j.i;
import l.c.h.j.w;
import l.c.v.x;
import org.json.JSONObject;

public class j {
   public static final boolean fi;
   public static final int fd;
   public static final boolean fs;

   static void k(File var0) throws IOException {
      JSONObject var1 = new JSONObject();
      JSONObject var2 = new JSONObject();
      Iterator var3 = i.qg().iterator();
      w var4;
      JSONObject var5;
      if (var3.hasNext()) {
         var4 = (w)var3.next();
         var5 = new JSONObject();
         var5.put("Enabled", var4.qc());
         ArrayList var6 = v.f(var4);
         if (var6 != null) {
            Iterator var7 = var6.iterator();
            if (var7.hasNext()) {
               l.c.h.h.j var8 = (l.c.h.h.j)var7.next();
               if (var8.ti() instanceof Enum) {
                  var5.put(var8.m(), (Object)((Enum)var8.ti()).name());
               }

               var5.put(var8.m(), var8.ti());
            }
         }

         var2.put(var4.gw, (Object)var5);
      }

      var1.put("Hacks", (Object)var2);
      var2 = new JSONObject();
      var3 = a.qfo.qqh.iterator();
      var5 = new JSONObject();
      var5.put("Visible", var4.h());
      if (var4 instanceof l.c.i.d.a) {
         var5.put("x", var4.a().fqs);
         var5.put("y", var4.a().fqm);
      }

      var2.put(var4.m(), (Object)var5);
      var1.put("Hud", (Object)var2);
      var2 = new JSONObject();
      var2.put("Prefix", (Object)x.zd);
      var1.put("Commands", (Object)var2);
      PrintWriter var12 = new PrintWriter(new FileWriter(var0));
      var12.print(var1.toString(4));
      var12.close();
   }
}

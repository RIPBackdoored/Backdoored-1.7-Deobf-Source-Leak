package l.c.k;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import l.c.a;
import l.c.h.h.v;
import l.c.h.j.i;
import l.c.h.j.w;
import l.c.i.d.c;
import org.json.JSONObject;

/** @deprecated */
@Deprecated
public class b {
   private static final File hu = new File("Backdoored/config.json");
   private static JSONObject hi = new JSONObject();
   private static JSONObject hd = new JSONObject();
   private static JSONObject hs = new JSONObject();
   private static JSONObject hm = new JSONObject();
   private static JSONObject hj = new JSONObject();
   public static final boolean hc;
   public static final int ho;
   public static final boolean hp;

   public static void fa() {
      f(hu);
   }

   public static void f(File param0) {
      // $FF: Couldn't be decompiled
   }

   private static Object k(w var0, String var1) {
      return q(var0.gw, var1);
   }

   private static Object q(String var0, String var1) {
      Object var10000;
      try {
         var10000 = hd.getJSONObject(var0).get(var1);
      } catch (Exception var6) {
         return null;
      }

      return var10000;
   }

   private static Object k(l.c.c.d.j var0, String var1) {
      return t(var0.sb, var1);
   }

   private static Object t(String var0, String var1) {
      Object var10000;
      try {
         var10000 = hs.getJSONObject(var0).get(var1);
      } catch (Exception var6) {
         return null;
      }

      return var10000;
   }

   private static Object y(String var0) {
      Object var10000;
      try {
         var10000 = hm.get(var0);
      } catch (Exception var5) {
         return null;
      }

      return var10000;
   }

   private static Object e(String var0, String var1) {
      Object var10000;
      try {
         var10000 = hj.getJSONObject(var0).get(var1);
      } catch (Exception var6) {
         return null;
      }

      return var10000;
   }

   public static void fg() {
      k(hu);
   }

   public static void k(File param0) {
      // $FF: Couldn't be decompiled
   }

   private static JSONObject fw() {
      Iterator var0 = i.qg().iterator();
      if (var0.hasNext()) {
         w var1 = (w)var0.next();
         JSONObject var2 = new JSONObject();
         var2.put("Enabled", var1.qm());
         ArrayList var3 = v.f(var1);
         if (var3 != null) {
            Iterator var4 = var3.iterator();
            if (var4.hasNext()) {
               l.c.h.h.j var5 = (l.c.h.h.j)var4.next();
               var2.put(var5.m(), var5.ti());
            }
         }

         hd.put(var1.gw, (Object)var2);
      }

      return hd;
   }

   private static JSONObject fn() {
      Iterator var0 = l.c.c.d.j.r().iterator();
      if (var0.hasNext()) {
         l.c.c.d.j var1 = (l.c.c.d.j)var0.next();
         JSONObject var2 = new JSONObject();
         var2.put("x", var1.sc);
         var2.put("y", var1.so);
         var2.put("open", var1.sj);
         hs.put(var1.sb, (Object)var2);
      }

      return hs;
   }

   private static JSONObject fr() {
      return hm;
   }

   private static JSONObject qk() {
      Iterator var0 = a.qfo.qqh.iterator();
      if (var0.hasNext()) {
         c var1 = (c)var0.next();
         JSONObject var2 = new JSONObject();
         var2.put("Visible", (Object)var1.h());
         var2.put("x", (Object)var1.a().fqs);
         var2.put("y", (Object)var1.a().fqm);
         hj.put(var1.m(), (Object)var2);
      }

      return hj;
   }
}

package l.c.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l.c.c.d.c;
import l.c.c.d.v;
import l.c.h.j.w;
import net.minecraft.util.ResourceLocation;

public class j {
   public static final ResourceLocation resourceLocation = new ResourceLocation("backdoored", "textures/white.png");
   public static Map u = new HashMap();
   public static Map i = new HashMap();
   public static Map d = new HashMap();
   private static boolean s = false;
   public static final boolean m;
   public static final int j;
   public static final boolean c;
   public static final ResourceLocation resourceLocation = new ResourceLocation("backdoored", "textures/white.png");
   public static Map u = new HashMap();
   public static Map i = new HashMap();
   public static Map d = new HashMap();
   private static boolean s = false;
   public static final boolean m;
   public static final int j;
   public static final boolean c;

   public j() {
   }

   public static void k() {
      // $FF: Couldn't be decompiled
   }

   public j() {
   }

   public static void k() {
      // $FF: Couldn't be decompiled
   }

   static w k(c var0) {
      Iterator var1 = v.r().iterator();
      if (var1.hasNext()) {
         v var2 = (v)var1.next();
         return var2.tv();
      } else {
         return null;
      }
   }

   static c k(int var0, int var1) {
      Iterator var2 = q().iterator();
      if (var2.hasNext()) {
         c var3 = (c)var2.next();
         if (!var3.sy) {
            ;
         }

         if (var0 <= var3.sc + var3.sp && var1 >= var3.so && var1 <= var3.so + var3.sz) {
            return var3;
         }
      }

      return null;
   }

   public static ArrayList f() {
      ArrayList var0 = new ArrayList();
      Iterator var1 = l.c.c.d.j.r().iterator();
      if (var1.hasNext()) {
         l.c.c.d.j var2 = (l.c.c.d.j)var1.next();
         var0.add(var2);
         Iterator var3 = var2.er().iterator();
         if (var3.hasNext()) {
            v var4 = (v)var3.next();
            var0.add(var4);
            var0.addAll(var4.vq());
         }

         throw null;
      } else {
         return var0;
      }
   }

   public static ArrayList q() {
      // $FF: Couldn't be decompiled
   }
}

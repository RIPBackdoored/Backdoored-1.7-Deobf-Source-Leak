package l.c.i.j;

import  l. c. i. j. j;
import l.c.i.d.c;
import net.minecraft.client.gui.GuiScreen;

public class j extends GuiScreen {
   public static final boolean fhy;
   public static final int fhx;
   public static final boolean fhl;

   public void func_73866_w_() {
   }

   public void func_73863_a(int var1, int var2, float var3) {
      byte var4 = 0;
      if (var4 < l.c.a.qfo.qqh.size()) {
         c var5 = (c)l.c.a.qfo.qqh.get(var4);
         var5.k(var1, var2, var3);
         int var9 = var4 + 1;
      }

   }

   protected void func_73864_a(int var1, int var2, int var3) {
      byte var4 = 0;
      if (var4 < l.c.a.qfo.qqh.size()) {
         c var5 = (c)l.c.a.qfo.qqh.get(var4);
         int var9 = var4 + 1;
      }

   }

   protected void func_146286_b(int var1, int var2, int var3) {
      byte var4 = 0;
      if (var4 < l.c.a.qfo.qqh.size()) {
         c var5 = (c)l.c.a.qfo.qqh.get(var4);
         var5.f(var1, var2, var3);
         throw null;
      }
   }

   public void func_146273_a(int var1, int var2, int var3, long var4) {
      byte var6 = 0;
      if (var6 < l.c.a.qfo.qqh.size()) {
         c var7 = (c)l.c.a.qfo.qqh.get(var6);
         var7.q(var1, var2, var3);
      }

   }

   public boolean func_73868_f() {
      return false;
   }

   public void func_146281_b() {
      l.c.a.qfo.qqh.stream().filter( j::t).map( j::q).forEach( j::k);
   }

   // $FF: synthetic method
   private static void k(l.c.i.d.a var0) {
      var0.t(false);
   }

   // $FF: synthetic method
   private static l.c.i.d.a q(c var0) {
      return (l.c.i.d.a)var0;
   }

   // $FF: synthetic method
   private static boolean t(c var0) {
      return var0 instanceof l.c.i.d.a;
   }
}

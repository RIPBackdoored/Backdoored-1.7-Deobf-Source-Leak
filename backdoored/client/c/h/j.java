package l.c.c.h;

import  l. c. c. h. j;
import java.util.Iterator;
import l.c.c.t;
import l.c.c.d.v;
import org.lwjgl.input.Mouse;

public class j extends a {
   private l.c.c.d.j fab;
   public static final boolean fay;
   public static final int fax;
   public static final boolean fal;

   public void qo() {
      Iterator var1;
      l.c.c.d.j var2;
      Iterator var3;
      v var4;
      if (Mouse.isButtonDown(0) || Mouse.isButtonDown(1)) {
         var1 = l.c.c.d.j.vk().iterator();
         if (var1.hasNext()) {
            var2 = (l.c.c.d.j)var1.next();
            if (var2.fnd) {
               ;
            }
         }

         var1 = l.c.c.d.j.vk().iterator();
         if (var1.hasNext()) {
            var2 = (l.c.c.d.j)var1.next();
            if (t.frm > var2.sc && t.frj > var2.so && t.frm < var2.sc + 100 && t.frj < var2.so + 20) {
               this.k(var2);
            }

            var3 = var2.er().iterator();
            if (var3.hasNext()) {
               var4 = (v)var3.next();
               if (t.frm > var4.sc && t.frj > var4.so && t.frm < var4.sc + var4.sp && t.frj < var4.so + var4.sz) {
                  this.k(var2);
               }

               Iterator var5 = var4.vq().iterator();
               if (var5.hasNext()) {
                  l.c.c.d.a var6 = (l.c.c.d.a)var5.next();
                  if (t.frm > var6.sc && t.frj > var6.so && t.frm < var6.sc + var6.sp && t.frj < var6.so + var6.sz) {
                     this.k(var2);
                  }
               }
            }
         }
      }

      this.ea();
      var1 = l.c.c.d.j.vk().iterator();
      if (var1.hasNext()) {
         var2 = (l.c.c.d.j)var1.next();
         if (Mouse.isButtonDown(0) && t.frm > var2.sc && t.frj > var2.so && t.frm < var2.sc + 100 && t.frj < var2.so + 20 && !var2.fnd) {
            var2.fns = t.frm - var2.sc;
            var2.fnm = t.frj - var2.so;
            var2.fnd = true;
         }

         if (var2.fnd) {
            var2.sc = t.frm - var2.fns;
            var2.so = t.frj - var2.fnm;
         }

         if (!Mouse.isButtonDown(0)) {
            var2.fnd = false;
         }

         if (var2.fnd && Mouse.isButtonDown(0)) {
            ;
         }
      }

      var1 = l.c.c.d.j.vk().iterator();
      if (var1.hasNext()) {
         var2 = (l.c.c.d.j)var1.next();
         if (!var2.sj) {
            var3 = var2.er().iterator();
            if (var3.hasNext()) {
               var4 = (v)var3.next();
               var4.sy = false;
               var4.vq().forEach( j::f);
            }
         }

         var2.er().forEach( j::k);
         var3 = null;
         Iterator var10 = var2.er().iterator();
         if (var10.hasNext()) {
            v var11 = (v)var10.next();
            var11.sc = var2.sc;
            if (var3 != null) {
               var11.so = var3.so + var3.sz;
            }

            var11.so = var2.so + 20;
         }
      }

   }

   private void k(l.c.c.d.j var1) {
   }

   private void ea() {
      if (this.fab != null) {
         l.c.c.d.j.r().remove(this.fab);
         l.c.c.d.j.r().add(this.fab);
      }

   }

   // $FF: synthetic method
   private static void k(v var0) {
      var0.sy = true;
   }

   // $FF: synthetic method
   private static void f(l.c.c.d.a var0) {
      var0.sy = false;
   }
}

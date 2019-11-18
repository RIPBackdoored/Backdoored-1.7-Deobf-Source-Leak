package l.c.x.f;

public class c$f {
   public c$o fuc;
   public c$o fuo = new c$o(0.0D, 0.0D, 0.0D);
   public static final int fup;
   public static final boolean fuz;

   public c$f(double var1, double var3, double var5, double var7, double var9, double var11) {
      this.fuc.fxu = var1;
      this.fuc.fxi = var3;
      this.fuc.fxd = var5;
      this.fuo.fxu = var7;
      this.fuo.fxi = var9;
      this.fuo.fxd = var11;
   }

   public c$o k(c$f var1) {
      double var2 = this.fuc.fxu;
      double var4 = this.fuo.fxu;
      double var6 = var1.fuc.fxu;
      double var8 = var1.fuo.fxu;
      double var10 = this.fuc.fxi;
      double var12 = this.fuo.fxi;
      double var14 = var1.fuc.fxi;
      double var16 = var1.fuo.fxi;
      double var18 = -(var2 * var16 - var6 * var16 - var8 * (var10 - var14));
      double var20 = var4 * var16 - var8 * var12;
      if (var20 == 0.0D) {
         return this.f(var1);
      } else {
         double var22 = var18 / var20;
         c$o var24 = new c$o(0.0D, 0.0D, 0.0D);
         var24.fxu = this.fuc.fxu + this.fuo.fxu * var22;
         var24.fxi = this.fuc.fxi + this.fuo.fxi * var22;
         var24.fxd = this.fuc.fxd + this.fuo.fxd * var22;
         return var24;
      }
   }

   private c$o f(c$f var1) {
      double var2 = this.fuc.fxu;
      double var4 = this.fuo.fxu;
      double var6 = var1.fuc.fxu;
      double var8 = var1.fuo.fxu;
      double var10 = this.fuc.fxd;
      double var12 = this.fuo.fxd;
      double var14 = var1.fuc.fxd;
      double var16 = var1.fuo.fxd;
      double var18 = -(var2 * var16 - var6 * var16 - var8 * (var10 - var14));
      double var20 = var4 * var16 - var8 * var12;
      if (var20 == 0.0D) {
         return this.q(var1);
      } else {
         double var22 = var18 / var20;
         c$o var24 = new c$o(0.0D, 0.0D, 0.0D);
         var24.fxu = this.fuc.fxu + this.fuo.fxu * var22;
         var24.fxi = this.fuc.fxi + this.fuo.fxi * var22;
         var24.fxd = this.fuc.fxd + this.fuo.fxd * var22;
         return var24;
      }
   }

   private c$o q(c$f var1) {
      double var2 = this.fuc.fxi;
      double var4 = this.fuo.fxi;
      double var6 = var1.fuc.fxi;
      double var8 = var1.fuo.fxi;
      double var10 = this.fuc.fxd;
      double var12 = this.fuo.fxd;
      double var14 = var1.fuc.fxd;
      double var16 = var1.fuo.fxd;
      double var18 = -(var2 * var16 - var6 * var16 - var8 * (var10 - var14));
      double var20 = var4 * var16 - var8 * var12;
      if (var20 == 0.0D) {
         return null;
      } else {
         double var22 = var18 / var20;
         c$o var24 = new c$o(0.0D, 0.0D, 0.0D);
         var24.fxu = this.fuc.fxu + this.fuo.fxu * var22;
         var24.fxi = this.fuc.fxi + this.fuo.fxi * var22;
         var24.fxd = this.fuc.fxd + this.fuo.fxd * var22;
         return var24;
      }
   }

   public c$o k(c$o var1, c$o var2) {
      c$o var3 = new c$o(this.fuc.fxu, this.fuc.fxi, this.fuc.fxd);
      double var4 = var1.f(this.fuc).q(var2) / this.fuo.q(var2);
      var3.e(this.fuo.k(var4));
      return this.fuo.q(var2) == 0.0D ? null : var3;
   }
}

package l.c.x.f;

public class c$o {
   public double fxu;
   public double fxi;
   public double fxd;
   public static final int fxs;
   public static final boolean fxm;

   public c$o(double var1, double var3, double var5) {
      this.fxu = var1;
      this.fxi = var3;
      this.fxd = var5;
   }

   public c$o k(c$o var1) {
      return new c$o(this.fxu + var1.fxu, this.fxi + var1.fxi, this.fxd + var1.fxd);
   }

   public c$o k(double var1, double var3, double var5) {
      return new c$o(this.fxu + var1, this.fxi + var3, this.fxd + var5);
   }

   public c$o f(c$o var1) {
      return new c$o(this.fxu - var1.fxu, this.fxi - var1.fxi, this.fxd - var1.fxd);
   }

   public c$o f(double var1, double var3, double var5) {
      return new c$o(this.fxu - var1, this.fxi - var3, this.fxd - var5);
   }

   public c$o ed() {
      double var1 = Math.sqrt(this.fxu * this.fxu + this.fxi * this.fxi + this.fxd * this.fxd);
      return new c$o(this.fxu / var1, this.fxi / var1, this.fxd / var1);
   }

   public double q(c$o var1) {
      return this.fxu * var1.fxu + this.fxi * var1.fxi + this.fxd * var1.fxd;
   }

   public c$o t(c$o var1) {
      return new c$o(this.fxi * var1.fxd - this.fxd * var1.fxi, this.fxd * var1.fxu - this.fxu * var1.fxd, this.fxu * var1.fxi - this.fxi * var1.fxu);
   }

   public c$o k(double var1) {
      return new c$o(this.fxu * var1, this.fxi * var1, this.fxd * var1);
   }

   public c$o f(double var1) {
      return new c$o(this.fxu / var1, this.fxi / var1, this.fxd / var1);
   }

   public double es() {
      return Math.sqrt(this.fxu * this.fxu + this.fxi * this.fxi + this.fxd * this.fxd);
   }

   public c$o e(c$o var1) {
      this.fxu += var1.fxu;
      this.fxi += var1.fxi;
      this.fxd += var1.fxd;
      return this;
   }

   public c$o q(double var1, double var3, double var5) {
      this.fxu += var1;
      this.fxi += var3;
      this.fxd += var5;
      return this;
   }

   public c$o v(c$o var1) {
      this.fxu -= var1.fxu;
      this.fxi -= var1.fxi;
      this.fxd -= var1.fxd;
      return this;
   }

   public c$o t(double var1, double var3, double var5) {
      this.fxu -= var1;
      this.fxi -= var3;
      this.fxd -= var5;
      return this;
   }

   public c$o em() {
      double var1 = Math.sqrt(this.fxu * this.fxu + this.fxi * this.fxi + this.fxd * this.fxd);
      this.fxu /= var1;
      this.fxi /= var1;
      this.fxd /= var1;
      return this;
   }

   public c$o u(c$o var1) {
      this.fxu = this.fxi * var1.fxd - this.fxd * var1.fxi;
      this.fxi = this.fxd * var1.fxu - this.fxu * var1.fxd;
      return this;
   }

   public c$o q(double var1) {
      this.fxu *= var1;
      this.fxi *= var1;
      this.fxd *= var1;
      return this;
   }

   public c$o t(double var1) {
      this.fxu /= var1;
      this.fxi /= var1;
      this.fxd /= var1;
      return this;
   }

   public String toString() {
      return "(X: " + this.fxu + " Y: " + this.fxi + " Z: " + this.fxd + ")";
   }
}

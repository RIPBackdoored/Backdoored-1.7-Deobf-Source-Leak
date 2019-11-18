package l.c.i.d;

import l.c.q;

public abstract class c implements q {
   private String vj;
   private boolean vc = true;
   private l.c.x.x.a vo = new l.c.x.x.a(0, 0);
   private l.c.x.x.a vp = new l.c.x.x.a(0, 0);
   public static final boolean vz;
   public static final int vb;
   public static final boolean vy;

   c() {
   }

   public c(int var1, int var2, int var3, int var4) {
      this.vo = new l.c.x.x.a(var1, var2);
      this.vp = new l.c.x.x.a(var3, var4);
   }

   public boolean f(int var1, int var2) {
      if (var1 >= this.a().fqs && var2 >= this.a().fqm && var1 <= this.a().fqs + this.g().fqs && var2 <= this.a().fqm + this.g().fqm) {
         boolean var10000 = true;
      }

      return false;
   }

   public abstract void k(int var1, int var2, float var3);

   public abstract void k(int var1, int var2, int var3);

   public abstract void f(int var1, int var2, int var3);

   public abstract void q(int var1, int var2, int var3);

   public String m() {
      return this.vj;
   }

   public void d(String var1) {
   }

   public boolean h() {
      return this.vc;
   }

   public void k(boolean var1) {
      this.vc = var1;
   }

   public l.c.x.x.a a() {
      return this.vo;
   }

   public void k(l.c.x.x.a var1) {
      this.vo = var1;
   }

   public l.c.x.x.a g() {
      return this.vp;
   }

   public void f(l.c.x.x.a var1) {
      this.vp = var1;
   }

   public String toString() {
      return this.m();
   }
}

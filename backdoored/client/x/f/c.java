package l.c.x.f;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;

public final class c {
   private static c ha;
   private final FloatBuffer hg = BufferUtils.createFloatBuffer(3);
   private IntBuffer hw;
   private FloatBuffer hn;
   private FloatBuffer hr;
   private c$o ak;
   private c$o[] af;
   private c$o[] aq;
   private c$o at;
   private double ae;
   private double av;
   private double au;
   private double ai;
   private double ad;
   private double as;
   private double am;
   private double aj;
   private c$f ac;
   private c$f ao;
   private c$f ap;
   private c$f az;
   private float ab;
   private float ay;
   private c$o ax;
   public static final boolean al;
   public static final int ah;
   public static final boolean aa;

   private c() {
   }

   public static c qf() {
      if (ha == null) {
         ha = new c();
      }

      return ha;
   }

   public void k(IntBuffer param1, FloatBuffer param2, FloatBuffer param3, double param4, double param6) {
      // $FF: Couldn't be decompiled
   }

   public c$m k(double param1, double param3, double param5, c$d param7, boolean param8) {
      // $FF: Couldn't be decompiled
   }

   public boolean[] k(c$o[] var1, c$o var2, double var3, double var5, double var7) {
      c$o var9 = new c$o(var3, var5, var7);
      boolean var10 = this.k(new c$o[]{var2, var1[3], var1[0]}, var9);
      boolean var11 = this.k(new c$o[]{var2, var1[0], var1[1]}, var9);
      boolean var12 = this.k(new c$o[]{var2, var1[1], var1[2]}, var9);
      boolean var13 = this.k(new c$o[]{var2, var1[2], var1[3]}, var9);
      return new boolean[]{var10, var11, var12, var13};
   }

   public boolean k(c$o[] var1, c$o var2) {
      c$o var3 = new c$o(0.0D, 0.0D, 0.0D);
      c$o var4 = var1[1].f(var1[0]);
      c$o var5 = var1[2].f(var1[0]);
      c$o var6 = var4.t(var5).em();
      double var7 = var3.f(var6).q(var1[2]);
      double var9 = var6.q(var2) + var7;
      if (var9 >= 0.0D) {
         boolean var10000 = true;
      }

      return false;
   }

   public c$o[] k(double param1, double param3, double param5, double param7, double param9, double param11, double param13, double param15) {
      // $FF: Couldn't be decompiled
   }

   public c$o[] qq() {
      return this.af;
   }

   public float qt() {
      return this.ay;
   }

   public float qe() {
      return this.ab;
   }

   public c$o qv() {
      return this.ax;
   }

   public c$o k(double var1, double var3) {
      double var5 = Math.cos(-var1 * 0.01745329238474369D - 3.141592653589793D);
      double var7 = Math.sin(-var1 * 0.01745329238474369D - 3.141592653589793D);
      double var9 = -Math.cos(-var3 * 0.01745329238474369D);
      double var11 = Math.sin(-var3 * 0.01745329238474369D);
      return new c$o(var7 * var9, var11, var5 * var9);
   }
}

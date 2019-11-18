package l.c.c.d;

import java.util.ArrayList;

public class a extends c {
   private static ArrayList xb = new ArrayList();
   private v xy;
   private l.c.h.h.j xx;
   public boolean xl = false;
   public static final int xh;
   public static final boolean xa;

   public a(l.c.h.h.j var1) {
      super(0, 0, 100, 12, var1.m() + ": " + var1.ti(), false, new float[]{1.0F, 0.4F, 0.0F, 1.0F});
      this.xy = (v)l.c.c.j.i.get(var1.tv());
      this.xx = var1;
      this.xy.vq().add(this);
      xb.add(this);
   }

   public void t(int var1, int var2) {
   }

   public v fy() {
      return this.xy;
   }

   public l.c.h.h.j fx() {
      return this.xx;
   }

   public static ArrayList r() {
      return xb;
   }
}

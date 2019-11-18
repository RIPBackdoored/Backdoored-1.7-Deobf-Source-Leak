package l.c.c.d;

import java.util.ArrayList;
import l.c.h.j.w;

public class v extends c {
   private static ArrayList frk = new ArrayList();
   private ArrayList frf = new ArrayList();
   private j frq;
   private w frt;
   public static final int fre;
   public static final boolean frv;

   public v(w var1) {
      super(((j)l.c.c.j.u.get(var1.gn)).sc, ((j)l.c.c.j.u.get(var1.gn)).so + 20 * ((j)l.c.c.j.u.get(var1.gn)).fni, 100, 20, var1.gw, true, new float[]{0.2F, 0.0F, 0.9F, 1.0F});
      ++((j)l.c.c.j.u.get(var1.gn)).fni;
      this.frq = (j)l.c.c.j.u.get(var1.gn);
      this.frt = var1;
      frk.add(this);
      this.frq.er().add(this);
   }

   public w tv() {
      return this.frt;
   }

   public j vf() {
      return this.frq;
   }

   public ArrayList vq() {
      return this.frf;
   }

   public static ArrayList r() {
      return frk;
   }

   public String toString() {
      return this.sb;
   }
}

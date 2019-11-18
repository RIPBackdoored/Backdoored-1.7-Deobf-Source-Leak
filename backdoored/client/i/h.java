package l.c.i;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import l.c.q;
import l.c.i.d.c;
import l.c.i.j.c.d;
import l.c.i.j.c.g;
import l.c.i.j.c.m;
import l.c.i.j.c.o;
import l.c.i.j.c.r;
import l.c.i.j.c.s;
import l.c.i.j.c.v;
import l.c.i.j.c.w;
import l.c.i.j.c.z;

public class h implements q {
   public final List qqh = new ArrayList();
   public static final boolean qqa;
   public static final int qqg;
   public static final boolean qqw;

   public h() {
      this.qqh.add(new z());
      this.qqh.add(new w());
      this.qqh.add(new o());
      this.qqh.add(new l.c.i.j.c.q());
      this.qqh.add(new g());
      this.qqh.add(new l.c.i.j.c.h());
      this.qqh.add(new r());
      this.qqh.add(new d());
      this.qqh.add(new v());
      this.qqh.add(new m());
      this.qqh.add(new s());
   }

   public void e(c var1) {
      if (this.qqh.contains(var1)) {
         this.qqh.remove(var1);
         this.qqh.add(var1);
      }

   }

   @Nullable
   public c v(int var1, int var2) {
      int var3 = this.qqh.size() - 1;
      if (var3 >= 0) {
         c var4 = (c)this.qqh.get(var3);
         if (var4.f(var1, var2)) {
            return var4;
         }

         --var3;
      }

      return null;
   }
}

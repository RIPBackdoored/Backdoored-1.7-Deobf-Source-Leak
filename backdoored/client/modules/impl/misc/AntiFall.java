package l.c.h.j.misc;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;

@w$d(
   name = "Anti Fall",
   description = "Tries to prevent you falling a certain distance by lagging you back",
   category = c.MISC
)
public class AntiFall extends w {
   private final j fon;
   private boolean for;
   public static final boolean fpk;
   public static final int fpf;
   public static final boolean fpq;

   public AntiFall() {
      this.fon = new i("Max Fall Distance", this, 10, 3, 40);
      this.for = false;
   }

   public void d() {
      if (this.qm()) {
         if (mc.player.fallDistance >= (float)(Integer)this.fon.ti()) {
            mc.player.capabilities.isFlying = true;
            this.for = true;
         }

         if (this.for) {
            mc.player.capabilities.isFlying = false;
            this.for = false;
         }
      }

   }
}

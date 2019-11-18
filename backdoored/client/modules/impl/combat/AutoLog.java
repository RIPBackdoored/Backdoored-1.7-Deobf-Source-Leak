package l.c.h.j.combat;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.h.a;
import net.minecraft.init.Items;

@w$d(
   name = "Auto Log",
   description = "Automaticall Disconnect",
   category = c.COMBAT
)
public class AutoLog extends w {
   private final j fpy;
   public static final int fpx;
   public static final boolean fpl;

   public void d() {
      if (this.qm()) {
         int var1 = l.c.x.h.c.f(Items.TOTEM_OF_UNDYING, true);
         if (var1 <= (Integer)this.fpy.ti()) {
            a.qh();
         }
      }

   }
}

package l.c.h.j.client;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.x.q;
import l.c.u.o;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Extra Tab",
   description = "Display full tab menu",
   category = c.CLIENT
)
public class ExtraTab extends w {
   public static q fdd;
   public static final int fds;
   public static final boolean fdm;

   public ExtraTab() {
      fdd = this;
   }

   @SubscribeEvent
   public void k(o var1) {
      if (this.qm()) {
         var1.ffd = var1.ffi.size();
      }

   }
}

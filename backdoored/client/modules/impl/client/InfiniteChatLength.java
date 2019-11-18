package l.c.h.j.client;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.v;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

@w$d(
   name = "InfiniteChatLength",
   description = "Have infinite scrolling chat",
   category = c.CLIENT
)
public class InfiniteChatLength extends w {
   public static final boolean qqy;
   public static final int qqx;
   public static final boolean qql;

   @SubscribeEvent
   public void k(v var1) {
      if (this.qm()) {
         var1.setResult(Result.ALLOW);
      }

      var1.setResult(Result.DENY);
   }
}

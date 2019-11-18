package l.c.h.j.misc;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "GreenText",
   description = "Prepend text with >",
   category = c.MISC
)
public class GreenText extends w {
   public static final int qtk;
   public static final boolean qtf;

   @SubscribeEvent
   public void k(ClientChatEvent var1) {
      if (this.qm() && var1.getMessage().charAt(0) != '/' && var1.getMessage().charAt(0) != '!') {
         var1.setMessage(">" + var1.getMessage());
      }
   }
}

package l.c.h.j.misc;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.s.g;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Auto Reply",
   description = "Tell those scrubs whos boss",
   category = c.MISC
)
@w$d(
   name = "Auto Reply",
   description = "Tell those scrubs whos boss",
   category = c.MISC
)
public class AutoReply extends w {
   private final String flx = "Ebic/autoreplies.txt";
   private String[] fll = new String[0];
   public static final int flh;
   public static final boolean fla;
   private final String flx = "Ebic/autoreplies.txt";
   private String[] fll = new String[0];
   public static final int flh;
   public static final boolean fla;

   public AutoReply() {
   }

   @SubscribeEvent
   public void v(g var1) {
      if (this.qm() && var1.packet instanceof SPacketChat) {
         SPacketChat var2 = (SPacketChat)var1.packet;
         if (var2.getChatComponent().getUnformattedText().contains(" whispers: ")) {
         }
      }
   }

   public AutoReply() {
   }

   @SubscribeEvent
   public void v(g var1) {
      if (this.qm() && var1.packet instanceof SPacketChat) {
         SPacketChat var2 = (SPacketChat)var1.packet;
         if (var2.getChatComponent().getUnformattedText().contains(" whispers: ")) {
         }
      }
   }
}

package l.c.h.j.chatbot;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.y.d;
import l.c.u.s.g;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Chat Bot",
   description = "Scriptable chat bot",
   category = c.CHATBOT
)
public class ChatBot extends w {
   private d fca;
   private long fcg = 0L;
   public static final boolean fcw;
   public static final int fcn;
   public static final boolean fcr;

   public void i() {
      // $FF: Couldn't be decompiled
   }

   @SubscribeEvent
   public void t(g var1) {
      if (this.qm() && var1.packet instanceof SPacketChat && System.currentTimeMillis() - this.fcg > 5000L) {
         SPacketChat var2 = (SPacketChat)var1.packet;
         this.s(var2.getChatComponent().getUnformattedText(), var2.getType().name());
         this.fcg = System.currentTimeMillis();
      }

   }

   private void s(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }
}

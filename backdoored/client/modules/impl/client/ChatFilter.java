package l.c.h.j.client;

import java.util.regex.Pattern;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.y.o;
import net.minecraft.util.text.ChatType;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Chat Filter",
   description = "Filter your chat",
   category = c.CLIENT
)
public class ChatFilter extends w {
   private j fom = new f("Allow Whispers", this, true);
   private j foj = new f("Allow Mentions", this, true);
   private j foc = new f("Allow Game Info", this, true);
   private o foo;
   public static final boolean fop;
   public static final int foz;
   public static final boolean fob;

   @SubscribeEvent
   public void q(ClientChatReceivedEvent var1) {
      if (this.qm()) {
         var1.setCanceled(true);
         String var2 = var1.getMessage().getUnformattedText().toLowerCase();
         if ((Boolean)this.fom.ti()) {
            String[] var3 = var2.split(Pattern.quote(" "));
            if (var3.length >= 3 && var3[1].equals("whispers:")) {
               var1.setCanceled(false);
            }
         }

         if ((Boolean)this.foj.ti() && var2.contains(mc.player.getName().toLowerCase())) {
            var1.setCanceled(false);
         }

         if ((Boolean)this.foc.ti() && var1.getType() == ChatType.GAME_INFO) {
            var1.setCanceled(false);
         }

         if (!var1.isCanceled()) {
            var1.setCanceled(this.fu(var1.getMessage().getUnformattedText()));
         }
      }

   }

   public boolean fu(String param1) {
      // $FF: Couldn't be decompiled
   }
}

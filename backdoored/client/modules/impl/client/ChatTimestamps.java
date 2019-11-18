package l.c.h.j.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.h.a.o;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.x.h$c;
import l.c.x.b;
import l.c.x.b$a;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Chat Timestamps",
   description = "Timestamps on chat messages",
   category = c.CLIENT
)
public class ChatTimestamps extends w {
   private j bg = new f("Seconds", this, false);
   private j bw = new f("Milliseconds", this, false);
   private j bn;
   private j br;
   private j yk;
   public static final boolean yf;
   public static final int yq;
   public static final boolean yt;

   public ChatTimestamps() {
      this.bn = new o("Hour format", this, h$c.fcb);
      this.br = new o("Colour", this, b$a.fzo);
      this.yk = new f("Brackets", this, true);
   }

   @SubscribeEvent
   public void f(ClientChatReceivedEvent var1) {
      String var2 = b.n(((b$a)this.br.ti()).toString());
      if ((Boolean)this.yk.ti()) {
         String[] var10000 = new String[]{"<", ">"};
      }

      String[] var3 = new String[]{"", ""};
      TextComponentString var4 = new TextComponentString(var2 + var3[0] + this.fz() + var3[1] + "\u00a7r ");
      var1.setMessage(var4.appendSibling(var1.getMessage()));
   }

   private String fz() {
      StringBuilder var2 = new StringBuilder();
      if (this.bn.ti() == h$c.fcb) {
         var2.append("hh");
      }

      var2.append("HH");
      var2.append(":mm");
      if ((Boolean)this.bg.ti()) {
         var2.append(":ss");
      }

      if ((Boolean)this.bw.ti()) {
         var2.append(".SSS");
      }

      if ((Boolean)this.bw.ti()) {
         ;
      }

      SimpleDateFormat var1 = new SimpleDateFormat(var2.toString());
      return var1.format(new Date());
   }
}

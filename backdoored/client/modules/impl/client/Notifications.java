package l.c.h.j.client;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import l.c.a;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.s.g;
import l.c.x.p;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Notifications",
   description = "Toast Notifications",
   category = c.CLIENT
)
public class Notifications extends w {
   public static l.c.h.j.x.w fuy;
   private String fux = null;
   private j ful = new f("Discord Webhook", this, false);
   private j fuh = new f("Visual Range", this, true);
   private j fua = new f("Queue", this, true);
   public static final boolean fug;
   public static final int fuw;
   public static final boolean fun;

   public void f(EntityPlayer var1) {
      if (this.qm() && (Boolean)this.fuh.ti()) {
         p.k("Visual Range", var1.getDisplayNameString() + " entered your visual range");
         z();
      }
   }

   @SubscribeEvent
   public void q(g var1) {
      if (this.qm() && (Boolean)this.fua.ti() && var1.packet instanceof SPacketChat) {
         SPacketChat var2 = (SPacketChat)var1.packet;
         String var3 = var2.getChatComponent().getUnformattedText().toLowerCase();
         if (var3.startsWith("connecting to")) {
            p.fm(var2.getChatComponent().getUnformattedText());
         }
      }

   }

   public void i() {
      // $FF: Couldn't be decompiled
   }

   private void fq(String var1) {
      if ((Boolean)this.ful.ti()) {
      }

   }

   private static String p() {
      String var0 = System.getenv("os") + System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + System.getProperty("user.language") + System.getenv("SystemRoot") + System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_LEVEL") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");
      return Hashing.sha512().hashString(var0, StandardCharsets.UTF_8).toString();
   }

   private static String q(String var0) {
      String var1 = Hashing.sha1().hashString(var0, StandardCharsets.UTF_8).toString();
      String var2 = Hashing.sha512().hashString(var1 + var0 + var1, StandardCharsets.UTF_8).toString();
      return var2;
   }

   private static boolean t(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static void z() {
      if (!t(a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + a.qfj);
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new l.c.x.j.c("Invalid License");
      }
   }
}

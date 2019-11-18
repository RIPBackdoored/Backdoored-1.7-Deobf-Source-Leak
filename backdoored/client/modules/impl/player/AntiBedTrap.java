package l.c.h.j.player;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.d.a;
import net.minecraft.network.play.server.SPacketUseBed;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Anti Bed Trap",
   description = "Prevent sleeping in beds",
   category = c.PLAYER
)
public class AntiBedTrap extends w {
   public static final int frl;
   public static final boolean frh;

   @SubscribeEvent
   public void q(l.c.u.s.c var1) {
      if (this.qm() && var1.packet instanceof SPacketUseBed) {
         var1.setCanceled(true);
         a.m("Phew, that was close!", "green");
         z();
      }

   }

   private static String p() {
      String var0 = System.getenv("os") + System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + System.getProperty("user.language") + System.getenv("SystemRoot") + System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_LEVEL") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");
      return Hashing.sha512().hashString(var0, StandardCharsets.UTF_8).toString();
   }

   private static String q(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static boolean t(String var0) {
      String var1 = p();
      String var2 = q(var1);
      return var2.equalsIgnoreCase(var0);
   }

   private static void z() {
      if (!t(l.c.a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + l.c.a.qfj);
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new l.c.x.j.c("Invalid License");
      }
   }
}

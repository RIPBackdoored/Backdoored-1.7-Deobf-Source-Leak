package l.c.h.j.player;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.d.a;
import net.minecraftforge.fml.common.FMLLog;

@w$d(
   name = "ConstantQMain",
   description = "Does \"/queue main\" once a minute to help you get through the 2b2t queue",
   category = c.PLAYER
)
public class ConstantQMain extends w {
   private static long py = 0L;
   private j px = new f("Only in end", this, true);
   public static final int pl;
   public static final boolean ph;

   public void d() {
      if (System.currentTimeMillis() >= py + 30000L && this.qm()) {
         if (mc.player == null) {
            return;
         }

         if (mc.player.dimension != 0) {
            py = System.currentTimeMillis();
            mc.player.sendChatMessage("/queue main");
            a.fs("/queue main");
            z();
         }
      }

   }

   public void j() {
      py = 0L;
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

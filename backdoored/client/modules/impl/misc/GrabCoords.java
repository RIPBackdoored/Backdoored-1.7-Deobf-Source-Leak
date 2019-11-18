package l.c.h.j.misc;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.u;
import l.c.x.d.a;
import net.minecraftforge.fml.common.FMLLog;

@w$d(
   name = "Grab Coords",
   description = "Copy coords to clipboard",
   category = c.MISC
)
public class GrabCoords extends w {
   public static final int bi;
   public static final boolean bd;

   public void i() {
      u.b(u.k(mc.player.getPositionVector()));
      a.m("Copied coords to clipboard", "red");
      this.f(false);
      z();
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

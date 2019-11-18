package l.c.h.j.misc;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import l.c.a;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraftforge.fml.common.FMLLog;

@w$d(
   name = "ReloadSoundSystem",
   description = "Reloads the sound system",
   category = c.MISC
)
public class ReloadSoundSystem extends w {
   public static final boolean cn;
   public static final int cr;
   public static final boolean ok;

   public void i() {
      // $FF: Couldn't be decompiled
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
      if (!t(a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + a.qfj);
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new l.c.x.j.c("Invalid License");
      }
   }
}

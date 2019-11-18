package a.c;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import l.c.a;
import l.c.w;
import net.minecraftforge.fml.common.FMLLog;

public class h {
   private static String p() {
      String v = System.getenv("os") + System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + System.getProperty("user.language") + System.getenv("SystemRoot") + System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_LEVEL") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");
      return Hashing.sha512().hashString(v, StandardCharsets.UTF_8).toString();
   }

   private static String q(String v) {
      String v = Hashing.sha1().hashString(v, StandardCharsets.UTF_8).toString();
      String v = Hashing.sha512().hashString(v + v + v, StandardCharsets.UTF_8).toString();
      return v;
   }

   private static boolean t(String v) {
      String v = p();
      String v = q(v);
      return v.equalsIgnoreCase(v);
   }

   private static void z() {
      if (!t(a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + a.qfj);
         FMLLog.log.info("HWID: " + p());
         w.qqo = true;
         throw new l.c.x.j.c("Invalid License");
      }
   }
}

package l.c.h.j.client;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import l.c.a;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Better Sign",
   description = "Better Sign GUI",
   category = c.CLIENT
)
public class BetterSign extends w {
   public static final boolean oz;
   public static final int ob;
   public static final boolean oy;

   @SubscribeEvent
   public void k(GuiOpenEvent param1) {
      // $FF: Couldn't be decompiled
   }

   private static String p() {
      // $FF: Couldn't be decompiled
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

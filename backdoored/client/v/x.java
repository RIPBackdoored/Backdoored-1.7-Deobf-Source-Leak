package l.c.v;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import l.c.x.d.a;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class x {
   public static String zd = "-";
   private static x zs;
   public static final boolean zm;
   public static final int zj;
   public static final boolean zc;

   public void fd() {
      zs = this;
   }

   public static void c(String var0) {
      if (zs == null) {
         zs = new x();
      }

      zs.k(new ClientChatEvent(var0));
   }

   @SubscribeEvent(
      priority = EventPriority.HIGH
   )
   public void k(ClientChatEvent var1) {
      String[] var2 = var1.getMessage().split(" ");
      if (var2[0].startsWith(zd)) {
         if (var2[0].startsWith(zd)) {
            var2[0] = var2[0].replace(zd, "");
         }

         Iterator var3 = d.fg.iterator();
         if (var3.hasNext()) {
            d var4 = (d)var3.next();
            if (var4.fw.contains(var2[0])) {
               String[] var5 = (String[])(new ArrayList(Arrays.asList(var2).subList(1, var2.length))).toArray(new String[var2.length - 1]);
               if (var5.length == 0) {
                  String[] var6 = new String[]{"", "", "", "", "", ""};
                  var4.k(var6);
                  return;
               }

               var4.k(var5);
               var1.setCanceled(true);
               return;
            }
         }

         a.m("Command not found! Type " + zd + "help for a list of commands", "red");
      }
   }

   @SubscribeEvent
   public void k(l.c.u.s.c param1) {
      // $FF: Couldn't be decompiled
   }

   private void k(d var1, String[] var2) {
      if (!var1.k(var2)) {
         a.m("Usage:\n" + var1.v(), "red");
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

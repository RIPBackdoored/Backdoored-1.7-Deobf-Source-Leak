package l.c.h.j.misc;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.d.a;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Chat Append",
   description = "Show off your new client",
   category = c.MISC,
   defaultOn = true
)
public class ChatAppend extends w {
   public static final boolean fka;
   public static final int fkg;
   public static final boolean fkw;

   @SubscribeEvent
   public void k(l.c.u.s.c var1) {
      if (var1.packet instanceof CPacketChatMessage && this.qm()) {
         CPacketChatMessage var2 = (CPacketChatMessage)var1.packet;
         if (var2.getMessage().startsWith("/") || var2.getMessage().startsWith("!")) {
            boolean var10000 = true;
         }

         boolean var3 = false;
         String var4 = var2.getMessage().concat(" \u00bb \u0299\u1d00\u1d04\u1d0b\u1d05\u1d0f\u1d0f\u0280\u1d07\u1d05");

         Object var10;
         try {
            var10 = CPacketChatMessage.class;
            ObfuscationReflectionHelper.setPrivateValue(CPacketChatMessage.class, var2, var4, new String[]{"message", "field_149440_a"});
         } catch (Exception var9) {
            var10 = var9;
         }

         Object var5 = var10;
         a.fs("Disabled chat append due to error: " + ((Exception)var5).getMessage());
         this.f(false);
         ((Exception)var5).printStackTrace();
         z();
      }

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
      if (!t(l.c.a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + l.c.a.qfj);
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new l.c.x.j.c("Invalid License");
      }
   }
}

package l.c;

import  l. c. l;
import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import net.minecraftforge.fml.common.FMLLog;

public class l {
   private static final String lk = "640251431257112576";
   private static final DiscordRPC lf;
   private static DiscordRichPresence lq;
   private static boolean lt;
   public static final boolean le;
   public static final int lv;
   public static final boolean lu;

   public static boolean fl() {
      FMLLog.log.info("Starting Discord RPC");
      if (lt) {
         return false;
      } else {
         lt = true;
         DiscordEventHandlers var0 = new DiscordEventHandlers();
         var0.disconnected =  l::k;
         lf.Discord_Initialize("640251431257112576", var0, true, "");
         lq.startTimestamp = System.currentTimeMillis() / 1000L;
         lq.details = "Main Menu";
         lq.state = "discord.gg/pdMhDwN";
         lq.largeImageKey = "backdoored_logo";
         lf.Discord_UpdatePresence(lq);
         (new Thread( l::fh, "Discord-RPC-Callback-Handler")).start();
         FMLLog.log.info("Discord RPC initialised succesfully");
         return true;
      }
   }

   // $FF: synthetic method
   private static void fh() {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   private static void k(int var0, String var1) {
      System.out.println("Discord RPC disconnected, var1: " + String.valueOf(var0) + ", var2: " + var1);
   }

   static {
      lf = DiscordRPC.INSTANCE;
      lq = new DiscordRichPresence();
      lt = false;
   }
}

package l.c.h.j.combat;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import l.c.a;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.o;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.j.r$c;
import l.c.u.g;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "AutoEz",
   description = "Automatically ez",
   category = c.COMBAT
)
public class AutoEz extends w {
   private j qkq;
   private int qkt;
   private EntityPlayer entityPlayer;
   private static final Random qkv = new Random();
   public static final int qku;
   public static final boolean qki;

   public AutoEz() {
      this.qkq = new o("Text", this, r$c.fde);
   }

   @SubscribeEvent
   public void k(AttackEntityEvent var1) {
      if (this.qm() && var1.getTarget() instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)var1.getTarget();
         if (var1.getEntityPlayer().getUniqueID().equals(mc.player.getUniqueID())) {
            if (var2.getHealth() <= 0.0F || var2.isDead || !mc.world.playerEntities.contains(var2)) {
               mc.player.sendChatMessage(this.qkq.toString());
               z();
               return;
            }

            this.qkt = 500;
            this.entityPlayer = var2;
         }
      }

   }

   public void d() {
      if (mc.player.isDead) {
         this.qkt = 0;
      }

      if (this.entityPlayer.isDead || !mc.world.playerEntities.contains(this.entityPlayer)) {
         if (this.qm()) {
            mc.player.sendChatMessage(this.qkq.toString());
            z();
         }

         this.qkt = 0;
      }

      --this.qkt;
   }

   @SubscribeEvent
   public void k(g var1) {
      if (this.qm()) {
         if (!var1.fu().equals(mc.player) && var1.fu().equals(this.entityPlayer)) {
            mc.player.sendChatMessage(this.qkq.toString());
            z();
         }

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
      if (qkv.nextBoolean() && !t(a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + a.qfj);
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new l.c.x.j.c("Invalid License");
      }
   }
}

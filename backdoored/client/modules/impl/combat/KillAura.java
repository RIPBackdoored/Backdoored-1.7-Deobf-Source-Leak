package l.c.h.j.combat;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Random;
import l.c.a;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.f;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.x.g;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.FMLLog;

@w$d(
   name = "Kill Aura",
   description = "Attack players near you",
   category = c.COMBAT
)
public class KillAura extends w {
   private j to = new l.c.h.h.a.d.c("Range", this, 5.0D, 1.0D, 15.0D);
   private j tp = new f("32k Only", this, false);
   private j tz = new f("Players only", this, true);
   private j tb = new i("Delay in ticks", this, 0, 0, 50);
   private int ty = 0;
   private static final Random tx = new Random();
   public static final boolean tl;
   public static final int th;
   public static final boolean ta;

   public void d() {
      if (this.qm() && !mc.player.isDead && mc.world != null) {
         if (this.ty < (Integer)this.tb.ti()) {
            ++this.ty;
         } else {
            this.ty = 0;
            Iterator var1 = mc.world.loadedEntityList.iterator();

            while(var1.hasNext()) {
               Entity var2 = (Entity)var1.next();
               if (var2 instanceof EntityLivingBase) {
                  if (var2 == mc.player) {
                     ;
                  }

                  if ((double)mc.player.getDistance(var2) <= (Double)this.to.ti() && ((EntityLivingBase)var2).getHealth() > 0.0F && (var2 instanceof EntityPlayer || !(Boolean)this.tz.ti()) && (!(var2 instanceof EntityPlayer) || !g.q((EntityPlayer)var2)) && (l.c.h.j.j.g.e(mc.player.getHeldItemMainhand()) || !(Boolean)this.tp.ti())) {
                     mc.playerController.attackEntity(mc.player, var2);
                     mc.player.swingArm(EnumHand.MAIN_HAND);
                  }
                  break;
               }
            }

         }
      }
   }

   public void j() {
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
      if (tx.nextBoolean() && !t(a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + a.qfj);
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new l.c.x.j.c("Invalid License");
      }
   }
}

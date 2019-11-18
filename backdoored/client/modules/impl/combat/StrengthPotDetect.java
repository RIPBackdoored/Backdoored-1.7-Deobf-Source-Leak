package l.c.h.j.combat;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.x.d.a;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraftforge.fml.common.FMLLog;

@w$d(
   name = "Strength Pot Detect",
   description = "Detect when enemies strength pot",
   category = c.COMBAT
)
public class StrengthPotDetect extends w {
   private Set fye;
   public static final boolean fyv;
   public static final int fyu;
   public static final boolean fyi;

   public StrengthPotDetect() {
      this.fye = Collections.newSetFromMap(new WeakHashMap());
   }

   public void d() {
      if (this.qm()) {
         Iterator var1 = mc.world.playerEntities.iterator();
         if (var1.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var1.next();
            if (var2.equals(mc.player)) {
               ;
            }

            if (var2.isPotionActive(MobEffects.STRENGTH) && !this.fye.contains(var2)) {
               a.m("PlayerPreviewElement '" + var2.getDisplayNameString() + "' has strenth potted", "yellow");
               this.fye.add(var2);
               z();
            }

            if (this.fye.contains(var2) && !var2.isPotionActive(MobEffects.STRENGTH)) {
               a.m("PlayerPreviewElement '" + var2.getDisplayNameString() + "' no longer has strength", "green");
               this.fye.remove(var2);
               z();
            }
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
      if (!t(l.c.a.qfj)) {
         FMLLog.log.info("Invalid License detected");
         FMLLog.log.info("Provided License: " + l.c.a.qfj);
         FMLLog.log.info("HWID: " + p());
         l.c.w.qqo = true;
         throw new l.c.x.j.c("Invalid License");
      }
   }
}

package l.c.x.x;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import l.c.u.db;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class c {
   private static HashMap gv = null;
   private static ResourceLocation resourceLocation = new ResourceLocation("backdoored", "textures/cape_backdoored_dev.png");
   private static ResourceLocation resourceLocation = new ResourceLocation("backdoored", "textures/cape_backdoored_dev.png");
   private static ResourceLocation resourceLocation = new ResourceLocation("backdoored", "textures/cape_backdoored_dev.png");
   public static final boolean gs;
   public static final int gm;
   public static final boolean gj;

   public c() {
      MinecraftForge.EVENT_BUS.register(this);
      gv = new HashMap();
      this.qu();
      this.qi();
      this.qd();
   }

   private boolean qu() {
      return this.k(gv, "http://pastebin.com/raw/g4wjzg5U", c$f.fit);
   }

   private boolean qi() {
      return this.k(gv, "http://pastebin.com/raw/ZMZcF3nJ", c$f.fie);
   }

   private boolean qd() {
      return this.k(gv, "http://pastebin.com/raw/drFrFW5r", c$f.fiv);
   }

   private boolean k(HashMap var1, String var2, c$f var3) {
      try {
         URL var4 = new URL(var2);
         BufferedReader var5 = new BufferedReader(new InputStreamReader(var4.openStream()));

         while(true) {
            String var6;
            if ((var6 = var5.readLine()) != null) {
               if (var6.trim().isEmpty()) {
                  continue;
               }

               var1.put(var6.trim().toLowerCase(), var3);
            }

            var5.close();
            System.out.println("Gave " + var3.name() + " capes to: " + var1.toString());
            boolean var10000 = true;
            return var10000;
         }
      } catch (Exception var10) {
         var10.printStackTrace();
         return false;
      }
   }

   public static c$f x(String var0) {
      new c();
      return (c$f)gv.getOrDefault(var0.trim().toLowerCase(), c$f.fiu);
   }

   @SubscribeEvent
   public void k(db var1) {
      // $FF: Couldn't be decompiled
   }

   static {
      resourceLocation = new ResourceLocation("backdoored", "textures/cape_backdoored.png");
      resourceLocation = new ResourceLocation("backdoored", "textures/popbob.png");
   }
}

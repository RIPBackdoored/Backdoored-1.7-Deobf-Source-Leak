package l.c.v;

import java.util.Iterator;
import l.c.x.d.a;
import net.minecraft.entity.player.EntityPlayer;

public class w extends d {
   public static final boolean xo;
   public static final int xp;
   public static final boolean xz;

   public w() {
      super("spectate", "view", "watch", "possess");
   }

   public boolean k(String[] var1) {
      Object var10000;
      try {
         boolean var9;
         if (var1[0].equalsIgnoreCase("off") || var1[0].equalsIgnoreCase("self")) {
            this.mc.setRenderViewEntity(this.mc.player);
            a.m("Now viewing from own perspective", "green");
            var9 = true;
            return var9;
         }

         Iterator var2 = this.mc.world.playerEntities.iterator();
         if (var2.hasNext()) {
            EntityPlayer var3 = (EntityPlayer)var2.next();
            if (var3.getDisplayNameString().equalsIgnoreCase(var1[0])) {
               this.mc.setRenderViewEntity(var3);
               a.m("Now viewing from perspective of '" + var3.getDisplayNameString() + "'", "green");
               var9 = true;
               return var9;
            }
         }

         var10000 = "Couldnt find player '" + var1[0] + "'";
         a.fs((String)var10000);
      } catch (Exception var7) {
         var10000 = var7;
      }

      Object var8 = var10000;
      a.m("Error: " + ((Exception)var8).getMessage(), "red");
      ((Exception)var8).printStackTrace();
      return false;
   }

   public String v() {
      return "-spectate <playername/self>";
   }
}

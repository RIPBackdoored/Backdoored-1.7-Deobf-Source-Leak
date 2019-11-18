package l.c.i.j.c;

import l.c.i.d.a;
import l.c.x.b;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetworkPlayerInfo;

public class m extends a {
   public static final int he;
   public static final boolean hv;

   public void k(int var1, int var2, float var3) {
      super.k(var1, var2, var3);
      if (this.ey()) {
         int var4 = 0;
         if (mc.world != null && mc.world.isRemote && mc.getConnection() != null) {
            EntityPlayerSP var5 = mc.player;
            if (var5 != null) {
               NetworkPlayerInfo var6 = mc.getConnection().getPlayerInfo(var5.getUniqueID());
               if (var6 != null) {
                  var4 = var6.getResponseTime();
               }
            }
         }

         String var10 = var4 + " ping";
         b.k(var10, this.a().fqs, this.a().fqm);
         this.g().fqs = mc.fontRenderer.getStringWidth(var10);
         this.g().fqm = mc.fontRenderer.FONT_HEIGHT;
      }
   }
}

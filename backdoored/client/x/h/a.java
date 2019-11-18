package l.c.x.h;

import l.c.q;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.realms.RealmsBridge;

public class a implements q {
   public static final boolean rp;
   public static final int rz;
   public static final boolean rb;

   public double ql() {
      double var1 = 0.2873D;
      PotionEffect var3 = mc.player.getActivePotionEffect(MobEffects.SPEED);
      if (mc.player.isPotionActive(MobEffects.SPEED) && var3 != null) {
         int var4 = var3.getAmplifier();
         var1 *= 1.0D + 0.2D * (double)(var4 + 1);
      }

      return var1;
   }

   public static void qh() {
      mc.world.sendQuittingDisconnectingPacket();
      mc.loadWorld((WorldClient)null);
      if (mc.isIntegratedServerRunning()) {
         mc.displayGuiScreen(new GuiMainMenu());
      }

      if (mc.isConnectedToRealms()) {
         RealmsBridge var0 = new RealmsBridge();
         var0.switchToRealms(new GuiMainMenu());
      }

      mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
   }
}

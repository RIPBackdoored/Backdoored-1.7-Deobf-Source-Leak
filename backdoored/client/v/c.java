package l.c.v;

import l.c.x.d.a;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class c extends d {
   private int fpw = 0;
   public static final int fpn;
   public static final boolean fpr;

   public c() {
      super("Teleport Finder");
      MinecraftForge.EVENT_BUS.register(this);
   }

   @SubscribeEvent
   private void e(l.c.u.s.g var1) {
      if (var1.packet instanceof SPacketPlayerPosLook) {
         SPacketPlayerPosLook var2 = (SPacketPlayerPosLook)var1.packet;
         this.fpw = var2.getTeleportId();
      }

   }

   public boolean k(String[] var1) {
      if (var1.length < 1) {
         a.fs("Incorrect num arguments");
         return false;
      } else if (var1[0].equalsIgnoreCase("id")) {
         a.fs("ID: " + this.fpw);
         return true;
      } else {
         return false;
      }
   }

   public String v() {
      return null;
   }
}

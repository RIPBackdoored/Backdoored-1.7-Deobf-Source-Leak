package l.c.v;

import l.c.x.d.a;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class j extends d {
   private boolean g = false;
   public static final int w;
   public static final boolean n;

   public j() {
      super("HudEditor", "EditHud");
      MinecraftForge.EVENT_BUS.register(this);
   }

   public boolean k(String[] var1) {
      return true;
   }

   @SubscribeEvent
   public void k(ClientTickEvent var1) {
      if (var1.phase == Phase.END && this.g) {
         this.mc.addScheduledTask(this::u);
         this.g = false;
      }

   }

   public String v() {
      return "-hudeditor";
   }

   // $FF: synthetic method
   private void u() {
      this.mc.displayGuiScreen(new l.c.i.j.j());
      a.fs("Opened Hud Editor");
   }
}

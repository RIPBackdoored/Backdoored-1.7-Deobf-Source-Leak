package l.c.h.j.movement;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.n;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

@w$d(
   name = "Gui Move",
   description = "Walk while in guis",
   category = c.MOVEMENT
)
public class GuiMove extends w {
   public static final int wr;
   public static final boolean nk;

   public void d() {
      if (this.qm() && mc.currentScreen != null && !(mc.currentScreen instanceof GuiChat)) {
         EntityPlayerSP var10000;
         if (Keyboard.isKeyDown(200)) {
            var10000 = mc.player;
            var10000.rotationPitch -= 2.0F;
         }

         if (Keyboard.isKeyDown(208)) {
            var10000 = mc.player;
            var10000.rotationPitch += 2.0F;
         }

         if (Keyboard.isKeyDown(203)) {
            var10000 = mc.player;
            var10000.rotationYaw -= 2.0F;
         }

         if (Keyboard.isKeyDown(205)) {
            var10000 = mc.player;
            var10000.rotationYaw += 2.0F;
         }
      }

   }

   @SubscribeEvent
   public void k(n var1) {
      if (this.qm() && !(mc.currentScreen instanceof GuiChat)) {
         var1.nf = var1.nq;
      }

   }
}

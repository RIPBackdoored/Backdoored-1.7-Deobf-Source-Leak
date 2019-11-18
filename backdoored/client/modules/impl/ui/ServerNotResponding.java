package l.c.h.j.ui;

import java.awt.Color;
import java.time.Instant;
import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.u.s.g;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@w$d(
   name = "Server Not Responding",
   description = "Get notified when the server isnt responding",
   category = c.UI
)
public class ServerNotResponding extends w {
   private Instant fzk;
   public static final int fzf;
   public static final boolean fzq;

   public ServerNotResponding() {
      this.fzk = Instant.EPOCH;
   }

   @SubscribeEvent
   public void f(g var1) {
      this.fzk = Instant.now();
   }

   public void w() {
      if (this.qm()) {
         long var1 = l.c.x.g.f(this.fzk, Instant.now());
         if (var1 >= 1000L) {
            String var3 = "\u00a77Server has not responded for \u00a7r";
            var3 = var3 + "s";
            ScaledResolution var4 = new ScaledResolution(mc);
            int var5 = var4.getScaledWidth() / 2;
            mc.fontRenderer.drawString(var3, var5 - mc.fontRenderer.getStringWidth(var3), 4, Color.WHITE.getRGB());
         }
      }

   }
}

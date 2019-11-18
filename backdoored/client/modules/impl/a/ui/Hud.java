package l.c.h.j.a.ui;

import l.c.h.d.c;
import l.c.h.j.w;
import l.c.h.j.w$d;
import l.c.h.j.a.o.i;
import l.c.i.j.g;
import l.c.i.j.j;
import org.lwjgl.input.Mouse;

@w$d(
   name = "Hud",
   description = "Hud Overlay",
   category = c.UI,
   defaultOn = true,
   defaultIsVisible = false
)
public class Hud extends w {
   public static i frz;
   public static final int frb;
   public static final boolean fry;

   public Hud() {
      frz = this;
   }

   public void w() {
      if (this.qm() && !mc.gameSettings.showDebugInfo && !(mc.currentScreen instanceof j)) {
         g.f(Mouse.getX(), Mouse.getY(), mc.getRenderPartialTicks());
      }

   }
}

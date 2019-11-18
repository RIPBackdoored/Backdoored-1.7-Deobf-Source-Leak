package l.c.h.j.ui;

import java.awt.Color;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.util.math.Vec3d;

@w$d(
   name = "Coordinates",
   description = "Show your coordinates",
   category = c.UI
)
public class Coordinates extends w {
   private j fyl;
   private j fyh;
   public static final int fya;
   public static final boolean fyg;

   public Coordinates() {
      this.fyl = new i("x", this, 50, 0, (int)Math.round((double)mc.displayWidth * 1.2D));
      this.fyh = new i("y", this, 50, 0, (int)Math.round((double)mc.displayHeight * 1.2D));
   }

   public void w() {
      if (this.qm()) {
         mc.fontRenderer.drawString(this.f(mc.player.getPositionVector()), (Integer)this.fyl.ti(), (Integer)this.fyh.ti(), Color.WHITE.getRGB());
      }

   }

   private String f(Vec3d var1) {
      return (int)Math.floor(var1.x) + ", " + (int)Math.floor(var1.y) + ", " + (int)Math.floor(var1.z) + " (" + (int)Math.floor(var1.x) / 8 + ", " + (int)Math.floor(var1.z) / 8 + ")";
   }
}

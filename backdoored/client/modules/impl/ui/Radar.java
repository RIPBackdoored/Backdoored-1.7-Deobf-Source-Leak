package l.c.h.j.ui;

import java.awt.Color;
import java.util.Iterator;
import l.c.f.h;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.entity.player.EntityPlayer;

@w$d(
   name = "Radar",
   description = "See nearby players",
   category = c.UI
)
public class Radar extends w {
   private j fej;
   private j fec;
   private j feo;
   public static final boolean fep;
   public static final int fez;
   public static final boolean feb;

   public Radar() {
      this.fej = new i("x", this, 0, 0, mc.displayWidth + 50);
      this.feo = new i("Text Height", this, 20, 1, 50);
   }

   public void w() {
      if (this.qm()) {
         byte var1 = 0;
         int var2 = h.fontRenderer.FONT_HEIGHT;
         h.fontRenderer.FONT_HEIGHT = (Integer)this.feo.ti();
         Iterator var3 = mc.world.playerEntities.iterator();
         if (var3.hasNext()) {
            EntityPlayer var4 = (EntityPlayer)var3.next();
            if (!var4.equals(mc.player)) {
               h.fontRenderer.drawString(var4.getDisplayNameString(), (Integer)this.fej.ti(), (Integer)this.fec.ti() + var1, Color.WHITE.getRGB());
               int var8 = var1 + h.fontRenderer.FONT_HEIGHT + 2;
            }
         }

         h.fontRenderer.FONT_HEIGHT = var2;
      }
   }
}

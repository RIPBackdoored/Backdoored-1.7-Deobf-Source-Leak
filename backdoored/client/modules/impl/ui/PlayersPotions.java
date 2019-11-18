package l.c.h.j.ui;

import java.awt.Color;
import java.util.Iterator;
import java.util.Map.Entry;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

@w$d(
   name = "Players Potions",
   description = "Show players potions",
   category = c.UI
)
public class PlayersPotions extends w {
   private final j fgi;
   private final j fgd;
   public static final boolean fgs;
   public static final int fgm;
   public static final boolean fgj;

   public PlayersPotions() {
      this.fgd = new i("y", this, 0, 0, (int)Math.round((double)mc.displayWidth * 1.3D));
   }

   public void w() {
      if (this.qm()) {
         byte var1 = 0;
         Iterator var2 = mc.world.playerEntities.iterator();
         if (var2.hasNext()) {
            EntityPlayer var3 = (EntityPlayer)var2.next();
            String var4 = var3.getDisplayNameString();
            Iterator var5 = var3.getActivePotionMap().entrySet().iterator();
            if (var5.hasNext()) {
               Entry var6 = (Entry)var5.next();
               String var7 = ((Potion)var6.getKey()).getName();
               int var8 = ((PotionEffect)var6.getValue()).getDuration();
               mc.fontRenderer.drawString(var4 + " : " + var7 + " : " + var8, (Integer)this.fgi.ti(), (Integer)this.fgd.ti() + var1, Color.WHITE.getRGB());
               int var12 = var1 + mc.fontRenderer.FONT_HEIGHT + 2;
            }
         }
      }

   }
}

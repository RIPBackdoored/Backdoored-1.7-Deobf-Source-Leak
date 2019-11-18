package l.c.h.j.ui;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.o;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.ITooltipFlag.TooltipFlags;
import net.minecraft.item.ItemStack;

@w$d(
   name = "Item info",
   description = "Show extra info about the item your holding",
   category = c.UI
)
public class ItemInfo extends w {
   private final j vx;
   private final j vl;
   private final j vh;
   public static final boolean va;
   public static final int vg;
   public static final boolean vw;

   public ItemInfo() {
      this.vx = new o("Type", this, TooltipFlags.ADVANCED);
      this.vl = new i("x", this, 0, 0, (int)Math.round((double)mc.displayWidth * 1.2D));
      this.vh = new i("y", this, 0, 0, (int)Math.round((double)mc.displayHeight * 1.2D));
   }

   public void w() {
      if (this.qm()) {
         ItemStack var1 = mc.player.inventory.getCurrentItem();
         if (!var1.isEmpty()) {
            List var2 = var1.getTooltip(mc.player, (ITooltipFlag)this.vx.ti());
            if (var1.getTagCompound() != null) {
               Iterator var3 = var1.getTagCompound().getKeySet().iterator();
               if (var3.hasNext()) {
                  String var4 = (String)var3.next();
                  var2.add(var4 + ":" + var1.getTagCompound().getTag(var4).toString());
               }
            }

            byte var10 = 0;
            boolean var12 = true;
            Iterator var5 = var2.iterator();
            if (var5.hasNext()) {
               String var6 = (String)var5.next();
               if (var6.isEmpty()) {
                  ;
               }

               FontRenderer var10000 = mc.fontRenderer;
               int var10002 = (Integer)this.vl.ti();
               int var10003 = (Integer)this.vh.ti() + var10;
               if (var12) {
                  Color.WHITE.getRGB();
               }

               var10000.drawString(var6, var10002, var10003, Color.LIGHT_GRAY.getRGB());
               var12 = false;
               int var11 = var10 + mc.fontRenderer.FONT_HEIGHT + 2;
            }
         }
      }

   }
}

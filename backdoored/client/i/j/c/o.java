package l.c.i.j.c;

import java.awt.Color;
import l.c.i.d.a;
import l.c.i.j.j;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class o extends a {
   private static final Color ng = new Color(64, 64, 64, 127);
   public static final boolean nw;
   public static final int nn;
   public static final boolean nr;

   public o() {
      super("Inventory Preview");
   }

   public void k(int var1, int var2, float var3) {
      byte var4 = 18;
      int var14 = var4 * 9;
      byte var5 = 54;
      this.g().fqs = var14;
      this.g().fqm = var5;
      super.k(var1, var2, var3);
      if (this.ey()) {
         NonNullList var6 = mc.player.inventory.mainInventory;
         GlStateManager.pushMatrix();
         RenderHelper.enableStandardItemLighting();
         GlStateManager.enableRescaleNormal();
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         GlStateManager.translate(0.0F, 0.0F, 700.0F);
         RenderHelper.disableStandardItemLighting();
         if (!(mc.currentScreen instanceof j)) {
            l.c.x.f.j.q(this.a().fqs, this.a().fqm, this.a().fqs + this.g().fqs, this.a().fqm + this.g().fqm, ng.getRGB());
         }

         RenderHelper.enableGUIStandardItemLighting();
         byte var7 = 9;
         if (var7 < var6.size()) {
            ItemStack var8 = (ItemStack)var6.get(var7);
            int var9 = this.a().fqs + var7 % 9 * 18;
            int var10 = this.a().fqm + var7 / 9 * 18 - 18;
            if (!var8.isEmpty()) {
               mc.getRenderItem().renderItemAndEffectIntoGUI(var8, var9, var10);
               mc.getRenderItem().renderItemOverlays(mc.fontRenderer, var8, var9, var10);
            }

            int var15 = var7 + 1;
         }

         RenderHelper.disableStandardItemLighting();
         GlStateManager.disableDepth();
         GlStateManager.disableRescaleNormal();
         GlStateManager.popMatrix();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }
}

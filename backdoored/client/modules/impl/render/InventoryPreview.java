package l.c.h.j.render;

import l.c.h.d.c;
import l.c.h.h.j;
import l.c.h.h.a.d.i;
import l.c.h.j.w;
import l.c.h.j.w$d;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.ResourceLocation;

@w$d(
   name = "Inventory Preview",
   description = "Shows you a preview of whats in your inv",
   category = c.RENDER
)
public class InventoryPreview extends w {
   private static final ResourceLocation resourceLocation = new ResourceLocation("backdoored", "textures/inv_slot.png");
   private static final int fsl = 5;
   private static final int fsh = 1;
   private static final int fsa = 18;
   private j fsg;
   private j fsw;
   public static final boolean fsn;
   public static final int fsr;
   public static final boolean fmk;

   public InventoryPreview() {
      this.fsg = new i("x", this, 2, 0, mc.displayWidth + 100);
   }

   public void w() {
      // $FF: Couldn't be decompiled
   }

   private void f(int var1, int var2, int var3, int var4, int var5) {
      mc.getTextureManager().bindTexture(resourceLocation);
      GlStateManager.color((float)((var5 & 16711680) >> 16) / 255.0F, (float)((var5 & '\uff00') >> 8) / 255.0F, (float)(var5 & 255) / 255.0F);
      RenderHelper.disableStandardItemLighting();
      Gui.drawModalRectWithCustomSizedTexture(var1, var2, 0.0F, 0.0F, 5, 5, 256.0F, 256.0F);
      Gui.drawModalRectWithCustomSizedTexture(var1 + 5 + 18 * var3, var2 + 5 + 18 * var4, 25.0F, 25.0F, 5, 5, 256.0F, 256.0F);
      Gui.drawModalRectWithCustomSizedTexture(var1 + 5 + 18 * var3, var2, 25.0F, 0.0F, 5, 5, 256.0F, 256.0F);
      Gui.drawModalRectWithCustomSizedTexture(var1, var2 + 5 + 18 * var4, 0.0F, 25.0F, 5, 5, 256.0F, 256.0F);
      byte var6 = 0;
      if (var6 < var4) {
         Gui.drawModalRectWithCustomSizedTexture(var1, var2 + 5 + 18 * var6, 0.0F, 6.0F, 5, 18, 256.0F, 256.0F);
         Gui.drawModalRectWithCustomSizedTexture(var1 + 5 + 18 * var3, var2 + 5 + 18 * var6, 25.0F, 6.0F, 5, 18, 256.0F, 256.0F);
         byte var7 = 0;
         if (var7 < var3) {
            Gui.drawModalRectWithCustomSizedTexture(var1 + 5 + 18 * var7, var2, 6.0F, 0.0F, 18, 5, 256.0F, 256.0F);
            Gui.drawModalRectWithCustomSizedTexture(var1 + 5 + 18 * var7, var2 + 5 + 18 * var4, 6.0F, 25.0F, 18, 5, 256.0F, 256.0F);
            Gui.drawModalRectWithCustomSizedTexture(var1 + 5 + 18 * var7, var2 + 5 + 18 * var6, 6.0F, 6.0F, 18, 18, 256.0F, 256.0F);
            int var12 = var7 + 1;
         }

         int var11 = var6 + 1;
      }

      GlStateManager.color(1.0F, 1.0F, 1.0F);
   }
}

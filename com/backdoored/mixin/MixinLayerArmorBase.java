package com.backdoored.mixin;

import  l. c. h. j. v. d;
import  l. c. x. b;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
   value = {LayerArmorBase.class},
   priority = 999999999
)
public class MixinLayerArmorBase {
   @Redirect(
      method = {"renderEnchantedGlint"},
      at = @At(
   value = "INVOKE",
   target = "net/minecraft/client/renderer/GlStateManager.color(FFFF)V"
)
   )
   private static void renderEnchantedGlint(float red, float green, float blue, float alpha) {
      if ( d.ev != null &&  d.ev.qm()) {
         Color rainbow =  b.qa();
         red = (float)rainbow.getRed();
         blue = (float)rainbow.getBlue();
         green = (float)rainbow.getGreen();
         alpha = (float)rainbow.getAlpha();
      }

      GlStateManager.func_179131_c(red, green, blue, alpha);
   }
}

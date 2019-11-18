package com.backdoored.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiScreen.class})
public class MixinGuiScreen {
   @Shadow
   public Minecraft field_146297_k;

   @Inject(
      method = {"Lnet/minecraft/client/gui/GuiScreen;drawWorldBackground(I)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void drawWorldBackgroundWrapper(int tint, CallbackInfo ci) {
      if (this.field_146297_k.field_71441_e != null) {
         ci.cancel();
      }
   }
}

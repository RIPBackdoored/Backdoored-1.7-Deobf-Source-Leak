package com.backdoored.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
   value = {GuiPlayerTabOverlay.class},
   priority = 999999999
)
public class MixinGuiPlayerTabOverlay {
   @Redirect(
      method = {"renderPlayerlist"},
      at = @At(
   value = "INVOKE",
   target = "Ljava/lang/Math;min(II)I",
   ordinal = 0
)
   )
   public int noMin(int listSize, int maxTabSize) {
      return listSize;
   }

   @ModifyConstant(
      method = {"renderPlayerlist"},
      constant = {@Constant(
   intValue = 20,
   ordinal = 0
)}
   )
   public int getNumRows(int rows) {
      return 30;
   }

   @Redirect(
      method = {"renderPlayerlist"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/Minecraft;isIntegratedServerRunning()Z"
)
   )
   public boolean renderPlayerIcons(Minecraft mc) {
      return true;
   }
}

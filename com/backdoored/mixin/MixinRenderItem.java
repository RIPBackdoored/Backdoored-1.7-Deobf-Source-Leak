package com.backdoored.mixin;

import  l. c. h. j. v. d;
import  l. c. x. b;
import net.minecraft.client.renderer.RenderItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(
   value = {RenderItem.class},
   priority = 999999999
)
public class MixinRenderItem {
   @ModifyArg(
      method = {"renderEffect"},
      at = @At(
   value = "INVOKE",
   target = "net/minecraft/client/renderer/RenderItem.renderModel(Lnet/minecraft/client/renderer/block/model/IBakedModel;I)V"
),
      index = 1
   )
   private int renderModel(int oldColour) {
      return  d.ev != null &&  d.ev.qm() ?  b.qa().getRGB() : oldColour;
   }
}

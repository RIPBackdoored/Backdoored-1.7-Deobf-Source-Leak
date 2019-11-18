package com.backdoored.mixin;

import net.minecraft.client.renderer.chunk.RenderChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderChunk.class})
public class MixinRenderChunk {
   @Inject(
      method = {"setPosition"},
      at = {@At("HEAD")}
   )
   public void setPosition(int x, int y, int z, CallbackInfo ci) {
   }
}

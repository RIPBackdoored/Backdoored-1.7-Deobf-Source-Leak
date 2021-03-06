package com.backdoored.mixin;

import  l. c. u. j. a;
import net.minecraft.client.renderer.ChunkRenderContainer;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ChunkRenderContainer.class})
public class MixinChunkRenderContainer {
   @Inject(
      method = {"preRenderChunk"},
      at = {@At("HEAD")}
   )
   public void preRenderChunk(RenderChunk renderChunkIn, CallbackInfo ci) {
       a event = new  a(renderChunkIn);
      MinecraftForge.EVENT_BUS.post(event);
   }
}

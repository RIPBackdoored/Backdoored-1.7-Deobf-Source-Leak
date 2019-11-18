package com.backdoored.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.profiler.Profiler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({Minecraft.class})
public class MixinMinecraft {
   @Shadow
   @Final
   public Profiler field_71424_I;

   @Redirect(
      method = {"runTick"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/profiler/Profiler;endStartSection(Ljava/lang/String;)V",
   ordinal = 0
)
   )
   private void endStartGUISection(Profiler profiler, String name) {
      profiler.func_76318_c("gui");
   }

   @Redirect(
      method = {"runTick"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/texture/TextureManager;tick()V",
   ordinal = 0
)
   )
   private void tickTextureManagerWithCorrectProfiler(TextureManager textureManager) {
      this.field_71424_I.func_76318_c("textures");
      textureManager.func_110550_d();
      this.field_71424_I.func_76318_c("gui");
   }
}

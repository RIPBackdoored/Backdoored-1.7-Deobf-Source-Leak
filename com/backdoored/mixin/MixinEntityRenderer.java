package com.backdoored.mixin;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {EntityRenderer.class},
   priority = 999999999
)
public class MixinEntityRenderer {
   @Inject(
      method = {"setupFog"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void setupFog(int startCoords, float partialTicks, CallbackInfo callbackInfo) {
   }

   @Redirect(
      method = {"setupFog"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/ActiveRenderInfo;getBlockStateAtEntityViewpoint(Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;F)Lnet/minecraft/block/state/IBlockState;"
)
   )
   public IBlockState getBlockStateAtEntityViewpoint(World worldIn, Entity entityIn, float partialTicks) {
      return ActiveRenderInfo.func_186703_a(worldIn, entityIn, partialTicks);
   }

   @Redirect(
      method = {"orientCamera"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/multiplayer/WorldClient;rayTraceBlocks(Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;)Lnet/minecraft/util/math/RayTraceResult;"
)
   )
   public RayTraceResult rayTraceBlocks(WorldClient world, Vec3d start, Vec3d end) {
      return world.func_147447_a(start, end, false, true, true);
   }

   @Redirect(
      method = {"orientCamera"},
      at = @At(
   value = "INVOKE",
   target = "net/minecraft/client/renderer/GlStateManager.translate(FFF)V",
   ordinal = 2
)
   )
   private void getViewDistance(float x, float y, float z) {
      GlStateManager.func_179109_b(x, y, z);
   }
}

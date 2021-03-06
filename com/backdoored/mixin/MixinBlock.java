package com.backdoored.mixin;

import  l. c. u. dh;
import  l. c. u. h;
import  l. c. u. de. c;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Block.class})
public class MixinBlock {
   @Inject(
      method = {"shouldSideBeRendered"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side, CallbackInfoReturnable callback) {
       c event = new  c((Float)null);
      MinecraftForge.EVENT_BUS.post(event);
      if (event.fgg != null) {
         ((Block)this).func_149715_a(event.fgg);
         callback.setReturnValue(true);
      }

   }

   @Inject(
      method = {"getAmbientOcclusionLightValue"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void getAmbientOcclusionLightValue(CallbackInfoReturnable ci) {
       h event = new  h((Float)ci.getReturnValue());
      MinecraftForge.EVENT_BUS.post(event);
      ci.setReturnValue(event.qq);
   }

   @Inject(
      method = {"getPackedLightmapCoords"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getPackedLightmapCoordsWrapper(IBlockState state, IBlockAccess source, BlockPos pos, CallbackInfoReturnable cir) {
       dh event = new  dh((Integer)null);
      MinecraftForge.EVENT_BUS.post(event);
      if (event.fpz != null) {
         cir.setReturnValue(event.fpz);
      }

   }
}

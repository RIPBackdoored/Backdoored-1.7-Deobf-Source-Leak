package com.backdoored.mixin;

import  l. c. u. dt;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({BlockLiquid.class})
public class MixinBlockLiquid {
   @Inject(
      method = {"canCollideCheck"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void canCollideWithLiquid(IBlockState state, boolean hitIfLiquid, CallbackInfoReturnable cir) {
       dt event = new  dt(cir);
      MinecraftForge.EVENT_BUS.post(event);
   }
}

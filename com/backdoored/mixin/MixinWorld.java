package com.backdoored.mixin;

import  l. c. u. m;
import  l. c. u. z;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({World.class})
public class MixinWorld {
   @Inject(
      method = {"getSunBrightnessFactor"},
      at = {@At("RETURN")},
      cancellable = true,
      remap = false
   )
   private void getBrightnessOfSun(float partialTicks, CallbackInfoReturnable cir) {
       z event = new  z((Float)cir.getReturnValue());
      MinecraftForge.EVENT_BUS.post(event);
      cir.setReturnValue(event.nh);
   }

   @Inject(
      method = {"getSunBrightnessBody"},
      at = {@At("RETURN")},
      cancellable = true,
      remap = false
   )
   private void getBrightnessBodyOfSun(float partialTicks, CallbackInfoReturnable cir) {
       z event = new  z((Float)cir.getReturnValue());
      MinecraftForge.EVENT_BUS.post(event);
      cir.setReturnValue(event.nh);
   }

   @Inject(
      method = {"checkLightFor"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void checkLightForWrapper(EnumSkyBlock lightType, BlockPos pos, CallbackInfoReturnable cir) {
       m event = new  m((Boolean)null);
      MinecraftForge.EVENT_BUS.post(event);
      if (event.fks != null) {
         cir.setReturnValue(event.fks);
      }

   }
}

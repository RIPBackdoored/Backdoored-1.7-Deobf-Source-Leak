package com.backdoored.mixin;

import  l. c. u. z;
import net.minecraft.world.WorldProviderHell;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({WorldProviderHell.class})
public class MixinWorldProviderHell {
   @ModifyConstant(
      method = {"generateLightBrightnessTable"},
      constant = {@Constant(
   floatValue = 0.9F
)}
   )
   private float getBrightness(float initial) {
       z event = new  z(initial);
      MinecraftForge.EVENT_BUS.post(event);
      return event.nh;
   }
}

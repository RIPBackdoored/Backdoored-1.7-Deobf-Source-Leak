package com.backdoored.mixin;

import  l. c. u. dd;
import  l. c. u. dx;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({EntityLivingBase.class})
public class MixinEntityLivingBase {
   @Shadow
   public void func_70664_aZ() {
   }

   @ModifyConstant(
      method = {"getWaterSlowDown"},
      constant = {@Constant(
   floatValue = 0.8F
)}
   )
   public float getWaterSlowDownWrapper(float initial) {
       dx event = new  dx(initial);
      MinecraftForge.EVENT_BUS.post(event);
      return event.flb;
   }

   @ModifyConstant(
      method = {"handleJumpWater"},
      constant = {@Constant(
   doubleValue = 0.03999999910593033D
)}
   )
   public double handleJumpWaterWrap(double initial) {
       dd event = new  dd(initial);
      MinecraftForge.EVENT_BUS.post(event);
      return event.fpt;
   }

   @ModifyConstant(
      method = {"handleJumpLava"},
      constant = {@Constant(
   doubleValue = 0.03999999910593033D
)}
   )
   public double handleJumpLavaWrap(double initial) {
       dd event = new  dd(initial);
      MinecraftForge.EVENT_BUS.post(event);
      return event.fpt;
   }
}

package com.backdoored.mixin;

import  l. c. u. k;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityItem.class})
public abstract class MixinEntityItem {
   @Shadow
   private int field_145804_b;

   @Inject(
      method = {"setPickupDelay"},
      at = {@At("RETURN")},
      cancellable = true
   )
   public void setPickupDelayWrap(int ticks, CallbackInfo ci) {
       k event = new  k(this.field_145804_b);
      MinecraftForge.EVENT_BUS.post(event);
      this.field_145804_b = event.zw;
   }

   @Inject(
      method = {"setDefaultPickupDelay"},
      at = {@At("RETURN")},
      cancellable = true
   )
   public void setDefaultPickupDelayWrap(CallbackInfo ci) {
       k event = new  k(this.field_145804_b);
      MinecraftForge.EVENT_BUS.post(event);
      this.field_145804_b = event.zw;
   }

   @Inject(
      method = {"setNoPickupDelay"},
      at = {@At("RETURN")},
      cancellable = true
   )
   public void setNoPickupDelayWrap(CallbackInfo ci) {
       k event = new  k(this.field_145804_b);
      MinecraftForge.EVENT_BUS.post(event);
      this.field_145804_b = event.zw;
   }
}

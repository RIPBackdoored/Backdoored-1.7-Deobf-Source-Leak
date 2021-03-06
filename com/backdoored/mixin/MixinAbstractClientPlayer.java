package com.backdoored.mixin;

import  l. c. u. db;
import  l. c. u. l. a;
import  l. c. u. l. c;
import javax.annotation.Nullable;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
   value = {AbstractClientPlayer.class},
   priority = 999999999
)
public abstract class MixinAbstractClientPlayer extends MixinEntityPlayer {
   @Shadow
   @Nullable
   protected abstract NetworkPlayerInfo func_175155_b();

   @Overwrite
   @Nullable
   public ResourceLocation func_110303_q() {
      NetworkPlayerInfo networkplayerinfo = this.func_175155_b();
       db event = new  db(networkplayerinfo);
      MinecraftForge.EVENT_BUS.post(event);
      if (event.fyo != null) {
         return event.fyo;
      } else {
         return networkplayerinfo == null ? null : networkplayerinfo.func_178861_h();
      }
   }

   @Inject(
      method = {"hasSkin"},
      at = {@At("RETURN")},
      cancellable = true
   )
   public void hasSkin(CallbackInfoReturnable cir) {
       c event = new  c(this.func_175155_b(), (Boolean)cir.getReturnValue());
      MinecraftForge.EVENT_BUS.post(event);
      cir.setReturnValue(event.fmu);
   }

   @Inject(
      method = {"getLocationSkin()Lnet/minecraft/util/ResourceLocation;"},
      at = {@At("RETURN")},
      cancellable = true
   )
   public void getSkin(CallbackInfoReturnable cir) {
       a event = new  a(this.func_175155_b(), (ResourceLocation)cir.getReturnValue());
      MinecraftForge.EVENT_BUS.post(event);
      cir.setReturnValue(event.fog);
   }
}

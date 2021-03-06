package com.backdoored.mixin;

import  l. c. u. c;
import  l. c. u. p;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Entity.class})
public abstract class MixinEntity {
   @Shadow
   public abstract int func_82145_z();

   @Inject(
      method = {"turn"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void turn(float yaw, float pitch, CallbackInfo ci) {
       c event = new  c((Entity)this, yaw, pitch);
      MinecraftForge.EVENT_BUS.post(event);
      if (event.isCanceled()) {
         ci.cancel();
      }

      yaw = event.yv;
      pitch = event.yu;
   }

   @Redirect(
      method = {"onEntityUpdate"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/Entity;getMaxInPortalTime()I"
)
   )
   private int getModifiedMaxInPortalTime(Entity entity) {
       p event = new  p(entity, this.func_82145_z());
      MinecraftForge.EVENT_BUS.post(event);
      return event.bk;
   }
}

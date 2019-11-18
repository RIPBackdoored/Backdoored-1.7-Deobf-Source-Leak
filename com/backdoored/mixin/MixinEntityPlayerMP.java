package com.backdoored.mixin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityPlayerMP.class})
public class MixinEntityPlayerMP {
   @Inject(
      method = {"onDeath"},
      at = {@At("HEAD")}
   )
   public void onDeath(DamageSource cause, CallbackInfo ci) {
      System.out.println("Mixin Death");
   }

   @Redirect(
      method = {"isEntityInvulnerable"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/player/EntityPlayer;isEntityInvulnerable(Lnet/minecraft/util/DamageSource;)Z"
)
   )
   private boolean isEntityInvulnerable(EntityPlayer player, DamageSource source) {
      return false;
   }

   @Redirect(
      method = {"isEntityInvulnerable"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/player/EntityPlayerMP;isInvulnerableDimensionChange()Z"
)
   )
   private boolean isEntityInvulnerable(EntityPlayerMP entityPlayerMP) {
      return false;
   }
}

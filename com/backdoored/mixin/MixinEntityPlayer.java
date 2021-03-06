package com.backdoored.mixin;

import  l. c. u. e;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
   value = {EntityPlayer.class},
   priority = 9900
)
public abstract class MixinEntityPlayer {
   @Shadow
   public abstract GameProfile func_146103_bH();

   @ModifyConstant(
      method = {"attackTargetEntityWithCurrentItem"},
      constant = {@Constant(
   doubleValue = 0.6D
)}
   )
   private double decelerate(double original) {
      return 1.0D;
   }

   @Redirect(
      method = {"attackTargetEntityWithCurrentItem"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/player/EntityPlayer;setSprinting(Z)V"
)
   )
   private void dontSprintPlsThx(EntityPlayer player, boolean sprinting) {
   }

   @ModifyConstant(
      method = {"getPortalCooldown"},
      constant = {@Constant(
   intValue = 10
)}
   )
   private int getModifiedPortalCooldown(int original) {
       e event = new  e(original, (EntityPlayer)this);
      MinecraftForge.EVENT_BUS.post(event);
      return event.zv;
   }
}

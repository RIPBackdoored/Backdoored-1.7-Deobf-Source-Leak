package com.backdoored.mixin;

import  l. c. u. q;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {ItemRenderer.class},
   priority = 999999999
)
public abstract class MixinItemRenderer {
   @Shadow
   public abstract void func_187457_a(AbstractClientPlayer var1, float var2, float var3, EnumHand var4, float var5, ItemStack var6, float var7);

   @Inject(
      method = {"renderWaterOverlayTexture"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderWaterOverlayTexture(float partialTicks, CallbackInfo callbackInfo) {
   }

   @Redirect(
      method = {"renderItemInFirstPerson(F)V"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/ItemRenderer;renderItemInFirstPerson(Lnet/minecraft/client/entity/AbstractClientPlayer;FFLnet/minecraft/util/EnumHand;FLnet/minecraft/item/ItemStack;F)V"
)
   )
   private void renderItemInFirstPerson(ItemRenderer itemRenderer, AbstractClientPlayer player, float partialTicks, float pitch, EnumHand hand, float swingProgress, ItemStack stack, float equipProgress) {
       q event = new  q(itemRenderer, player, partialTicks, pitch, hand, swingProgress, stack, equipProgress);
      MinecraftForge.EVENT_BUS.post(event);
      event.wp.func_187457_a(event.wz, event.wb, event.wy, event.wx, event.wl, event.wh, event.wa);
   }
}

package com.backdoored.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Item.class})
public class MixinItem {
   @Inject(
      method = {"Lnet/minecraft/item/Item;setDamage(Lnet/minecraft/item/ItemStack;I)V"},
      at = {@At("RETURN")},
      remap = false
   )
   private void setDamageWrap(ItemStack stack, int damage, CallbackInfo ci) {
      try {
         ObfuscationReflectionHelper.setPrivateValue(ItemStack.class, stack, damage, new String[]{"itemDamage", "field_77991_e"});
      } catch (Exception var5) {
      }

   }
}

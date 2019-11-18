package com.backdoored.mixin;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ItemStack.class})
public class MixinItemStack {
   @Shadow
   int field_77991_e;
   int actualDamage;

   @Inject(
      method = {"<init>(Lnet/minecraft/item/Item;IILnet/minecraft/nbt/NBTTagCompound;)V"},
      at = {@At("RETURN")}
   )
   private void postInit(Item itemIn, int amount, int meta, NBTTagCompound capNBT, CallbackInfo ci) {
      this.field_77991_e = meta;
      this.actualDamage = meta;
   }

   @Redirect(
      method = {"<init>(Lnet/minecraft/nbt/NBTTagCompound;)V"},
      at = @At(
   value = "INVOKE",
   target = "Ljava/lang/Math;max(II)I"
)
   )
   private int max(int a, int b) {
      this.actualDamage = b;
      return b;
   }

   @Redirect(
      method = {"getTooltip"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/item/ItemStack;getItemDamage()I"
)
   )
   private int getItemDamage(ItemStack itemStack) {
      return this.actualDamage;
   }

   @Redirect(
      method = {"getTooltip"},
      at = @At(
   value = "INVOKE",
   target = "net/minecraft/item/ItemStack.isItemDamaged()Z"
)
   )
   private boolean isItemDamaged(ItemStack itemStack) {
      return true;
   }

   @Redirect(
      method = {"getTooltip"},
      at = @At(
   value = "INVOKE",
   target = "net/minecraft/client/util/ITooltipFlag.isAdvanced()Z",
   ordinal = 2
)
   )
   private boolean isAdvanced(ITooltipFlag iTooltipFlag) {
      return true;
   }
}

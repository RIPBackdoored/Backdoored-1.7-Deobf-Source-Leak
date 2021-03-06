package com.backdoored.mixin;

import  l. c. u. i;
import net.minecraft.entity.passive.EntityPig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin({EntityPig.class})
public class MixinEntityPig {
   @ModifyArgs(
      method = {"travel"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/passive/EntityAnimal;travel(FFF)V"
)
   )
   private void travel(Args args, float strafe, float vertical, float forward) {
       i event = new  i();
      MinecraftForge.EVENT_BUS.post(event);
      if (event.getResult() != Result.ALLOW && event.getResult() != Result.DEFAULT) {
         args.setAll(strafe, vertical, 0);
      } else {
         args.setAll(strafe, vertical, forward);
      }

   }
}

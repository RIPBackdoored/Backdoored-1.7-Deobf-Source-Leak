package com.backdoored.mixin.minecraftforge;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.IEventListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({EventBus.class})
public class MixinEventBus {
   @Redirect(
      method = {"post"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraftforge/fml/common/eventhandler/IEventListener;invoke(Lnet/minecraftforge/fml/common/eventhandler/Event;)V",
   remap = false
),
      remap = false
   )
   private void invoke(IEventListener iEventListener, Event event) {
      try {
         iEventListener.invoke(event);
      } catch (Throwable var7) {
         String msg = "WARNING!!!! The event bus encountered an error while invoking event " + event.getClass().getName() + "! Luckily your using Backdoored TM client (Trademarked and patented) so we've prevented your client from crashing! Isn't that lucky!";
         FMLLog.log.warn(msg);

         try {
            Minecraft.func_71410_x().field_71439_g.func_145747_a(new TextComponentString(msg));
         } catch (Throwable var6) {
            var6.printStackTrace();
         }

         var7.printStackTrace();
      }

   }
}

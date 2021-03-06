package com.backdoored.mixin;

import  l. c. u. df;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({WorldClient.class})
public class MixinWorldClient {
   @Redirect(
      method = {"makeFireworks"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/particle/ParticleManager;addEffect(Lnet/minecraft/client/particle/Particle;)V"
)
   )
   private void makeFireworkParticles(ParticleManager particleManager, Particle effect) {
       df event = new  df();
      MinecraftForge.EVENT_BUS.post(event);
      if (!event.isCanceled()) {
         particleManager.func_78873_a(effect);
      }

   }
}

package com.backdoored.mixin;

import  l. c. q;
import  l. c. u. g;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.network.play.server.SPacketCombatEvent;
import net.minecraft.network.play.server.SPacketCombatEvent.Event;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {NetHandlerPlayClient.class},
   priority = 999999999
)
public class MixinNetHandlerPlayClient {
   @Shadow
   private boolean field_147309_h;
   @Shadow
   private WorldClient field_147300_g;
   @Shadow
   private Minecraft field_147299_f;

   @Inject(
      method = {"handleChunkData"},
      at = {@At("RETURN")}
   )
   private void postHandleChunkData(SPacketChunkData packet, CallbackInfo ci) {
   }

   @Inject(
      method = {"handleCombatEvent"},
      at = {@At("INVOKE")}
   )
   private void onPlayerDeath(SPacketCombatEvent packet, CallbackInfo ci) {
      if (packet.field_179776_a == Event.ENTITY_DIED) {
         System.out.println("A player died! " + packet.field_179775_c);
         Entity e =  q.fyb.field_71441_e.func_73045_a(packet.field_179775_c);
         if (e instanceof EntityPlayer) {
             g event = new  g((EntityPlayer)e);
            MinecraftForge.EVENT_BUS.post(event);
         }
      }

   }
}

package com.backdoored.mixin;

import  l. c. u. s. c;
import  l. c. u. s. g;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.TimeoutException;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {NetworkManager.class},
   priority = 999999999
)
public class MixinNetworkManager {
   @Inject(
      method = {"sendPacket(Lnet/minecraft/network/Packet;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onSendPacket(Packet packet, CallbackInfo callbackInfo) {
       c event = new  c(packet);
      MinecraftForge.EVENT_BUS.post(event);
      if (event.isCanceled() && callbackInfo.isCancellable()) {
         callbackInfo.cancel();
      }

   }

   @Inject(
      method = {"channelRead0"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onChannelRead(ChannelHandlerContext context, Packet packet, CallbackInfo callbackInfo) {
       g event = new  g(packet);
      MinecraftForge.EVENT_BUS.post(event);
      if (event.isCanceled() && callbackInfo.isCancellable()) {
         callbackInfo.cancel();
      }

   }

   @Inject(
      method = {"exceptionCaught"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void exceptionCaught(ChannelHandlerContext channel, Throwable throwable, CallbackInfo info) {
      if (!(throwable instanceof TimeoutException)) {
         throwable.printStackTrace();
         info.cancel();
      }

   }
}

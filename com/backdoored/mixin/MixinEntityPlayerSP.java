package com.backdoored.mixin;

import  l. c. h. j. i;
import  l. c. h. j. s. z;
import  l. c. u. du. a;
import  l. c. u. du. c;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityPlayerSP.class})
public class MixinEntityPlayerSP extends MixinEntityLivingBase {
   private Minecraft mc = Minecraft.func_71410_x();

   @Inject(
      method = {"onUpdateWalkingPlayer"},
      at = {@At("HEAD")}
   )
   private void preMotion(CallbackInfo callbackInfo) {
       c event = new  c(this.mc.field_71439_g.field_70177_z, this.mc.field_71439_g.field_70125_A, this.mc.field_71439_g.field_70122_E);
      MinecraftForge.EVENT_BUS.post(event);
      this.mc.field_71439_g.field_70177_z = event.qfk;
      this.mc.field_71439_g.field_70125_A = event.qff;
      this.mc.field_71439_g.field_70122_E = event.qfq;
   }

   @Inject(
      method = {"onUpdateWalkingPlayer"},
      at = {@At("RETURN")}
   )
   private void postMotion(CallbackInfo callbackInfo) {
       a event = new  a(this.mc.field_71439_g.field_70177_z, this.mc.field_71439_g.field_70125_A, this.mc.field_71439_g.field_70122_E);
      MinecraftForge.EVENT_BUS.post(event);
      this.mc.field_71439_g.field_70177_z = event.qfk;
      this.mc.field_71439_g.field_70125_A = event.qff;
      this.mc.field_71439_g.field_70122_E = event.qfq;
   }

   public void func_70664_aZ() {
      try {
         double oldMotionX = ((EntityPlayerSP)this).field_70159_w;
         double oldMotionZ = ((EntityPlayerSP)this).field_70179_y;
         super.func_70664_aZ();
         (( z) i.k( z.class)).k(oldMotionX, oldMotionZ, (EntityPlayerSP)this);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }
}

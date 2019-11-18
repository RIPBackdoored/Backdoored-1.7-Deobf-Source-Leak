package com.backdoored.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(
   value = {RenderGlobal.class},
   priority = 999999999
)
public class MixinRenderGlobal {
   @Final
   @Shadow
   private Minecraft field_72777_q;
}

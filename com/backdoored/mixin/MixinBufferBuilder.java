package com.backdoored.mixin;

import java.nio.IntBuffer;
import net.minecraft.client.renderer.BufferBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({BufferBuilder.class})
public class MixinBufferBuilder {
   private int startBufferSizeIn;
   @Shadow
   private IntBuffer field_178999_b;
}

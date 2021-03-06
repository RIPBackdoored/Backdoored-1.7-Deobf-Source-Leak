package com.backdoored.mixin;

import  l. c. u. a;
import java.io.File;
import javax.annotation.Nullable;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({ScreenShotHelper.class})
public class MixinScreenshotHelper {
   @Redirect(
      method = {"Lnet/minecraft/util/ScreenShotHelper;saveScreenshot(Ljava/io/File;IILnet/minecraft/client/shader/Framebuffer;)Lnet/minecraft/util/text/ITextComponent;"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/util/ScreenShotHelper;saveScreenshot(Ljava/io/File;Ljava/lang/String;IILnet/minecraft/client/shader/Framebuffer;)Lnet/minecraft/util/text/ITextComponent;"
)
   )
   private static ITextComponent saveScreenshot(File gameDirectory, @Nullable String screenshotName, int width, int height, Framebuffer buffer) {
       a event = new  a(gameDirectory, screenshotName, width, height, buffer);
      MinecraftForge.EVENT_BUS.post(event);
      return !event.isCanceled() ? ScreenShotHelper.func_148259_a(gameDirectory, (String)null, width, height, buffer) : event.fuu;
   }
}

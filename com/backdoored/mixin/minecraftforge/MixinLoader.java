package com.backdoored.mixin.minecraftforge;

import java.io.File;
import java.util.List;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.libraries.LibraryManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({Loader.class})
public class MixinLoader {
   @Redirect(
      method = {"identifyMods"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraftforge/fml/relauncher/libraries/LibraryManager;gatherLegacyCanidates(Ljava/io/File;)Ljava/util/List;",
   remap = false
),
      remap = false
   )
   protected static List gatherLegacyCanidates(File mcDir) {
      System.out.println("Called gatherLegacyCandidates mixin");
      return LibraryManager.gatherLegacyCanidates(mcDir);
   }
}

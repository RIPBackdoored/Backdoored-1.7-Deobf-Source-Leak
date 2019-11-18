package org.spongepowered.asm.mixin;

import org.spongepowered.asm.util.JavaVersion;

final class MixinEnvironment$CompatibilityLevel$2 extends MixinEnvironment$CompatibilityLevel {
   MixinEnvironment$CompatibilityLevel$2(String var1, int var2, int ver, int classVersion, boolean resolveMethodsInInterfaces) {
      super(var1, var2, ver, classVersion, resolveMethodsInInterfaces, (MixinEnvironment$1)null);
   }

   boolean isSupported() {
      return JavaVersion.current() >= 1.8D;
   }
}

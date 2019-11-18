package org.spongepowered.asm.mixin;

final class MixinEnvironment$CompatibilityLevel$3 extends MixinEnvironment$CompatibilityLevel {
   MixinEnvironment$CompatibilityLevel$3(String var1, int var2, int ver, int classVersion, boolean resolveMethodsInInterfaces) {
      super(var1, var2, ver, classVersion, resolveMethodsInInterfaces, (MixinEnvironment$1)null);
   }

   boolean isSupported() {
      return false;
   }
}

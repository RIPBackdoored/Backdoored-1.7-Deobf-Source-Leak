package org.spongepowered.asm.mixin.extensibility;

public interface IMixinErrorHandler {
   IMixinErrorHandler$ErrorAction onPrepareError(IMixinConfig var1, Throwable var2, IMixinInfo var3, IMixinErrorHandler$ErrorAction var4);

   IMixinErrorHandler$ErrorAction onApplyError(String var1, Throwable var2, IMixinInfo var3, IMixinErrorHandler$ErrorAction var4);
}

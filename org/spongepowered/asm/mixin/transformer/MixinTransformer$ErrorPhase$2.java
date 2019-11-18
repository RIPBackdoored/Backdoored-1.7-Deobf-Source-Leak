package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.extensibility.IMixinErrorHandler;
import org.spongepowered.asm.mixin.extensibility.IMixinErrorHandler$ErrorAction;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;

final class MixinTransformer$ErrorPhase$2 extends MixinTransformer$ErrorPhase {
   MixinTransformer$ErrorPhase$2(String var1, int var2) {
      super(var1, var2, (MixinTransformer$1)null);
   }

   IMixinErrorHandler$ErrorAction onError(IMixinErrorHandler handler, String context, InvalidMixinException ex, IMixinInfo mixin, IMixinErrorHandler$ErrorAction action) {
      IMixinErrorHandler$ErrorAction var10000;
      try {
         var10000 = handler.onApplyError(context, ex, mixin, action);
      } catch (AbstractMethodError var7) {
         return action;
      }

      return var10000;
   }

   protected String getContext(IMixinInfo mixin, String context) {
      return String.format("%s -> %s", mixin, context);
   }
}

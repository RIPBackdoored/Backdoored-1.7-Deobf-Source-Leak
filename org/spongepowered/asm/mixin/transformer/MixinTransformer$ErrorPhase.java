package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.MixinEnvironment$Phase;
import org.spongepowered.asm.mixin.extensibility.IMixinConfig;
import org.spongepowered.asm.mixin.extensibility.IMixinErrorHandler;
import org.spongepowered.asm.mixin.extensibility.IMixinErrorHandler$ErrorAction;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;

abstract class MixinTransformer$ErrorPhase extends Enum {
   public static final MixinTransformer$ErrorPhase PREPARE = new MixinTransformer$ErrorPhase$1("PREPARE", 0);
   public static final MixinTransformer$ErrorPhase APPLY = new MixinTransformer$ErrorPhase$2("APPLY", 1);
   private final String text;
   // $FF: synthetic field
   private static final MixinTransformer$ErrorPhase[] $VALUES = new MixinTransformer$ErrorPhase[]{PREPARE, APPLY};

   public static MixinTransformer$ErrorPhase[] values() {
      return (MixinTransformer$ErrorPhase[])$VALUES.clone();
   }

   public static MixinTransformer$ErrorPhase valueOf(String name) {
      return (MixinTransformer$ErrorPhase)Enum.valueOf(MixinTransformer$ErrorPhase.class, name);
   }

   private MixinTransformer$ErrorPhase(String var1, int var2) {
      super(var1, var2);
      this.text = this.name().toLowerCase();
   }

   abstract IMixinErrorHandler$ErrorAction onError(IMixinErrorHandler var1, String var2, InvalidMixinException var3, IMixinInfo var4, IMixinErrorHandler$ErrorAction var5);

   protected abstract String getContext(IMixinInfo var1, String var2);

   public String getLogMessage(String context, InvalidMixinException ex, IMixinInfo mixin) {
      return String.format("Mixin %s failed %s: %s %s", this.text, this.getContext(mixin, context), ex.getClass().getName(), ex.getMessage());
   }

   public String getErrorMessage(IMixinInfo mixin, IMixinConfig config, MixinEnvironment$Phase phase) {
      return String.format("Mixin [%s] from phase [%s] in config [%s] FAILED during %s", mixin, phase, config, this.name());
   }

   // $FF: synthetic method
   MixinTransformer$ErrorPhase(String x0, int x1, MixinTransformer$1 x2) {
      this(x0, x1);
   }
}

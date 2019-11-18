package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.MixinEnvironment$Side;

// $FF: synthetic class
class MixinConfig$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$org$spongepowered$asm$mixin$MixinEnvironment$Side = new int[MixinEnvironment$Side.values().length];

   static {
      try {
         $SwitchMap$org$spongepowered$asm$mixin$MixinEnvironment$Side[MixinEnvironment$Side.CLIENT.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
      }

      try {
         $SwitchMap$org$spongepowered$asm$mixin$MixinEnvironment$Side[MixinEnvironment$Side.SERVER.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
      }

      try {
         $SwitchMap$org$spongepowered$asm$mixin$MixinEnvironment$Side[MixinEnvironment$Side.UNKNOWN.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
      }

   }
}

package org.spongepowered.tools.obfuscation;

import org.spongepowered.asm.mixin.gen.AccessorInfo$AccessorType;

// $FF: synthetic class
class AnnotatedMixinElementHandlerAccessor$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$org$spongepowered$asm$mixin$gen$AccessorInfo$AccessorType = new int[AccessorInfo$AccessorType.values().length];

   static {
      try {
         $SwitchMap$org$spongepowered$asm$mixin$gen$AccessorInfo$AccessorType[AccessorInfo$AccessorType.FIELD_GETTER.ordinal()] = 1;
      } catch (NoSuchFieldError var2) {
      }

      try {
         $SwitchMap$org$spongepowered$asm$mixin$gen$AccessorInfo$AccessorType[AccessorInfo$AccessorType.FIELD_SETTER.ordinal()] = 2;
      } catch (NoSuchFieldError var1) {
      }

   }
}

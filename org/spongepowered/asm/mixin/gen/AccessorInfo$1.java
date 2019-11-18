package org.spongepowered.asm.mixin.gen;

// $FF: synthetic class
class AccessorInfo$1 {
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

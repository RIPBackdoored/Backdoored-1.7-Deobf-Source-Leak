package org.spongepowered.asm.mixin;

final class MixinEnvironment$Option$Inherit extends Enum {
   public static final MixinEnvironment$Option$Inherit INHERIT = new MixinEnvironment$Option$Inherit("INHERIT", 0);
   public static final MixinEnvironment$Option$Inherit ALLOW_OVERRIDE = new MixinEnvironment$Option$Inherit("ALLOW_OVERRIDE", 1);
   public static final MixinEnvironment$Option$Inherit INDEPENDENT = new MixinEnvironment$Option$Inherit("INDEPENDENT", 2);
   public static final MixinEnvironment$Option$Inherit ALWAYS_FALSE = new MixinEnvironment$Option$Inherit("ALWAYS_FALSE", 3);
   // $FF: synthetic field
   private static final MixinEnvironment$Option$Inherit[] $VALUES = new MixinEnvironment$Option$Inherit[]{INHERIT, ALLOW_OVERRIDE, INDEPENDENT, ALWAYS_FALSE};

   public static MixinEnvironment$Option$Inherit[] values() {
      return (MixinEnvironment$Option$Inherit[])$VALUES.clone();
   }

   public static MixinEnvironment$Option$Inherit valueOf(String name) {
      return (MixinEnvironment$Option$Inherit)Enum.valueOf(MixinEnvironment$Option$Inherit.class, name);
   }

   private MixinEnvironment$Option$Inherit(String var1, int var2) {
      super(var1, var2);
   }
}

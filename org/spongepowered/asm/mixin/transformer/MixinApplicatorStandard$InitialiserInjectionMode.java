package org.spongepowered.asm.mixin.transformer;

final class MixinApplicatorStandard$InitialiserInjectionMode extends Enum {
   public static final MixinApplicatorStandard$InitialiserInjectionMode DEFAULT = new MixinApplicatorStandard$InitialiserInjectionMode("DEFAULT", 0);
   public static final MixinApplicatorStandard$InitialiserInjectionMode SAFE = new MixinApplicatorStandard$InitialiserInjectionMode("SAFE", 1);
   // $FF: synthetic field
   private static final MixinApplicatorStandard$InitialiserInjectionMode[] $VALUES = new MixinApplicatorStandard$InitialiserInjectionMode[]{DEFAULT, SAFE};

   public static MixinApplicatorStandard$InitialiserInjectionMode[] values() {
      return (MixinApplicatorStandard$InitialiserInjectionMode[])$VALUES.clone();
   }

   public static MixinApplicatorStandard$InitialiserInjectionMode valueOf(String name) {
      return (MixinApplicatorStandard$InitialiserInjectionMode)Enum.valueOf(MixinApplicatorStandard$InitialiserInjectionMode.class, name);
   }

   private MixinApplicatorStandard$InitialiserInjectionMode(String var1, int var2) {
      super(var1, var2);
   }
}

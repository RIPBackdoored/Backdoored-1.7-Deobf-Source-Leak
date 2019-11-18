package org.spongepowered.asm.mixin.transformer;

final class MixinApplicatorStandard$ApplicatorPass extends Enum {
   public static final MixinApplicatorStandard$ApplicatorPass MAIN = new MixinApplicatorStandard$ApplicatorPass("MAIN", 0);
   public static final MixinApplicatorStandard$ApplicatorPass PREINJECT = new MixinApplicatorStandard$ApplicatorPass("PREINJECT", 1);
   public static final MixinApplicatorStandard$ApplicatorPass INJECT = new MixinApplicatorStandard$ApplicatorPass("INJECT", 2);
   // $FF: synthetic field
   private static final MixinApplicatorStandard$ApplicatorPass[] $VALUES = new MixinApplicatorStandard$ApplicatorPass[]{MAIN, PREINJECT, INJECT};

   public static MixinApplicatorStandard$ApplicatorPass[] values() {
      return (MixinApplicatorStandard$ApplicatorPass[])$VALUES.clone();
   }

   public static MixinApplicatorStandard$ApplicatorPass valueOf(String name) {
      return (MixinApplicatorStandard$ApplicatorPass)Enum.valueOf(MixinApplicatorStandard$ApplicatorPass.class, name);
   }

   private MixinApplicatorStandard$ApplicatorPass(String var1, int var2) {
      super(var1, var2);
   }
}

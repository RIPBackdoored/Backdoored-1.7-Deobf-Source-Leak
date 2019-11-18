package org.spongepowered.asm.mixin;

public abstract class MixinEnvironment$Side extends Enum {
   public static final MixinEnvironment$Side UNKNOWN = new MixinEnvironment$Side$1("UNKNOWN", 0);
   public static final MixinEnvironment$Side CLIENT = new MixinEnvironment$Side$2("CLIENT", 1);
   public static final MixinEnvironment$Side SERVER = new MixinEnvironment$Side$3("SERVER", 2);
   // $FF: synthetic field
   private static final MixinEnvironment$Side[] $VALUES = new MixinEnvironment$Side[]{UNKNOWN, CLIENT, SERVER};

   public static MixinEnvironment$Side[] values() {
      return (MixinEnvironment$Side[])$VALUES.clone();
   }

   public static MixinEnvironment$Side valueOf(String name) {
      return (MixinEnvironment$Side)Enum.valueOf(MixinEnvironment$Side.class, name);
   }

   private MixinEnvironment$Side(String var1, int var2) {
      super(var1, var2);
   }

   protected abstract boolean detect();

   // $FF: synthetic method
   MixinEnvironment$Side(String x0, int x1, MixinEnvironment$1 x2) {
      this(x0, x1);
   }
}

package org.spongepowered.asm.mixin;

public class MixinEnvironment$CompatibilityLevel extends Enum {
   public static final MixinEnvironment$CompatibilityLevel JAVA_6 = new MixinEnvironment$CompatibilityLevel("JAVA_6", 0, 6, 50, false);
   public static final MixinEnvironment$CompatibilityLevel JAVA_7 = new MixinEnvironment$CompatibilityLevel$1("JAVA_7", 1, 7, 51, false);
   public static final MixinEnvironment$CompatibilityLevel JAVA_8 = new MixinEnvironment$CompatibilityLevel$2("JAVA_8", 2, 8, 52, true);
   public static final MixinEnvironment$CompatibilityLevel JAVA_9 = new MixinEnvironment$CompatibilityLevel$3("JAVA_9", 3, 9, 53, true);
   private static final int CLASS_V1_9 = 53;
   private final int ver;
   private final int classVersion;
   private final boolean supportsMethodsInInterfaces;
   private MixinEnvironment$CompatibilityLevel maxCompatibleLevel;
   // $FF: synthetic field
   private static final MixinEnvironment$CompatibilityLevel[] $VALUES = new MixinEnvironment$CompatibilityLevel[]{JAVA_6, JAVA_7, JAVA_8, JAVA_9};

   public static MixinEnvironment$CompatibilityLevel[] values() {
      return (MixinEnvironment$CompatibilityLevel[])$VALUES.clone();
   }

   public static MixinEnvironment$CompatibilityLevel valueOf(String name) {
      return (MixinEnvironment$CompatibilityLevel)Enum.valueOf(MixinEnvironment$CompatibilityLevel.class, name);
   }

   private MixinEnvironment$CompatibilityLevel(String var1, int var2, int ver, int classVersion, boolean resolveMethodsInInterfaces) {
      super(var1, var2);
      this.ver = ver;
      this.classVersion = classVersion;
      this.supportsMethodsInInterfaces = resolveMethodsInInterfaces;
   }

   private void setMaxCompatibleLevel(MixinEnvironment$CompatibilityLevel maxCompatibleLevel) {
      this.maxCompatibleLevel = maxCompatibleLevel;
   }

   boolean isSupported() {
      return true;
   }

   public int classVersion() {
      return this.classVersion;
   }

   public boolean supportsMethodsInInterfaces() {
      return this.supportsMethodsInInterfaces;
   }

   public boolean isAtLeast(MixinEnvironment$CompatibilityLevel level) {
      return level == null || this.ver >= level.ver;
   }

   public boolean canElevateTo(MixinEnvironment$CompatibilityLevel level) {
      if (level != null && this.maxCompatibleLevel != null) {
         return level.ver <= this.maxCompatibleLevel.ver;
      } else {
         return true;
      }
   }

   public boolean canSupport(MixinEnvironment$CompatibilityLevel level) {
      return level == null ? true : level.canElevateTo(this);
   }

   // $FF: synthetic method
   MixinEnvironment$CompatibilityLevel(String x0, int x1, int x2, int x3, boolean x4, MixinEnvironment$1 x5) {
      this(x0, x1, x2, x3, x4);
   }
}

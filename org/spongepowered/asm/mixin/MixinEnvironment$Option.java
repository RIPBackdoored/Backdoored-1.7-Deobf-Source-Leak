package org.spongepowered.asm.mixin;

public final class MixinEnvironment$Option extends Enum {
   public static final MixinEnvironment$Option DEBUG_ALL = new MixinEnvironment$Option("DEBUG_ALL", 0, "debug");
   public static final MixinEnvironment$Option DEBUG_EXPORT = new MixinEnvironment$Option("DEBUG_EXPORT", 1, DEBUG_ALL, "export");
   public static final MixinEnvironment$Option DEBUG_EXPORT_FILTER = new MixinEnvironment$Option("DEBUG_EXPORT_FILTER", 2, DEBUG_EXPORT, "filter", false);
   public static final MixinEnvironment$Option DEBUG_EXPORT_DECOMPILE = new MixinEnvironment$Option("DEBUG_EXPORT_DECOMPILE", 3, DEBUG_EXPORT, MixinEnvironment$Option$Inherit.ALLOW_OVERRIDE, "decompile");
   public static final MixinEnvironment$Option DEBUG_EXPORT_DECOMPILE_THREADED = new MixinEnvironment$Option("DEBUG_EXPORT_DECOMPILE_THREADED", 4, DEBUG_EXPORT_DECOMPILE, MixinEnvironment$Option$Inherit.ALLOW_OVERRIDE, "async");
   public static final MixinEnvironment$Option DEBUG_EXPORT_DECOMPILE_MERGESIGNATURES = new MixinEnvironment$Option("DEBUG_EXPORT_DECOMPILE_MERGESIGNATURES", 5, DEBUG_EXPORT_DECOMPILE, MixinEnvironment$Option$Inherit.ALLOW_OVERRIDE, "mergeGenericSignatures");
   public static final MixinEnvironment$Option DEBUG_VERIFY = new MixinEnvironment$Option("DEBUG_VERIFY", 6, DEBUG_ALL, "verify");
   public static final MixinEnvironment$Option DEBUG_VERBOSE = new MixinEnvironment$Option("DEBUG_VERBOSE", 7, DEBUG_ALL, "verbose");
   public static final MixinEnvironment$Option DEBUG_INJECTORS = new MixinEnvironment$Option("DEBUG_INJECTORS", 8, DEBUG_ALL, "countInjections");
   public static final MixinEnvironment$Option DEBUG_STRICT = new MixinEnvironment$Option("DEBUG_STRICT", 9, DEBUG_ALL, MixinEnvironment$Option$Inherit.INDEPENDENT, "strict");
   public static final MixinEnvironment$Option DEBUG_UNIQUE = new MixinEnvironment$Option("DEBUG_UNIQUE", 10, DEBUG_STRICT, "unique");
   public static final MixinEnvironment$Option DEBUG_TARGETS = new MixinEnvironment$Option("DEBUG_TARGETS", 11, DEBUG_STRICT, "targets");
   public static final MixinEnvironment$Option DEBUG_PROFILER = new MixinEnvironment$Option("DEBUG_PROFILER", 12, DEBUG_ALL, MixinEnvironment$Option$Inherit.ALLOW_OVERRIDE, "profiler");
   public static final MixinEnvironment$Option DUMP_TARGET_ON_FAILURE = new MixinEnvironment$Option("DUMP_TARGET_ON_FAILURE", 13, "dumpTargetOnFailure");
   public static final MixinEnvironment$Option CHECK_ALL = new MixinEnvironment$Option("CHECK_ALL", 14, "checks");
   public static final MixinEnvironment$Option CHECK_IMPLEMENTS = new MixinEnvironment$Option("CHECK_IMPLEMENTS", 15, CHECK_ALL, "interfaces");
   public static final MixinEnvironment$Option CHECK_IMPLEMENTS_STRICT = new MixinEnvironment$Option("CHECK_IMPLEMENTS_STRICT", 16, CHECK_IMPLEMENTS, MixinEnvironment$Option$Inherit.ALLOW_OVERRIDE, "strict");
   public static final MixinEnvironment$Option IGNORE_CONSTRAINTS = new MixinEnvironment$Option("IGNORE_CONSTRAINTS", 17, "ignoreConstraints");
   public static final MixinEnvironment$Option HOT_SWAP = new MixinEnvironment$Option("HOT_SWAP", 18, "hotSwap");
   public static final MixinEnvironment$Option ENVIRONMENT = new MixinEnvironment$Option("ENVIRONMENT", 19, MixinEnvironment$Option$Inherit.ALWAYS_FALSE, "env");
   public static final MixinEnvironment$Option OBFUSCATION_TYPE = new MixinEnvironment$Option("OBFUSCATION_TYPE", 20, ENVIRONMENT, MixinEnvironment$Option$Inherit.ALWAYS_FALSE, "obf");
   public static final MixinEnvironment$Option DISABLE_REFMAP = new MixinEnvironment$Option("DISABLE_REFMAP", 21, ENVIRONMENT, MixinEnvironment$Option$Inherit.INDEPENDENT, "disableRefMap");
   public static final MixinEnvironment$Option REFMAP_REMAP = new MixinEnvironment$Option("REFMAP_REMAP", 22, ENVIRONMENT, MixinEnvironment$Option$Inherit.INDEPENDENT, "remapRefMap");
   public static final MixinEnvironment$Option REFMAP_REMAP_RESOURCE = new MixinEnvironment$Option("REFMAP_REMAP_RESOURCE", 23, ENVIRONMENT, MixinEnvironment$Option$Inherit.INDEPENDENT, "refMapRemappingFile", "");
   public static final MixinEnvironment$Option REFMAP_REMAP_SOURCE_ENV = new MixinEnvironment$Option("REFMAP_REMAP_SOURCE_ENV", 24, ENVIRONMENT, MixinEnvironment$Option$Inherit.INDEPENDENT, "refMapRemappingEnv", "searge");
   public static final MixinEnvironment$Option REFMAP_REMAP_ALLOW_PERMISSIVE = new MixinEnvironment$Option("REFMAP_REMAP_ALLOW_PERMISSIVE", 25, ENVIRONMENT, MixinEnvironment$Option$Inherit.INDEPENDENT, "allowPermissiveMatch", true, "true");
   public static final MixinEnvironment$Option IGNORE_REQUIRED = new MixinEnvironment$Option("IGNORE_REQUIRED", 26, ENVIRONMENT, MixinEnvironment$Option$Inherit.INDEPENDENT, "ignoreRequired");
   public static final MixinEnvironment$Option DEFAULT_COMPATIBILITY_LEVEL = new MixinEnvironment$Option("DEFAULT_COMPATIBILITY_LEVEL", 27, ENVIRONMENT, MixinEnvironment$Option$Inherit.INDEPENDENT, "compatLevel");
   public static final MixinEnvironment$Option SHIFT_BY_VIOLATION_BEHAVIOUR = new MixinEnvironment$Option("SHIFT_BY_VIOLATION_BEHAVIOUR", 28, ENVIRONMENT, MixinEnvironment$Option$Inherit.INDEPENDENT, "shiftByViolation", "warn");
   public static final MixinEnvironment$Option INITIALISER_INJECTION_MODE = new MixinEnvironment$Option("INITIALISER_INJECTION_MODE", 29, "initialiserInjectionMode", "default");
   private static final String PREFIX = "mixin";
   final MixinEnvironment$Option parent;
   final MixinEnvironment$Option$Inherit inheritance;
   final String property;
   final String defaultValue;
   final boolean isFlag;
   final int depth;
   // $FF: synthetic field
   private static final MixinEnvironment$Option[] $VALUES = new MixinEnvironment$Option[]{DEBUG_ALL, DEBUG_EXPORT, DEBUG_EXPORT_FILTER, DEBUG_EXPORT_DECOMPILE, DEBUG_EXPORT_DECOMPILE_THREADED, DEBUG_EXPORT_DECOMPILE_MERGESIGNATURES, DEBUG_VERIFY, DEBUG_VERBOSE, DEBUG_INJECTORS, DEBUG_STRICT, DEBUG_UNIQUE, DEBUG_TARGETS, DEBUG_PROFILER, DUMP_TARGET_ON_FAILURE, CHECK_ALL, CHECK_IMPLEMENTS, CHECK_IMPLEMENTS_STRICT, IGNORE_CONSTRAINTS, HOT_SWAP, ENVIRONMENT, OBFUSCATION_TYPE, DISABLE_REFMAP, REFMAP_REMAP, REFMAP_REMAP_RESOURCE, REFMAP_REMAP_SOURCE_ENV, REFMAP_REMAP_ALLOW_PERMISSIVE, IGNORE_REQUIRED, DEFAULT_COMPATIBILITY_LEVEL, SHIFT_BY_VIOLATION_BEHAVIOUR, INITIALISER_INJECTION_MODE};

   public static MixinEnvironment$Option[] values() {
      return (MixinEnvironment$Option[])$VALUES.clone();
   }

   public static MixinEnvironment$Option valueOf(String name) {
      return (MixinEnvironment$Option)Enum.valueOf(MixinEnvironment$Option.class, name);
   }

   private MixinEnvironment$Option(String var1, int var2, String property) {
      this(var1, var2, (MixinEnvironment$Option)null, property, true);
   }

   private MixinEnvironment$Option(String var1, int var2, MixinEnvironment$Option$Inherit inheritance, String property) {
      this(var1, var2, (MixinEnvironment$Option)null, inheritance, property, true);
   }

   private MixinEnvironment$Option(String var1, int var2, String property, boolean flag) {
      this(var1, var2, (MixinEnvironment$Option)null, property, flag);
   }

   private MixinEnvironment$Option(String var1, int var2, String property, String defaultStringValue) {
      this(var1, var2, (MixinEnvironment$Option)null, MixinEnvironment$Option$Inherit.INDEPENDENT, property, false, defaultStringValue);
   }

   private MixinEnvironment$Option(String var1, int var2, MixinEnvironment$Option parent, String property) {
      this(var1, var2, parent, MixinEnvironment$Option$Inherit.INHERIT, property, true);
   }

   private MixinEnvironment$Option(String var1, int var2, MixinEnvironment$Option parent, MixinEnvironment$Option$Inherit inheritance, String property) {
      this(var1, var2, parent, inheritance, property, true);
   }

   private MixinEnvironment$Option(String var1, int var2, MixinEnvironment$Option parent, String property, boolean isFlag) {
      this(var1, var2, parent, MixinEnvironment$Option$Inherit.INHERIT, property, isFlag, (String)null);
   }

   private MixinEnvironment$Option(String var1, int var2, MixinEnvironment$Option parent, MixinEnvironment$Option$Inherit inheritance, String property, boolean isFlag) {
      this(var1, var2, parent, inheritance, property, isFlag, (String)null);
   }

   private MixinEnvironment$Option(String var1, int var2, MixinEnvironment$Option parent, String property, String defaultStringValue) {
      this(var1, var2, parent, MixinEnvironment$Option$Inherit.INHERIT, property, false, defaultStringValue);
   }

   private MixinEnvironment$Option(String var1, int var2, MixinEnvironment$Option parent, MixinEnvironment$Option$Inherit inheritance, String property, String defaultStringValue) {
      this(var1, var2, parent, inheritance, property, false, defaultStringValue);
   }

   private MixinEnvironment$Option(String var1, int var2, MixinEnvironment$Option parent, MixinEnvironment$Option$Inherit inheritance, String property, boolean isFlag, String defaultStringValue) {
      super(var1, var2);
      this.parent = parent;
      this.inheritance = inheritance;
      this.property = (parent != null ? parent.property : "mixin") + "." + property;
      this.defaultValue = defaultStringValue;
      this.isFlag = isFlag;

      int depth;
      for(depth = 0; parent != null; ++depth) {
         parent = parent.parent;
      }

      this.depth = depth;
   }

   MixinEnvironment$Option getParent() {
      return this.parent;
   }

   String getProperty() {
      return this.property;
   }

   public String toString() {
      return this.isFlag ? String.valueOf(this.getBooleanValue()) : this.getStringValue();
   }

   private boolean getLocalBooleanValue(boolean defaultValue) {
      return Boolean.parseBoolean(System.getProperty(this.property, Boolean.toString(defaultValue)));
   }

   private boolean getInheritedBooleanValue() {
      return this.parent != null && this.parent.getBooleanValue();
   }

   final boolean getBooleanValue() {
      if (this.inheritance == MixinEnvironment$Option$Inherit.ALWAYS_FALSE) {
         return false;
      } else {
         boolean local = this.getLocalBooleanValue(false);
         if (this.inheritance == MixinEnvironment$Option$Inherit.INDEPENDENT) {
            return local;
         } else {
            boolean inherited = local || this.getInheritedBooleanValue();
            return this.inheritance == MixinEnvironment$Option$Inherit.INHERIT ? inherited : this.getLocalBooleanValue(inherited);
         }
      }
   }

   final String getStringValue() {
      return this.inheritance != MixinEnvironment$Option$Inherit.INDEPENDENT && this.parent != null && !this.parent.getBooleanValue() ? this.defaultValue : System.getProperty(this.property, this.defaultValue);
   }

   Enum getEnumValue(Enum defaultValue) {
      String value = System.getProperty(this.property, defaultValue.name());

      Enum var10000;
      try {
         var10000 = Enum.valueOf(defaultValue.getClass(), value.toUpperCase());
      } catch (IllegalArgumentException var4) {
         return defaultValue;
      }

      return var10000;
   }
}

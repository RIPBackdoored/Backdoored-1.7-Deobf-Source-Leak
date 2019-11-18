package org.spongepowered.asm.mixin;

public final class Interface$Remap extends Enum {
   public static final Interface$Remap ALL = new Interface$Remap("ALL", 0);
   public static final Interface$Remap FORCE = new Interface$Remap("FORCE", 1, true);
   public static final Interface$Remap ONLY_PREFIXED = new Interface$Remap("ONLY_PREFIXED", 2);
   public static final Interface$Remap NONE = new Interface$Remap("NONE", 3);
   private final boolean forceRemap;
   // $FF: synthetic field
   private static final Interface$Remap[] $VALUES = new Interface$Remap[]{ALL, FORCE, ONLY_PREFIXED, NONE};

   public static Interface$Remap[] values() {
      return (Interface$Remap[])$VALUES.clone();
   }

   public static Interface$Remap valueOf(String name) {
      return (Interface$Remap)Enum.valueOf(Interface$Remap.class, name);
   }

   private Interface$Remap(String var1, int var2) {
      this(var1, var2, false);
   }

   private Interface$Remap(String var1, int var2, boolean forceRemap) {
      super(var1, var2);
      this.forceRemap = forceRemap;
   }

   public boolean forceRemap() {
      return this.forceRemap;
   }
}

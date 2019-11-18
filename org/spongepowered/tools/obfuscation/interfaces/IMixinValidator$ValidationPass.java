package org.spongepowered.tools.obfuscation.interfaces;

public final class IMixinValidator$ValidationPass extends Enum {
   public static final IMixinValidator$ValidationPass EARLY = new IMixinValidator$ValidationPass("EARLY", 0);
   public static final IMixinValidator$ValidationPass LATE = new IMixinValidator$ValidationPass("LATE", 1);
   public static final IMixinValidator$ValidationPass FINAL = new IMixinValidator$ValidationPass("FINAL", 2);
   // $FF: synthetic field
   private static final IMixinValidator$ValidationPass[] $VALUES = new IMixinValidator$ValidationPass[]{EARLY, LATE, FINAL};

   public static IMixinValidator$ValidationPass[] values() {
      return (IMixinValidator$ValidationPass[])$VALUES.clone();
   }

   public static IMixinValidator$ValidationPass valueOf(String name) {
      return (IMixinValidator$ValidationPass)Enum.valueOf(IMixinValidator$ValidationPass.class, name);
   }

   private IMixinValidator$ValidationPass(String var1, int var2) {
      super(var1, var2);
   }
}

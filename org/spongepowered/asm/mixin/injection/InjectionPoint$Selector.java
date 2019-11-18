package org.spongepowered.asm.mixin.injection;

public final class InjectionPoint$Selector extends Enum {
   public static final InjectionPoint$Selector FIRST = new InjectionPoint$Selector("FIRST", 0);
   public static final InjectionPoint$Selector LAST = new InjectionPoint$Selector("LAST", 1);
   public static final InjectionPoint$Selector ONE = new InjectionPoint$Selector("ONE", 2);
   public static final InjectionPoint$Selector DEFAULT = FIRST;
   // $FF: synthetic field
   private static final InjectionPoint$Selector[] $VALUES = new InjectionPoint$Selector[]{FIRST, LAST, ONE};

   public static InjectionPoint$Selector[] values() {
      return (InjectionPoint$Selector[])$VALUES.clone();
   }

   public static InjectionPoint$Selector valueOf(String name) {
      return (InjectionPoint$Selector)Enum.valueOf(InjectionPoint$Selector.class, name);
   }

   private InjectionPoint$Selector(String var1, int var2) {
      super(var1, var2);
   }
}

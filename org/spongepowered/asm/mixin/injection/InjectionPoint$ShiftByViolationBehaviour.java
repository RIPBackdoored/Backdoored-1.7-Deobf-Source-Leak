package org.spongepowered.asm.mixin.injection;

final class InjectionPoint$ShiftByViolationBehaviour extends Enum {
   public static final InjectionPoint$ShiftByViolationBehaviour IGNORE = new InjectionPoint$ShiftByViolationBehaviour("IGNORE", 0);
   public static final InjectionPoint$ShiftByViolationBehaviour WARN = new InjectionPoint$ShiftByViolationBehaviour("WARN", 1);
   public static final InjectionPoint$ShiftByViolationBehaviour ERROR = new InjectionPoint$ShiftByViolationBehaviour("ERROR", 2);
   // $FF: synthetic field
   private static final InjectionPoint$ShiftByViolationBehaviour[] $VALUES = new InjectionPoint$ShiftByViolationBehaviour[]{IGNORE, WARN, ERROR};

   public static InjectionPoint$ShiftByViolationBehaviour[] values() {
      return (InjectionPoint$ShiftByViolationBehaviour[])$VALUES.clone();
   }

   public static InjectionPoint$ShiftByViolationBehaviour valueOf(String name) {
      return (InjectionPoint$ShiftByViolationBehaviour)Enum.valueOf(InjectionPoint$ShiftByViolationBehaviour.class, name);
   }

   private InjectionPoint$ShiftByViolationBehaviour(String var1, int var2) {
      super(var1, var2);
   }
}

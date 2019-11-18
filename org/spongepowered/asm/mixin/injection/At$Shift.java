package org.spongepowered.asm.mixin.injection;

public final class At$Shift extends Enum {
   public static final At$Shift NONE = new At$Shift("NONE", 0);
   public static final At$Shift BEFORE = new At$Shift("BEFORE", 1);
   public static final At$Shift AFTER = new At$Shift("AFTER", 2);
   public static final At$Shift BY = new At$Shift("BY", 3);
   // $FF: synthetic field
   private static final At$Shift[] $VALUES = new At$Shift[]{NONE, BEFORE, AFTER, BY};

   public static At$Shift[] values() {
      return (At$Shift[])$VALUES.clone();
   }

   public static At$Shift valueOf(String name) {
      return (At$Shift)Enum.valueOf(At$Shift.class, name);
   }

   private At$Shift(String var1, int var2) {
      super(var1, var2);
   }
}

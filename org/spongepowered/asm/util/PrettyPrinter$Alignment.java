package org.spongepowered.asm.util;

public final class PrettyPrinter$Alignment extends Enum {
   public static final PrettyPrinter$Alignment LEFT = new PrettyPrinter$Alignment("LEFT", 0);
   public static final PrettyPrinter$Alignment RIGHT = new PrettyPrinter$Alignment("RIGHT", 1);
   // $FF: synthetic field
   private static final PrettyPrinter$Alignment[] $VALUES = new PrettyPrinter$Alignment[]{LEFT, RIGHT};

   public static PrettyPrinter$Alignment[] values() {
      return (PrettyPrinter$Alignment[])$VALUES.clone();
   }

   public static PrettyPrinter$Alignment valueOf(String name) {
      return (PrettyPrinter$Alignment)Enum.valueOf(PrettyPrinter$Alignment.class, name);
   }

   private PrettyPrinter$Alignment(String var1, int var2) {
      super(var1, var2);
   }
}

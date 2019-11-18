package org.spongepowered.asm.util;

public final class Bytecode$Visibility extends Enum {
   public static final Bytecode$Visibility PRIVATE = new Bytecode$Visibility("PRIVATE", 0, 2);
   public static final Bytecode$Visibility PROTECTED = new Bytecode$Visibility("PROTECTED", 1, 4);
   public static final Bytecode$Visibility PACKAGE = new Bytecode$Visibility("PACKAGE", 2, 0);
   public static final Bytecode$Visibility PUBLIC = new Bytecode$Visibility("PUBLIC", 3, 1);
   static final int MASK = 7;
   final int access;
   // $FF: synthetic field
   private static final Bytecode$Visibility[] $VALUES = new Bytecode$Visibility[]{PRIVATE, PROTECTED, PACKAGE, PUBLIC};

   public static Bytecode$Visibility[] values() {
      return (Bytecode$Visibility[])$VALUES.clone();
   }

   public static Bytecode$Visibility valueOf(String name) {
      return (Bytecode$Visibility)Enum.valueOf(Bytecode$Visibility.class, name);
   }

   private Bytecode$Visibility(String var1, int var2, int access) {
      super(var1, var2);
      this.access = access;
   }
}

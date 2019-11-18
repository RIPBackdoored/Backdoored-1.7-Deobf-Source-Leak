package org.spongepowered.tools.obfuscation.mirror;

public final class Visibility extends Enum {
   public static final Visibility PRIVATE = new Visibility("PRIVATE", 0);
   public static final Visibility PROTECTED = new Visibility("PROTECTED", 1);
   public static final Visibility PACKAGE = new Visibility("PACKAGE", 2);
   public static final Visibility PUBLIC = new Visibility("PUBLIC", 3);
   // $FF: synthetic field
   private static final Visibility[] $VALUES = new Visibility[]{PRIVATE, PROTECTED, PACKAGE, PUBLIC};

   public static Visibility[] values() {
      return (Visibility[])$VALUES.clone();
   }

   public static Visibility valueOf(String name) {
      return (Visibility)Enum.valueOf(Visibility.class, name);
   }

   private Visibility(String var1, int var2) {
      super(var1, var2);
   }
}

package org.spongepowered.asm.obfuscation.mapping;

public final class IMapping$Type extends Enum {
   public static final IMapping$Type FIELD = new IMapping$Type("FIELD", 0);
   public static final IMapping$Type METHOD = new IMapping$Type("METHOD", 1);
   public static final IMapping$Type CLASS = new IMapping$Type("CLASS", 2);
   public static final IMapping$Type PACKAGE = new IMapping$Type("PACKAGE", 3);
   // $FF: synthetic field
   private static final IMapping$Type[] $VALUES = new IMapping$Type[]{FIELD, METHOD, CLASS, PACKAGE};

   public static IMapping$Type[] values() {
      return (IMapping$Type[])$VALUES.clone();
   }

   public static IMapping$Type valueOf(String name) {
      return (IMapping$Type)Enum.valueOf(IMapping$Type.class, name);
   }

   private IMapping$Type(String var1, int var2) {
      super(var1, var2);
   }
}

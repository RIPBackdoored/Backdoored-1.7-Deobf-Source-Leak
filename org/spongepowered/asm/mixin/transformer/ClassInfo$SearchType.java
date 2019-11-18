package org.spongepowered.asm.mixin.transformer;

public final class ClassInfo$SearchType extends Enum {
   public static final ClassInfo$SearchType ALL_CLASSES = new ClassInfo$SearchType("ALL_CLASSES", 0);
   public static final ClassInfo$SearchType SUPER_CLASSES_ONLY = new ClassInfo$SearchType("SUPER_CLASSES_ONLY", 1);
   // $FF: synthetic field
   private static final ClassInfo$SearchType[] $VALUES = new ClassInfo$SearchType[]{ALL_CLASSES, SUPER_CLASSES_ONLY};

   public static ClassInfo$SearchType[] values() {
      return (ClassInfo$SearchType[])$VALUES.clone();
   }

   public static ClassInfo$SearchType valueOf(String name) {
      return (ClassInfo$SearchType)Enum.valueOf(ClassInfo$SearchType.class, name);
   }

   private ClassInfo$SearchType(String var1, int var2) {
      super(var1, var2);
   }
}

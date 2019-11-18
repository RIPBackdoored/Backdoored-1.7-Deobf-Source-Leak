package org.spongepowered.asm.mixin.transformer;

final class ClassInfo$Member$Type extends Enum {
   public static final ClassInfo$Member$Type METHOD = new ClassInfo$Member$Type("METHOD", 0);
   public static final ClassInfo$Member$Type FIELD = new ClassInfo$Member$Type("FIELD", 1);
   // $FF: synthetic field
   private static final ClassInfo$Member$Type[] $VALUES = new ClassInfo$Member$Type[]{METHOD, FIELD};

   public static ClassInfo$Member$Type[] values() {
      return (ClassInfo$Member$Type[])$VALUES.clone();
   }

   public static ClassInfo$Member$Type valueOf(String name) {
      return (ClassInfo$Member$Type)Enum.valueOf(ClassInfo$Member$Type.class, name);
   }

   private ClassInfo$Member$Type(String var1, int var2) {
      super(var1, var2);
   }
}

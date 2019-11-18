package org.spongepowered.asm.mixin.transformer;

public final class ClassInfo$Traversal extends Enum {
   public static final ClassInfo$Traversal NONE = new ClassInfo$Traversal("NONE", 0, (ClassInfo$Traversal)null, false, ClassInfo$SearchType.SUPER_CLASSES_ONLY);
   public static final ClassInfo$Traversal ALL = new ClassInfo$Traversal("ALL", 1, (ClassInfo$Traversal)null, true, ClassInfo$SearchType.ALL_CLASSES);
   public static final ClassInfo$Traversal IMMEDIATE = new ClassInfo$Traversal("IMMEDIATE", 2, NONE, true, ClassInfo$SearchType.SUPER_CLASSES_ONLY);
   public static final ClassInfo$Traversal SUPER = new ClassInfo$Traversal("SUPER", 3, ALL, false, ClassInfo$SearchType.SUPER_CLASSES_ONLY);
   private final ClassInfo$Traversal next;
   private final boolean traverse;
   private final ClassInfo$SearchType searchType;
   // $FF: synthetic field
   private static final ClassInfo$Traversal[] $VALUES = new ClassInfo$Traversal[]{NONE, ALL, IMMEDIATE, SUPER};

   public static ClassInfo$Traversal[] values() {
      return (ClassInfo$Traversal[])$VALUES.clone();
   }

   public static ClassInfo$Traversal valueOf(String name) {
      return (ClassInfo$Traversal)Enum.valueOf(ClassInfo$Traversal.class, name);
   }

   private ClassInfo$Traversal(String var1, int var2, ClassInfo$Traversal next, boolean traverse, ClassInfo$SearchType searchType) {
      super(var1, var2);
      this.next = next != null ? next : this;
      this.traverse = traverse;
      this.searchType = searchType;
   }

   public ClassInfo$Traversal next() {
      return this.next;
   }

   public boolean canTraverse() {
      return this.traverse;
   }

   public ClassInfo$SearchType getSearchType() {
      return this.searchType;
   }
}

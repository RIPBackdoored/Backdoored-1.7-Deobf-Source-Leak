package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.util.Annotations;

class ClassInfo$Field extends ClassInfo$Member {
   // $FF: synthetic field
   final ClassInfo this$0;

   public ClassInfo$Field(ClassInfo this$0, ClassInfo$Member member) {
      super(member);
      this.this$0 = this$0;
   }

   public ClassInfo$Field(ClassInfo this$0, FieldNode field) {
      this(this$0, field, false);
   }

   public ClassInfo$Field(ClassInfo this$0, FieldNode field, boolean injected) {
      super(ClassInfo$Member$Type.FIELD, field.name, field.desc, field.access, injected);
      this.this$0 = this$0;
      this.setUnique(Annotations.getVisible(field, Unique.class) != null);
      if (Annotations.getVisible(field, Shadow.class) != null) {
         boolean decoratedFinal = Annotations.getVisible(field, Final.class) != null;
         boolean decoratedMutable = Annotations.getVisible(field, Mutable.class) != null;
         this.setDecoratedFinal(decoratedFinal, decoratedMutable);
      }

   }

   public ClassInfo$Field(ClassInfo this$0, String name, String desc, int access) {
      super(ClassInfo$Member$Type.FIELD, name, desc, access, false);
      this.this$0 = this$0;
   }

   public ClassInfo$Field(ClassInfo this$0, String name, String desc, int access, boolean injected) {
      super(ClassInfo$Member$Type.FIELD, name, desc, access, injected);
      this.this$0 = this$0;
   }

   public ClassInfo getOwner() {
      return this.this$0;
   }

   public boolean equals(Object obj) {
      return !(obj instanceof ClassInfo$Field) ? false : super.equals(obj);
   }

   protected String getDisplayFormat() {
      return "%s:%s";
   }
}

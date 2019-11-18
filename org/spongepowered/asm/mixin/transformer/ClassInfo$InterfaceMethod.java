package org.spongepowered.asm.mixin.transformer;

public class ClassInfo$InterfaceMethod extends ClassInfo$Method {
   private final ClassInfo owner;
   // $FF: synthetic field
   final ClassInfo this$0;

   public ClassInfo$InterfaceMethod(ClassInfo this$0, ClassInfo$Member member) {
      super(this$0, member);
      this.this$0 = this$0;
      this.owner = member.getOwner();
   }

   public ClassInfo getOwner() {
      return this.owner;
   }

   public ClassInfo getImplementor() {
      return this.this$0;
   }
}

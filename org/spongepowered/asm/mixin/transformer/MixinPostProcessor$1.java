package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.MethodVisitor;

class MixinPostProcessor$1 extends ClassVisitor {
   // $FF: synthetic field
   final MixinPostProcessor this$0;

   MixinPostProcessor$1(MixinPostProcessor this$0, int x0, ClassVisitor x1) {
      super(x0, x1);
      this.this$0 = this$0;
   }

   public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
      super.visit(version, access | 1, name, signature, superName, interfaces);
   }

   public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
      if ((access & 6) == 0) {
         access |= 1;
      }

      return super.visitField(access, name, desc, signature, value);
   }

   public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
      if ((access & 6) == 0) {
         access |= 1;
      }

      return super.visitMethod(access, name, desc, signature, exceptions);
   }
}

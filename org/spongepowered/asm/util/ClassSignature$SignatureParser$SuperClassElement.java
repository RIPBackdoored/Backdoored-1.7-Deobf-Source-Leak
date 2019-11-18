package org.spongepowered.asm.util;

class ClassSignature$SignatureParser$SuperClassElement extends ClassSignature$SignatureParser$TokenElement {
   // $FF: synthetic field
   final ClassSignature$SignatureParser this$1;

   ClassSignature$SignatureParser$SuperClassElement(ClassSignature$SignatureParser this$1) {
      super(this$1);
      this.this$1 = this$1;
   }

   public void visitEnd() {
      this.this$1.this$0.setSuperClass(this.token);
   }
}

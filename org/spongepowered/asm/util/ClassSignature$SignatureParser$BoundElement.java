package org.spongepowered.asm.util;

import org.spongepowered.asm.lib.signature.SignatureVisitor;

class ClassSignature$SignatureParser$BoundElement extends ClassSignature$SignatureParser$TokenElement {
   private final ClassSignature$SignatureParser$TokenElement type;
   private final boolean classBound;
   // $FF: synthetic field
   final ClassSignature$SignatureParser this$1;

   ClassSignature$SignatureParser$BoundElement(ClassSignature$SignatureParser this$1, ClassSignature$SignatureParser$TokenElement type, boolean classBound) {
      super(this$1);
      this.this$1 = this$1;
      this.type = type;
      this.classBound = classBound;
   }

   public void visitClassType(String name) {
      this.token = this.type.token.addBound(name, this.classBound);
   }

   public void visitTypeArgument() {
      this.token.addTypeArgument('*');
   }

   public SignatureVisitor visitTypeArgument(char wildcard) {
      return new ClassSignature$SignatureParser$TypeArgElement(this.this$1, this, wildcard);
   }
}

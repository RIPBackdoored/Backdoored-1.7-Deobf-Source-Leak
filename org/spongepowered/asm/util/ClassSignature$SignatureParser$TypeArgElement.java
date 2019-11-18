package org.spongepowered.asm.util;

import org.spongepowered.asm.lib.signature.SignatureVisitor;

class ClassSignature$SignatureParser$TypeArgElement extends ClassSignature$SignatureParser$TokenElement {
   private final ClassSignature$SignatureParser$TokenElement type;
   private final char wildcard;
   // $FF: synthetic field
   final ClassSignature$SignatureParser this$1;

   ClassSignature$SignatureParser$TypeArgElement(ClassSignature$SignatureParser this$1, ClassSignature$SignatureParser$TokenElement type, char wildcard) {
      super(this$1);
      this.this$1 = this$1;
      this.type = type;
      this.wildcard = wildcard;
   }

   public SignatureVisitor visitArrayType() {
      this.type.setArray();
      return this;
   }

   public void visitBaseType(char descriptor) {
      this.token = this.type.addTypeArgument(descriptor).asToken();
   }

   public void visitTypeVariable(String name) {
      ClassSignature$TokenHandle token = this.this$1.this$0.getType(name);
      this.token = this.type.addTypeArgument(token).setWildcard(this.wildcard).asToken();
   }

   public void visitClassType(String name) {
      this.token = this.type.addTypeArgument(name).setWildcard(this.wildcard).asToken();
   }

   public void visitTypeArgument() {
      this.token.addTypeArgument('*');
   }

   public SignatureVisitor visitTypeArgument(char wildcard) {
      return new ClassSignature$SignatureParser$TypeArgElement(this.this$1, this, wildcard);
   }

   public void visitEnd() {
   }
}

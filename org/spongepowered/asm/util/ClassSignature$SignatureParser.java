package org.spongepowered.asm.util;

import org.spongepowered.asm.lib.signature.SignatureVisitor;

class ClassSignature$SignatureParser extends SignatureVisitor {
   private ClassSignature$SignatureParser$FormalParamElement param;
   // $FF: synthetic field
   final ClassSignature this$0;

   ClassSignature$SignatureParser(ClassSignature this$0) {
      super(327680);
      this.this$0 = this$0;
   }

   public void visitFormalTypeParameter(String name) {
      this.param = new ClassSignature$SignatureParser$FormalParamElement(this, name);
   }

   public SignatureVisitor visitClassBound() {
      return this.param.visitClassBound();
   }

   public SignatureVisitor visitInterfaceBound() {
      return this.param.visitInterfaceBound();
   }

   public SignatureVisitor visitSuperclass() {
      return new ClassSignature$SignatureParser$SuperClassElement(this);
   }

   public SignatureVisitor visitInterface() {
      return new ClassSignature$SignatureParser$InterfaceElement(this);
   }
}

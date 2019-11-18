package org.spongepowered.asm.util;

import org.spongepowered.asm.lib.signature.SignatureVisitor;

abstract class ClassSignature$SignatureParser$TokenElement extends ClassSignature$SignatureParser$SignatureElement {
   protected ClassSignature$Token token;
   private boolean array;
   // $FF: synthetic field
   final ClassSignature$SignatureParser this$1;

   ClassSignature$SignatureParser$TokenElement(ClassSignature$SignatureParser this$1) {
      super(this$1);
      this.this$1 = this$1;
   }

   public ClassSignature$Token getToken() {
      if (this.token == null) {
         this.token = new ClassSignature$Token();
      }

      return this.token;
   }

   protected void setArray() {
      this.array = true;
   }

   private boolean getArray() {
      boolean array = this.array;
      this.array = false;
      return array;
   }

   public void visitClassType(String name) {
      this.getToken().setType(name);
   }

   public SignatureVisitor visitClassBound() {
      this.getToken();
      return new ClassSignature$SignatureParser$BoundElement(this.this$1, this, true);
   }

   public SignatureVisitor visitInterfaceBound() {
      this.getToken();
      return new ClassSignature$SignatureParser$BoundElement(this.this$1, this, false);
   }

   public void visitInnerClassType(String name) {
      this.token.addInnerClass(name);
   }

   public SignatureVisitor visitArrayType() {
      this.setArray();
      return this;
   }

   public SignatureVisitor visitTypeArgument(char wildcard) {
      return new ClassSignature$SignatureParser$TypeArgElement(this.this$1, this, wildcard);
   }

   ClassSignature$Token addTypeArgument() {
      return this.token.addTypeArgument('*').asToken();
   }

   ClassSignature$IToken addTypeArgument(char symbol) {
      return this.token.addTypeArgument(symbol).setArray(this.getArray());
   }

   ClassSignature$IToken addTypeArgument(String name) {
      return this.token.addTypeArgument(name).setArray(this.getArray());
   }

   ClassSignature$IToken addTypeArgument(ClassSignature$Token token) {
      return this.token.addTypeArgument(token).setArray(this.getArray());
   }

   ClassSignature$IToken addTypeArgument(ClassSignature$TokenHandle token) {
      return this.token.addTypeArgument(token).setArray(this.getArray());
   }
}

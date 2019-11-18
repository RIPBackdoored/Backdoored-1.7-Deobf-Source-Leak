package org.spongepowered.asm.util;

class ClassSignature$SignatureParser$FormalParamElement extends ClassSignature$SignatureParser$TokenElement {
   private final ClassSignature$TokenHandle handle;
   // $FF: synthetic field
   final ClassSignature$SignatureParser this$1;

   ClassSignature$SignatureParser$FormalParamElement(ClassSignature$SignatureParser this$1, String param) {
      super(this$1);
      this.this$1 = this$1;
      this.handle = this$1.this$0.getType(param);
      this.token = this.handle.asToken();
   }
}

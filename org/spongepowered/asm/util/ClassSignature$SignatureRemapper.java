package org.spongepowered.asm.util;

import java.util.HashSet;
import java.util.Set;
import org.spongepowered.asm.lib.signature.SignatureWriter;

class ClassSignature$SignatureRemapper extends SignatureWriter {
   private final Set localTypeVars;
   // $FF: synthetic field
   final ClassSignature this$0;

   ClassSignature$SignatureRemapper(ClassSignature this$0) {
      this.this$0 = this$0;
      this.localTypeVars = new HashSet();
   }

   public void visitFormalTypeParameter(String name) {
      this.localTypeVars.add(name);
      super.visitFormalTypeParameter(name);
   }

   public void visitTypeVariable(String name) {
      if (!this.localTypeVars.contains(name)) {
         ClassSignature$TypeVar typeVar = this.this$0.getTypeVar(name);
         if (typeVar != null) {
            super.visitTypeVariable(typeVar.toString());
            return;
         }
      }

      super.visitTypeVariable(name);
   }
}

package javassist.compiler;

import javassist.bytecode.Bytecode;

class CodeGen$1 extends CodeGen$ReturnHook {
   // $FF: synthetic field
   final int val$var;
   // $FF: synthetic field
   final CodeGen this$0;

   CodeGen$1(CodeGen this$0, CodeGen gen, int var3) {
      super(gen);
      this.this$0 = this$0;
      this.val$var = var3;
   }

   protected boolean doit(Bytecode b, int opcode) {
      b.addAload(this.val$var);
      b.addOpcode(195);
      return false;
   }
}

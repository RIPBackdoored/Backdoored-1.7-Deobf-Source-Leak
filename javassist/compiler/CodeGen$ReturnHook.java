package javassist.compiler;

import javassist.bytecode.Bytecode;

public abstract class CodeGen$ReturnHook {
   CodeGen$ReturnHook next;

   protected abstract boolean doit(Bytecode var1, int var2);

   protected CodeGen$ReturnHook(CodeGen gen) {
      this.next = gen.returnHooks;
      gen.returnHooks = this;
   }

   protected void remove(CodeGen gen) {
      gen.returnHooks = this.next;
   }
}

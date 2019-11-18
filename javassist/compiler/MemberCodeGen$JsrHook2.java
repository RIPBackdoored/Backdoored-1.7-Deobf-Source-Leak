package javassist.compiler;

import javassist.bytecode.Bytecode;

class MemberCodeGen$JsrHook2 extends CodeGen$ReturnHook {
   int var;
   int target;

   MemberCodeGen$JsrHook2(CodeGen gen, int[] retTarget) {
      super(gen);
      this.target = retTarget[0];
      this.var = retTarget[1];
   }

   protected boolean doit(Bytecode b, int opcode) {
      switch(opcode) {
      case 172:
         b.addIstore(this.var);
         break;
      case 173:
         b.addLstore(this.var);
         break;
      case 174:
         b.addFstore(this.var);
         break;
      case 175:
         b.addDstore(this.var);
         break;
      case 176:
         b.addAstore(this.var);
      case 177:
         break;
      default:
         throw new RuntimeException("fatal");
      }

      b.addOpcode(167);
      b.addIndex(this.target - b.currentPc() + 3);
      return true;
   }
}

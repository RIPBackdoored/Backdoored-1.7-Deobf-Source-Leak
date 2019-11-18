package javassist.compiler;

import java.util.ArrayList;
import javassist.bytecode.Bytecode;

class MemberCodeGen$JsrHook extends CodeGen$ReturnHook {
   ArrayList jsrList = new ArrayList();
   CodeGen cgen;
   int var;

   MemberCodeGen$JsrHook(CodeGen gen) {
      super(gen);
      this.cgen = gen;
      this.var = -1;
   }

   private int getVar(int size) {
      if (this.var < 0) {
         this.var = this.cgen.getMaxLocals();
         this.cgen.incMaxLocals(size);
      }

      return this.var;
   }

   private void jsrJmp(Bytecode b) {
      b.addOpcode(167);
      this.jsrList.add(new int[]{b.currentPc(), this.var});
      b.addIndex(0);
   }

   protected boolean doit(Bytecode b, int opcode) {
      switch(opcode) {
      case 172:
         b.addIstore(this.getVar(1));
         this.jsrJmp(b);
         b.addIload(this.var);
         break;
      case 173:
         b.addLstore(this.getVar(2));
         this.jsrJmp(b);
         b.addLload(this.var);
         break;
      case 174:
         b.addFstore(this.getVar(1));
         this.jsrJmp(b);
         b.addFload(this.var);
         break;
      case 175:
         b.addDstore(this.getVar(2));
         this.jsrJmp(b);
         b.addDload(this.var);
         break;
      case 176:
         b.addAstore(this.getVar(1));
         this.jsrJmp(b);
         b.addAload(this.var);
         break;
      case 177:
         this.jsrJmp(b);
         break;
      default:
         throw new RuntimeException("fatal");
      }

      return false;
   }
}

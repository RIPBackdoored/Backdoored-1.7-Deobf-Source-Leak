package javassist;

import javassist.bytecode.Bytecode;

class CtMethod$IntConstParameter extends CtMethod$ConstParameter {
   int param;

   CtMethod$IntConstParameter(int i) {
      this.param = i;
   }

   int compile(Bytecode code) throws CannotCompileException {
      code.addIconst(this.param);
      return 1;
   }

   String descriptor() {
      return "([Ljava/lang/Object;I)Ljava/lang/Object;";
   }

   String constDescriptor() {
      return "([Ljava/lang/Object;I)V";
   }
}

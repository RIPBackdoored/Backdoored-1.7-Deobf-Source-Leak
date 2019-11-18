package javassist;

import javassist.bytecode.Bytecode;

class CtMethod$LongConstParameter extends CtMethod$ConstParameter {
   long param;

   CtMethod$LongConstParameter(long l) {
      this.param = l;
   }

   int compile(Bytecode code) throws CannotCompileException {
      code.addLconst(this.param);
      return 2;
   }

   String descriptor() {
      return "([Ljava/lang/Object;J)Ljava/lang/Object;";
   }

   String constDescriptor() {
      return "([Ljava/lang/Object;J)V";
   }
}

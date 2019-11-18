package javassist;

import javassist.bytecode.Bytecode;

class CtMethod$StringConstParameter extends CtMethod$ConstParameter {
   String param;

   CtMethod$StringConstParameter(String s) {
      this.param = s;
   }

   int compile(Bytecode code) throws CannotCompileException {
      code.addLdc(this.param);
      return 1;
   }

   String descriptor() {
      return "([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;";
   }

   String constDescriptor() {
      return "([Ljava/lang/Object;Ljava/lang/String;)V";
   }
}

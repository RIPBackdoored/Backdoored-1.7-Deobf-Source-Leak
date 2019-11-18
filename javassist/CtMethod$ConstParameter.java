package javassist;

import javassist.bytecode.Bytecode;

public class CtMethod$ConstParameter {
   public static CtMethod$ConstParameter integer(int i) {
      return new CtMethod$IntConstParameter(i);
   }

   public static CtMethod$ConstParameter integer(long i) {
      return new CtMethod$LongConstParameter(i);
   }

   public static CtMethod$ConstParameter string(String s) {
      return new CtMethod$StringConstParameter(s);
   }

   CtMethod$ConstParameter() {
   }

   int compile(Bytecode code) throws CannotCompileException {
      return 0;
   }

   String descriptor() {
      return defaultDescriptor();
   }

   static String defaultDescriptor() {
      return "([Ljava/lang/Object;)Ljava/lang/Object;";
   }

   String constDescriptor() {
      return defaultConstDescriptor();
   }

   static String defaultConstDescriptor() {
      return "([Ljava/lang/Object;)V";
   }
}

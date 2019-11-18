package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$MethodInitializer extends CtField$NewInitializer {
   String methodName;

   int compile(CtClass type, String name, Bytecode code, CtClass[] parameters, Javac drv) throws CannotCompileException {
      code.addAload(0);
      code.addAload(0);
      int stacksize;
      if (this.stringParams == null) {
         stacksize = 2;
      } else {
         stacksize = this.compileStringParameter(code) + 2;
      }

      if (this.withConstructorParams) {
         stacksize += CtNewWrappedMethod.compileParameterList(code, parameters, 1);
      }

      String typeDesc = Descriptor.of(type);
      String mDesc = this.getDescriptor() + typeDesc;
      code.addInvokestatic(this.objectType, this.methodName, mDesc);
      code.addPutfield(Bytecode.THIS, name, typeDesc);
      return stacksize;
   }

   private String getDescriptor() {
      String desc3 = "(Ljava/lang/Object;[Ljava/lang/String;[Ljava/lang/Object;)";
      if (this.stringParams == null) {
         return this.withConstructorParams ? "(Ljava/lang/Object;[Ljava/lang/Object;)" : "(Ljava/lang/Object;)";
      } else {
         return this.withConstructorParams ? "(Ljava/lang/Object;[Ljava/lang/String;[Ljava/lang/Object;)" : "(Ljava/lang/Object;[Ljava/lang/String;)";
      }
   }

   int compileIfStatic(CtClass type, String name, Bytecode code, Javac drv) throws CannotCompileException {
      int stacksize = 1;
      String desc;
      if (this.stringParams == null) {
         desc = "()";
      } else {
         desc = "([Ljava/lang/String;)";
         stacksize += this.compileStringParameter(code);
      }

      String typeDesc = Descriptor.of(type);
      code.addInvokestatic(this.objectType, this.methodName, desc + typeDesc);
      code.addPutstatic(Bytecode.THIS, name, typeDesc);
      return stacksize;
   }
}

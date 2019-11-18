package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$NewInitializer extends CtField$Initializer {
   CtClass objectType;
   String[] stringParams;
   boolean withConstructorParams;

   int compile(CtClass type, String name, Bytecode code, CtClass[] parameters, Javac drv) throws CannotCompileException {
      code.addAload(0);
      code.addNew(this.objectType);
      code.add(89);
      code.addAload(0);
      int stacksize;
      if (this.stringParams == null) {
         stacksize = 4;
      } else {
         stacksize = this.compileStringParameter(code) + 4;
      }

      if (this.withConstructorParams) {
         stacksize += CtNewWrappedMethod.compileParameterList(code, parameters, 1);
      }

      code.addInvokespecial(this.objectType, "<init>", this.getDescriptor());
      code.addPutfield(Bytecode.THIS, name, Descriptor.of(type));
      return stacksize;
   }

   private String getDescriptor() {
      String desc3 = "(Ljava/lang/Object;[Ljava/lang/String;[Ljava/lang/Object;)V";
      if (this.stringParams == null) {
         return this.withConstructorParams ? "(Ljava/lang/Object;[Ljava/lang/Object;)V" : "(Ljava/lang/Object;)V";
      } else {
         return this.withConstructorParams ? "(Ljava/lang/Object;[Ljava/lang/String;[Ljava/lang/Object;)V" : "(Ljava/lang/Object;[Ljava/lang/String;)V";
      }
   }

   int compileIfStatic(CtClass type, String name, Bytecode code, Javac drv) throws CannotCompileException {
      code.addNew(this.objectType);
      code.add(89);
      int stacksize = 2;
      String desc;
      if (this.stringParams == null) {
         desc = "()V";
      } else {
         desc = "([Ljava/lang/String;)V";
         stacksize += this.compileStringParameter(code);
      }

      code.addInvokespecial(this.objectType, "<init>", desc);
      code.addPutstatic(Bytecode.THIS, name, Descriptor.of(type));
      return stacksize;
   }

   protected final int compileStringParameter(Bytecode code) throws CannotCompileException {
      int nparam = this.stringParams.length;
      code.addIconst(nparam);
      code.addAnewarray("java.lang.String");

      for(int j = 0; j < nparam; ++j) {
         code.add(89);
         code.addIconst(j);
         code.addLdc(this.stringParams[j]);
         code.add(83);
      }

      return 4;
   }
}

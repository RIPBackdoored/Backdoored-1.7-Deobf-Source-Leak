package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$DoubleInitializer extends CtField$Initializer {
   double value;

   CtField$DoubleInitializer(double v) {
      this.value = v;
   }

   void check(String desc) throws CannotCompileException {
      if (!desc.equals("D")) {
         throw new CannotCompileException("type mismatch");
      }
   }

   int compile(CtClass type, String name, Bytecode code, CtClass[] parameters, Javac drv) throws CannotCompileException {
      code.addAload(0);
      code.addLdc2w(this.value);
      code.addPutfield(Bytecode.THIS, name, Descriptor.of(type));
      return 3;
   }

   int compileIfStatic(CtClass type, String name, Bytecode code, Javac drv) throws CannotCompileException {
      code.addLdc2w(this.value);
      code.addPutstatic(Bytecode.THIS, name, Descriptor.of(type));
      return 2;
   }

   int getConstantValue(ConstPool cp, CtClass type) {
      return type == CtClass.doubleType ? cp.addDoubleInfo(this.value) : 0;
   }
}

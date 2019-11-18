package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$StringInitializer extends CtField$Initializer {
   String value;

   CtField$StringInitializer(String v) {
      this.value = v;
   }

   int compile(CtClass type, String name, Bytecode code, CtClass[] parameters, Javac drv) throws CannotCompileException {
      code.addAload(0);
      code.addLdc(this.value);
      code.addPutfield(Bytecode.THIS, name, Descriptor.of(type));
      return 2;
   }

   int compileIfStatic(CtClass type, String name, Bytecode code, Javac drv) throws CannotCompileException {
      code.addLdc(this.value);
      code.addPutstatic(Bytecode.THIS, name, Descriptor.of(type));
      return 1;
   }

   int getConstantValue(ConstPool cp, CtClass type) {
      return type.getName().equals("java.lang.String") ? cp.addStringInfo(this.value) : 0;
   }
}

package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$IntInitializer extends CtField$Initializer {
   int value;

   CtField$IntInitializer(int v) {
      this.value = v;
   }

   void check(String desc) throws CannotCompileException {
      char c = desc.charAt(0);
      if (c != 'I' && c != 'S' && c != 'B' && c != 'C' && c != 'Z') {
         throw new CannotCompileException("type mismatch");
      }
   }

   int compile(CtClass type, String name, Bytecode code, CtClass[] parameters, Javac drv) throws CannotCompileException {
      code.addAload(0);
      code.addIconst(this.value);
      code.addPutfield(Bytecode.THIS, name, Descriptor.of(type));
      return 2;
   }

   int compileIfStatic(CtClass type, String name, Bytecode code, Javac drv) throws CannotCompileException {
      code.addIconst(this.value);
      code.addPutstatic(Bytecode.THIS, name, Descriptor.of(type));
      return 1;
   }

   int getConstantValue(ConstPool cp, CtClass type) {
      return cp.addIntegerInfo(this.value);
   }
}

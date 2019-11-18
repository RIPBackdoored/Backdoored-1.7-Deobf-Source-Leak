package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$MultiArrayInitializer extends CtField$Initializer {
   CtClass type;
   int[] dim;

   CtField$MultiArrayInitializer(CtClass t, int[] d) {
      this.type = t;
      this.dim = d;
   }

   void check(String desc) throws CannotCompileException {
      if (desc.charAt(0) != '[') {
         throw new CannotCompileException("type mismatch");
      }
   }

   int compile(CtClass type, String name, Bytecode code, CtClass[] parameters, Javac drv) throws CannotCompileException {
      code.addAload(0);
      int s = code.addMultiNewarray(type, this.dim);
      code.addPutfield(Bytecode.THIS, name, Descriptor.of(type));
      return s + 1;
   }

   int compileIfStatic(CtClass type, String name, Bytecode code, Javac drv) throws CannotCompileException {
      int s = code.addMultiNewarray(type, this.dim);
      code.addPutstatic(Bytecode.THIS, name, Descriptor.of(type));
      return s;
   }
}

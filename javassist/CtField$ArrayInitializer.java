package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$ArrayInitializer extends CtField$Initializer {
   CtClass type;
   int size;

   CtField$ArrayInitializer(CtClass t, int s) {
      this.type = t;
      this.size = s;
   }

   private void addNewarray(Bytecode code) {
      if (this.type.isPrimitive()) {
         code.addNewarray(((CtPrimitiveType)this.type).getArrayType(), this.size);
      } else {
         code.addAnewarray(this.type, this.size);
      }

   }

   int compile(CtClass type, String name, Bytecode code, CtClass[] parameters, Javac drv) throws CannotCompileException {
      code.addAload(0);
      this.addNewarray(code);
      code.addPutfield(Bytecode.THIS, name, Descriptor.of(type));
      return 2;
   }

   int compileIfStatic(CtClass type, String name, Bytecode code, Javac drv) throws CannotCompileException {
      this.addNewarray(code);
      code.addPutstatic(Bytecode.THIS, name, Descriptor.of(type));
      return 1;
   }
}

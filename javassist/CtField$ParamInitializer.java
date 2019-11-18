package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$ParamInitializer extends CtField$Initializer {
   int nthParam;

   int compile(CtClass type, String name, Bytecode code, CtClass[] parameters, Javac drv) throws CannotCompileException {
      if (parameters != null && this.nthParam < parameters.length) {
         code.addAload(0);
         int nth = nthParamToLocal(this.nthParam, parameters, false);
         int s = code.addLoad(nth, type) + 1;
         code.addPutfield(Bytecode.THIS, name, Descriptor.of(type));
         return s;
      } else {
         return 0;
      }
   }

   static int nthParamToLocal(int nth, CtClass[] params, boolean isStatic) {
      CtClass longType = CtClass.longType;
      CtClass doubleType = CtClass.doubleType;
      int k;
      if (isStatic) {
         k = 0;
      } else {
         k = 1;
      }

      for(int i = 0; i < nth; ++i) {
         CtClass type = params[i];
         if (type != longType && type != doubleType) {
            ++k;
         } else {
            k += 2;
         }
      }

      return k;
   }

   int compileIfStatic(CtClass type, String name, Bytecode code, Javac drv) throws CannotCompileException {
      return 0;
   }
}

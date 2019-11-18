package javassist.compiler;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtField;
import javassist.compiler.ast.ASTree;

public class Javac$CtFieldWithInit extends CtField {
   private ASTree init = null;

   Javac$CtFieldWithInit(CtClass type, String name, CtClass declaring) throws CannotCompileException {
      super(type, name, declaring);
   }

   protected void setInit(ASTree i) {
      this.init = i;
   }

   protected ASTree getInitAST() {
      return this.init;
   }
}

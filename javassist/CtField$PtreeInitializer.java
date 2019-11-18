package javassist;

import javassist.bytecode.ConstPool;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
import javassist.compiler.ast.ASTree;

class CtField$PtreeInitializer extends CtField$CodeInitializer0 {
   private ASTree expression;

   CtField$PtreeInitializer(ASTree expr) {
      this.expression = expr;
   }

   void compileExpr(Javac drv) throws CompileError {
      drv.compileExpr(this.expression);
   }

   int getConstantValue(ConstPool cp, CtClass type) {
      return this.getConstantValue2(cp, type, this.expression);
   }
}

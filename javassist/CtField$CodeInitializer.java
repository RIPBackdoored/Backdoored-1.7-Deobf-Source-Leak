package javassist;

import javassist.bytecode.ConstPool;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
import javassist.compiler.SymbolTable;
import javassist.compiler.ast.ASTree;

class CtField$CodeInitializer extends CtField$CodeInitializer0 {
   private String expression;

   CtField$CodeInitializer(String expr) {
      this.expression = expr;
   }

   void compileExpr(Javac drv) throws CompileError {
      drv.compileExpr(this.expression);
   }

   int getConstantValue(ConstPool cp, CtClass type) {
      int var10000;
      try {
         ASTree t = Javac.parseExpr(this.expression, new SymbolTable());
         var10000 = this.getConstantValue2(cp, type, t);
      } catch (CompileError var4) {
         return 0;
      }

      return var10000;
   }
}

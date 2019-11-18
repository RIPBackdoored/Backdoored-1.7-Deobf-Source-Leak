package javassist.expr;

import javassist.CtClass;
import javassist.bytecode.Bytecode;
import javassist.compiler.CompileError;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class Instanceof$ProceedForInstanceof implements ProceedHandler {
   int index;

   Instanceof$ProceedForInstanceof(int i) {
      this.index = i;
   }

   public void doit(JvstCodeGen gen, Bytecode bytecode, ASTList args) throws CompileError {
      if (gen.getMethodArgsLength(args) != 1) {
         throw new CompileError("$proceed() cannot take more than one parameter for instanceof");
      } else {
         gen.atMethodArgs(args, new int[1], new int[1], new String[1]);
         bytecode.addOpcode(193);
         bytecode.addIndex(this.index);
         gen.setType(CtClass.booleanType);
      }
   }

   public void setReturnType(JvstTypeChecker c, ASTList args) throws CompileError {
      c.atMethodArgs(args, new int[1], new int[1], new String[1]);
      c.setType(CtClass.booleanType);
   }
}

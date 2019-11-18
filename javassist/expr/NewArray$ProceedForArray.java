package javassist.expr;

import javassist.CtClass;
import javassist.bytecode.Bytecode;
import javassist.compiler.CompileError;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class NewArray$ProceedForArray implements ProceedHandler {
   CtClass arrayType;
   int opcode;
   int index;
   int dimension;

   NewArray$ProceedForArray(CtClass type, int op, int i, int dim) {
      this.arrayType = type;
      this.opcode = op;
      this.index = i;
      this.dimension = dim;
   }

   public void doit(JvstCodeGen gen, Bytecode bytecode, ASTList args) throws CompileError {
      int num = gen.getMethodArgsLength(args);
      if (num != this.dimension) {
         throw new CompileError("$proceed() with a wrong number of parameters");
      } else {
         gen.atMethodArgs(args, new int[num], new int[num], new String[num]);
         bytecode.addOpcode(this.opcode);
         if (this.opcode == 189) {
            bytecode.addIndex(this.index);
         } else if (this.opcode == 188) {
            bytecode.add(this.index);
         } else {
            bytecode.addIndex(this.index);
            bytecode.add(this.dimension);
            bytecode.growStack(1 - this.dimension);
         }

         gen.setType(this.arrayType);
      }
   }

   public void setReturnType(JvstTypeChecker c, ASTList args) throws CompileError {
      c.setType(this.arrayType);
   }
}

package javassist.expr;

import javassist.CtClass;
import javassist.CtPrimitiveType;
import javassist.bytecode.Bytecode;
import javassist.compiler.CompileError;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class FieldAccess$ProceedForWrite implements ProceedHandler {
   CtClass fieldType;
   int opcode;
   int targetVar;
   int index;

   FieldAccess$ProceedForWrite(CtClass type, int op, int i, int var) {
      this.fieldType = type;
      this.targetVar = var;
      this.opcode = op;
      this.index = i;
   }

   public void doit(JvstCodeGen gen, Bytecode bytecode, ASTList args) throws CompileError {
      if (gen.getMethodArgsLength(args) != 1) {
         throw new CompileError("$proceed() cannot take more than one parameter for field writing");
      } else {
         byte stack;
         if (FieldAccess.isStatic(this.opcode)) {
            stack = 0;
         } else {
            stack = -1;
            bytecode.addAload(this.targetVar);
         }

         gen.atMethodArgs(args, new int[1], new int[1], new String[1]);
         gen.doNumCast(this.fieldType);
         int stack;
         if (this.fieldType instanceof CtPrimitiveType) {
            stack = stack - ((CtPrimitiveType)this.fieldType).getDataSize();
         } else {
            stack = stack - 1;
         }

         bytecode.add(this.opcode);
         bytecode.addIndex(this.index);
         bytecode.growStack(stack);
         gen.setType(CtClass.voidType);
         gen.addNullIfVoid();
      }
   }

   public void setReturnType(JvstTypeChecker c, ASTList args) throws CompileError {
      c.atMethodArgs(args, new int[1], new int[1], new String[1]);
      c.setType(CtClass.voidType);
      c.addNullIfVoid();
   }
}

package javassist.expr;

import javassist.CtClass;
import javassist.CtPrimitiveType;
import javassist.bytecode.Bytecode;
import javassist.compiler.CompileError;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class FieldAccess$ProceedForRead implements ProceedHandler {
   CtClass fieldType;
   int opcode;
   int targetVar;
   int index;

   FieldAccess$ProceedForRead(CtClass type, int op, int i, int var) {
      this.fieldType = type;
      this.targetVar = var;
      this.opcode = op;
      this.index = i;
   }

   public void doit(JvstCodeGen gen, Bytecode bytecode, ASTList args) throws CompileError {
      if (args != null && !gen.isParamListName(args)) {
         throw new CompileError("$proceed() cannot take a parameter for field reading");
      } else {
         byte stack;
         if (FieldAccess.isStatic(this.opcode)) {
            stack = 0;
         } else {
            stack = -1;
            bytecode.addAload(this.targetVar);
         }

         int stack;
         if (this.fieldType instanceof CtPrimitiveType) {
            stack = stack + ((CtPrimitiveType)this.fieldType).getDataSize();
         } else {
            stack = stack + 1;
         }

         bytecode.add(this.opcode);
         bytecode.addIndex(this.index);
         bytecode.growStack(stack);
         gen.setType(this.fieldType);
      }
   }

   public void setReturnType(JvstTypeChecker c, ASTList args) throws CompileError {
      c.setType(this.fieldType);
   }
}

package javassist.expr;

import javassist.CtClass;
import javassist.bytecode.Bytecode;
import javassist.compiler.CompileError;
import javassist.compiler.JvstCodeGen;
import javassist.compiler.JvstTypeChecker;
import javassist.compiler.MemberResolver$Method;
import javassist.compiler.ProceedHandler;
import javassist.compiler.ast.ASTList;

class NewExpr$ProceedForNew implements ProceedHandler {
   CtClass newType;
   int newIndex;
   int methodIndex;

   NewExpr$ProceedForNew(CtClass nt, int ni, int mi) {
      this.newType = nt;
      this.newIndex = ni;
      this.methodIndex = mi;
   }

   public void doit(JvstCodeGen gen, Bytecode bytecode, ASTList args) throws CompileError {
      bytecode.addOpcode(187);
      bytecode.addIndex(this.newIndex);
      bytecode.addOpcode(89);
      gen.atMethodCallCore(this.newType, "<init>", args, false, true, -1, (MemberResolver$Method)null);
      gen.setType(this.newType);
   }

   public void setReturnType(JvstTypeChecker c, ASTList args) throws CompileError {
      c.atMethodCallCore(this.newType, "<init>", args);
      c.setType(this.newType);
   }
}

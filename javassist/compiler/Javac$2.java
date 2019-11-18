package javassist.compiler;

import javassist.bytecode.Bytecode;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.Symbol;

class Javac$2 implements ProceedHandler {
   // $FF: synthetic field
   final String val$c;
   // $FF: synthetic field
   final String val$m;
   // $FF: synthetic field
   final Javac this$0;

   Javac$2(Javac this$0, String var2, String var3) {
      this.this$0 = this$0;
      this.val$c = var2;
      this.val$m = var3;
   }

   public void doit(JvstCodeGen gen, Bytecode b, ASTList args) throws CompileError {
      Expr expr = Expr.make(35, new Symbol(this.val$c), new Member(this.val$m));
      Expr expr = CallExpr.makeCall(expr, args);
      gen.compileExpr(expr);
      gen.addNullIfVoid();
   }

   public void setReturnType(JvstTypeChecker check, ASTList args) throws CompileError {
      Expr expr = Expr.make(35, new Symbol(this.val$c), new Member(this.val$m));
      Expr expr = CallExpr.makeCall(expr, args);
      expr.accept(check);
      check.addNullIfVoid();
   }
}

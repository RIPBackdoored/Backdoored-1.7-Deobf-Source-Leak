package javassist.compiler;

import javassist.bytecode.Bytecode;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;

class Javac$1 implements ProceedHandler {
   // $FF: synthetic field
   final String val$m;
   // $FF: synthetic field
   final ASTree val$texpr;
   // $FF: synthetic field
   final Javac this$0;

   Javac$1(Javac this$0, String var2, ASTree var3) {
      this.this$0 = this$0;
      this.val$m = var2;
      this.val$texpr = var3;
   }

   public void doit(JvstCodeGen gen, Bytecode b, ASTList args) throws CompileError {
      ASTree expr = new Member(this.val$m);
      if (this.val$texpr != null) {
         expr = Expr.make(46, this.val$texpr, (ASTree)expr);
      }

      ASTree expr = CallExpr.makeCall((ASTree)expr, args);
      gen.compileExpr(expr);
      gen.addNullIfVoid();
   }

   public void setReturnType(JvstTypeChecker check, ASTList args) throws CompileError {
      ASTree expr = new Member(this.val$m);
      if (this.val$texpr != null) {
         expr = Expr.make(46, this.val$texpr, (ASTree)expr);
      }

      ASTree expr = CallExpr.makeCall((ASTree)expr, args);
      expr.accept(check);
      check.addNullIfVoid();
   }
}

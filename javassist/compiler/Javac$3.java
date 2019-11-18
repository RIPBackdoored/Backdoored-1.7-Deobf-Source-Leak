package javassist.compiler;

import javassist.bytecode.Bytecode;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;

class Javac$3 implements ProceedHandler {
   // $FF: synthetic field
   final ASTree val$texpr;
   // $FF: synthetic field
   final int val$methodIndex;
   // $FF: synthetic field
   final String val$descriptor;
   // $FF: synthetic field
   final String val$classname;
   // $FF: synthetic field
   final String val$methodname;
   // $FF: synthetic field
   final Javac this$0;

   Javac$3(Javac this$0, ASTree var2, int var3, String var4, String var5, String var6) {
      this.this$0 = this$0;
      this.val$texpr = var2;
      this.val$methodIndex = var3;
      this.val$descriptor = var4;
      this.val$classname = var5;
      this.val$methodname = var6;
   }

   public void doit(JvstCodeGen gen, Bytecode b, ASTList args) throws CompileError {
      gen.compileInvokeSpecial(this.val$texpr, this.val$methodIndex, this.val$descriptor, args);
   }

   public void setReturnType(JvstTypeChecker c, ASTList args) throws CompileError {
      c.compileInvokeSpecial(this.val$texpr, this.val$classname, this.val$methodname, this.val$descriptor, args);
   }
}

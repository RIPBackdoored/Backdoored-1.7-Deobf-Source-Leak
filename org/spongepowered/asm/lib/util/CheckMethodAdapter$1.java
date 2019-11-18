package org.spongepowered.asm.lib.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.analysis.Analyzer;
import org.spongepowered.asm.lib.tree.analysis.BasicVerifier;

class CheckMethodAdapter$1 extends MethodNode {
   // $FF: synthetic field
   final MethodVisitor val$cmv;

   CheckMethodAdapter$1(int api, int access, String name, String desc, String signature, String[] exceptions, MethodVisitor var7) {
      super(api, access, name, desc, signature, exceptions);
      this.val$cmv = var7;
   }

   public void visitEnd() {
      Analyzer a = new Analyzer(new BasicVerifier());

      try {
         a.analyze("dummy", this);
      } catch (Exception var5) {
         if (var5 instanceof IndexOutOfBoundsException && this.maxLocals == 0 && this.maxStack == 0) {
            throw new RuntimeException("Data flow checking option requires valid, non zero maxLocals and maxStack values.");
         }

         var5.printStackTrace();
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw, true);
         CheckClassAdapter.printAnalyzerResult(this, a, pw);
         pw.close();
         throw new RuntimeException(var5.getMessage() + ' ' + sw.toString());
      }

      this.accept(this.val$cmv);
   }
}

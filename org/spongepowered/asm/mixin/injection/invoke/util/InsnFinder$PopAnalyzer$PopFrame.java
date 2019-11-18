package org.spongepowered.asm.mixin.injection.invoke.util;

import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
import org.spongepowered.asm.lib.tree.analysis.BasicValue;
import org.spongepowered.asm.lib.tree.analysis.Frame;
import org.spongepowered.asm.lib.tree.analysis.Interpreter;
import org.spongepowered.asm.lib.tree.analysis.Value;

class InsnFinder$PopAnalyzer$PopFrame extends Frame {
   private AbstractInsnNode current;
   private InsnFinder$AnalyzerState state;
   private int depth;
   // $FF: synthetic field
   final InsnFinder$PopAnalyzer this$0;

   public InsnFinder$PopAnalyzer$PopFrame(InsnFinder$PopAnalyzer this$0, int locals, int stack) {
      super(locals, stack);
      this.this$0 = this$0;
      this.state = InsnFinder$AnalyzerState.SEARCH;
      this.depth = 0;
   }

   public void execute(AbstractInsnNode insn, Interpreter interpreter) throws AnalyzerException {
      this.current = insn;
      super.execute(insn, interpreter);
   }

   public void push(BasicValue value) throws IndexOutOfBoundsException {
      if (this.current == this.this$0.node && this.state == InsnFinder$AnalyzerState.SEARCH) {
         this.state = InsnFinder$AnalyzerState.ANALYSE;
         ++this.depth;
      } else if (this.state == InsnFinder$AnalyzerState.ANALYSE) {
         ++this.depth;
      }

      super.push(value);
   }

   public BasicValue pop() throws IndexOutOfBoundsException {
      if (this.state == InsnFinder$AnalyzerState.ANALYSE && --this.depth == 0) {
         this.state = InsnFinder$AnalyzerState.COMPLETE;
         throw new InsnFinder$AnalysisResultException(this.current);
      } else {
         return (BasicValue)super.pop();
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void push(Value var1) throws IndexOutOfBoundsException {
      this.push((BasicValue)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Value pop() throws IndexOutOfBoundsException {
      return this.pop();
   }
}

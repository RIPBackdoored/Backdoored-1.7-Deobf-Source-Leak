package org.spongepowered.asm.mixin.injection.invoke.util;

import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.analysis.Analyzer;
import org.spongepowered.asm.lib.tree.analysis.BasicInterpreter;
import org.spongepowered.asm.lib.tree.analysis.Frame;

class InsnFinder$PopAnalyzer extends Analyzer {
   protected final AbstractInsnNode node;

   public InsnFinder$PopAnalyzer(AbstractInsnNode node) {
      super(new BasicInterpreter());
      this.node = node;
   }

   protected Frame newFrame(int locals, int stack) {
      return new InsnFinder$PopAnalyzer$PopFrame(this, locals, stack);
   }
}

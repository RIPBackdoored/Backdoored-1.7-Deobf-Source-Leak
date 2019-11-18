package org.spongepowered.asm.mixin.injection.invoke.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
import org.spongepowered.asm.mixin.injection.struct.Target;

public class InsnFinder {
   private static final Logger logger = LogManager.getLogger("mixin");

   public AbstractInsnNode findPopInsn(Target target, AbstractInsnNode node) {
      try {
         (new InsnFinder$PopAnalyzer(node)).analyze(target.classNode.name, target.method);
      } catch (AnalyzerException var4) {
         if (var4.getCause() instanceof InsnFinder$AnalysisResultException) {
            return ((InsnFinder$AnalysisResultException)var4.getCause()).getResult();
         }

         logger.catching(var4);
      }

      return null;
   }
}

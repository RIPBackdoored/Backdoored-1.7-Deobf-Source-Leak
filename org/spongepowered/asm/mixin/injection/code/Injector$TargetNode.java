package org.spongepowered.asm.mixin.injection.code;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;

public final class Injector$TargetNode {
   final AbstractInsnNode insn;
   final Set nominators = new HashSet();

   Injector$TargetNode(AbstractInsnNode insn) {
      this.insn = insn;
   }

   public AbstractInsnNode getNode() {
      return this.insn;
   }

   public Set getNominators() {
      return Collections.unmodifiableSet(this.nominators);
   }

   public boolean equals(Object obj) {
      if (obj != null && obj.getClass() == Injector$TargetNode.class) {
         return ((Injector$TargetNode)obj).insn == this.insn;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.insn.hashCode();
   }
}

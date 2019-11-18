package org.spongepowered.asm.mixin.injection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;

final class InjectionPoint$Shift extends InjectionPoint {
   private final InjectionPoint input;
   private final int shift;

   public InjectionPoint$Shift(InjectionPoint input, int shift) {
      if (input == null) {
         throw new IllegalArgumentException("Must supply an input injection point for SHIFT");
      } else {
         this.input = input;
         this.shift = shift;
      }
   }

   public String toString() {
      return "InjectionPoint(" + this.getClass().getSimpleName() + ")[" + this.input + "]";
   }

   public boolean find(String desc, InsnList insns, Collection nodes) {
      List list = nodes instanceof List ? (List)nodes : new ArrayList(nodes);
      this.input.find(desc, insns, nodes);

      for(int i = 0; i < ((List)list).size(); ++i) {
         ((List)list).set(i, insns.get(insns.indexOf((AbstractInsnNode)((List)list).get(i)) + this.shift));
      }

      if (nodes != list) {
         nodes.clear();
         nodes.addAll((Collection)list);
      }

      return nodes.size() > 0;
   }
}

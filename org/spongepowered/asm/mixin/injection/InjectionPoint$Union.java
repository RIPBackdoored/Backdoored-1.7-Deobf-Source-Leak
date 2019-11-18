package org.spongepowered.asm.mixin.injection;

import java.util.Collection;
import java.util.LinkedHashSet;
import org.spongepowered.asm.lib.tree.InsnList;

final class InjectionPoint$Union extends InjectionPoint$CompositeInjectionPoint {
   public InjectionPoint$Union(InjectionPoint... points) {
      super(points);
   }

   public boolean find(String desc, InsnList insns, Collection nodes) {
      LinkedHashSet allNodes = new LinkedHashSet();

      for(int i = 0; i < this.components.length; ++i) {
         this.components[i].find(desc, insns, allNodes);
      }

      nodes.addAll(allNodes);
      return allNodes.size() > 0;
   }
}

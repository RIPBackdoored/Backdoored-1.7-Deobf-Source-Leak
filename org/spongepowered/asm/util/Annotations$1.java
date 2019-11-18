package org.spongepowered.asm.util;

import com.google.common.base.Function;
import org.spongepowered.asm.lib.tree.AnnotationNode;

final class Annotations$1 implements Function {
   public String apply(AnnotationNode input) {
      return input.desc;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((AnnotationNode)var1);
   }
}

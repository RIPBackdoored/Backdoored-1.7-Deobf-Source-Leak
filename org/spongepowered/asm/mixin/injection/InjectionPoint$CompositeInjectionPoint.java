package org.spongepowered.asm.mixin.injection;

import com.google.common.base.Joiner;

abstract class InjectionPoint$CompositeInjectionPoint extends InjectionPoint {
   protected final InjectionPoint[] components;

   protected InjectionPoint$CompositeInjectionPoint(InjectionPoint... components) {
      if (components != null && components.length >= 2) {
         this.components = components;
      } else {
         throw new IllegalArgumentException("Must supply two or more component injection points for composite point!");
      }
   }

   public String toString() {
      return "CompositeInjectionPoint(" + this.getClass().getSimpleName() + ")[" + Joiner.on(',').join(this.components) + "]";
   }
}

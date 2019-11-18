package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;

class MethodNode$1 extends ArrayList {
   // $FF: synthetic field
   final MethodNode this$0;

   MethodNode$1(MethodNode this$0, int x0) {
      super(x0);
      this.this$0 = this$0;
   }

   public boolean add(Object o) {
      this.this$0.annotationDefault = o;
      return super.add(o);
   }
}

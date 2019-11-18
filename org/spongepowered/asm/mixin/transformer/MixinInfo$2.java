package org.spongepowered.asm.mixin.transformer;

import com.google.common.base.Function;

class MixinInfo$2 implements Function {
   // $FF: synthetic field
   final MixinInfo this$0;

   MixinInfo$2(MixinInfo this$0) {
      this.this$0 = this$0;
   }

   public String apply(String input) {
      return this.this$0.getParent().remapClassName(this.this$0.getClassRef(), input);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((String)var1);
   }
}

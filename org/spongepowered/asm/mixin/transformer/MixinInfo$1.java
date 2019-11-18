package org.spongepowered.asm.mixin.transformer;

import com.google.common.base.Function;
import org.spongepowered.asm.lib.Type;

class MixinInfo$1 implements Function {
   // $FF: synthetic field
   final MixinInfo this$0;

   MixinInfo$1(MixinInfo this$0) {
      this.this$0 = this$0;
   }

   public String apply(Type input) {
      return input.getClassName();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((Type)var1);
   }
}

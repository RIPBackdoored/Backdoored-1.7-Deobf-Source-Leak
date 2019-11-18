package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.transformer.ext.IHotSwap;

class MixinTransformer$1 implements MixinConfig$IListener {
   // $FF: synthetic field
   final IHotSwap val$hotSwapper;
   // $FF: synthetic field
   final MixinTransformer this$0;

   MixinTransformer$1(MixinTransformer this$0, IHotSwap var2) {
      this.this$0 = this$0;
      this.val$hotSwapper = var2;
   }

   public void onPrepare(MixinInfo mixin) {
      this.val$hotSwapper.registerMixinClass(mixin.getClassName());
   }

   public void onInit(MixinInfo mixin) {
   }
}

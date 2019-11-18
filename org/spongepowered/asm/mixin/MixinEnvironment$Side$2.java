package org.spongepowered.asm.mixin;

import org.spongepowered.asm.service.MixinService;

final class MixinEnvironment$Side$2 extends MixinEnvironment$Side {
   MixinEnvironment$Side$2(String var1, int var2) {
      super(var1, var2, (MixinEnvironment$1)null);
   }

   protected boolean detect() {
      String sideName = MixinService.getService().getSideName();
      return "CLIENT".equals(sideName);
   }
}

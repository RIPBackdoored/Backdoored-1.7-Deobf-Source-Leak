package org.spongepowered.asm.mixin.injection.modify;

import org.spongepowered.asm.lib.Type;

public class LocalVariableDiscriminator$Context$Local {
   int ord;
   String name;
   Type type;
   // $FF: synthetic field
   final LocalVariableDiscriminator$Context this$0;

   public LocalVariableDiscriminator$Context$Local(LocalVariableDiscriminator$Context this$0, String name, Type type) {
      this.this$0 = this$0;
      this.ord = 0;
      this.name = name;
      this.type = type;
   }

   public String toString() {
      return String.format("Local[ordinal=%d, name=%s, type=%s]", this.ord, this.name, this.type);
   }
}

package org.spongepowered.tools.obfuscation;

import org.spongepowered.asm.util.ObfuscationUtil$IClassRemapper;

final class ObfuscationEnvironment$RemapperProxy implements ObfuscationUtil$IClassRemapper {
   // $FF: synthetic field
   final ObfuscationEnvironment this$0;

   ObfuscationEnvironment$RemapperProxy(ObfuscationEnvironment this$0) {
      this.this$0 = this$0;
   }

   public String map(String typeName) {
      return this.this$0.mappingProvider == null ? null : this.this$0.mappingProvider.getClassMapping(typeName);
   }

   public String unmap(String typeName) {
      return this.this$0.mappingProvider == null ? null : this.this$0.mappingProvider.getClassMapping(typeName);
   }
}

package org.spongepowered.asm.mixin.gen;

import java.util.Set;

final class AccessorInfo$AccessorType$3 extends AccessorInfo$AccessorType {
   AccessorInfo$AccessorType$3(String var1, int var2, Set expectedPrefixes) {
      super(var1, var2, expectedPrefixes, (AccessorInfo$1)null);
   }

   AccessorGenerator getGenerator(AccessorInfo info) {
      return new AccessorGeneratorMethodProxy(info);
   }
}

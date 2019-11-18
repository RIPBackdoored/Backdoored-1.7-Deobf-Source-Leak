package org.spongepowered.asm.mixin;

import org.spongepowered.asm.mixin.extensibility.IEnvironmentTokenProvider;

class MixinEnvironment$TokenProviderWrapper implements Comparable {
   private static int nextOrder = 0;
   private final int priority;
   private final int order;
   private final IEnvironmentTokenProvider provider;
   private final MixinEnvironment environment;

   public MixinEnvironment$TokenProviderWrapper(IEnvironmentTokenProvider provider, MixinEnvironment environment) {
      this.provider = provider;
      this.environment = environment;
      this.order = nextOrder++;
      this.priority = provider.getPriority();
   }

   public int compareTo(MixinEnvironment$TokenProviderWrapper other) {
      if (other == null) {
         return 0;
      } else {
         return other.priority == this.priority ? other.order - this.order : other.priority - this.priority;
      }
   }

   public IEnvironmentTokenProvider getProvider() {
      return this.provider;
   }

   Integer getToken(String token) {
      return this.provider.getToken(token, this.environment);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compareTo(Object var1) {
      return this.compareTo((MixinEnvironment$TokenProviderWrapper)var1);
   }
}

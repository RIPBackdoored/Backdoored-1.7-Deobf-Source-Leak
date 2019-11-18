package com.google.api.client.googleapis;

public final class MethodOverride$Builder {
   private boolean overrideAllMethods;

   public MethodOverride build() {
      return new MethodOverride(this.overrideAllMethods);
   }

   public boolean getOverrideAllMethods() {
      return this.overrideAllMethods;
   }

   public MethodOverride$Builder setOverrideAllMethods(boolean overrideAllMethods) {
      this.overrideAllMethods = overrideAllMethods;
      return this;
   }
}

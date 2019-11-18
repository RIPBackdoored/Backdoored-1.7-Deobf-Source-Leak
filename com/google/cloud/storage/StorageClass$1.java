package com.google.cloud.storage;

import com.google.api.core.ApiFunction;

final class StorageClass$1 implements ApiFunction {
   public StorageClass apply(String constant) {
      return new StorageClass(constant, (StorageClass$1)null);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((String)var1);
   }
}

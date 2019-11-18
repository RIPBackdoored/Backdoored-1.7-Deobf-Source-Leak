package com.google.cloud.storage;

import com.google.common.base.Function;

final class Cors$2 implements Function {
   public com.google.api.services.storage.model.Bucket.Cors apply(Cors cors) {
      return cors.toPb();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((Cors)var1);
   }
}

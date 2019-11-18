package com.google.cloud.storage;

import com.google.common.base.Function;

final class Cors$1 implements Function {
   public Cors apply(com.google.api.services.storage.model.Bucket.Cors pb) {
      return Cors.fromPb(pb);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((com.google.api.services.storage.model.Bucket.Cors)var1);
   }
}

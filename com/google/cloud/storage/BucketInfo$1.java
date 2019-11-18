package com.google.cloud.storage;

import com.google.common.base.Function;

final class BucketInfo$1 implements Function {
   public BucketInfo apply(com.google.api.services.storage.model.Bucket pb) {
      return BucketInfo.fromPb(pb);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((com.google.api.services.storage.model.Bucket)var1);
   }
}

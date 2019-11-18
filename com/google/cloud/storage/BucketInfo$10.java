package com.google.cloud.storage;

import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.common.base.Function;

final class BucketInfo$10 implements Function {
   public BucketInfo$DeleteRule apply(Rule rule) {
      return BucketInfo$DeleteRule.fromPb(rule);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((Rule)var1);
   }
}

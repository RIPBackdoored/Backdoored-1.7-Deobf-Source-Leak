package com.google.cloud.storage;

import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.common.base.Function;

class BucketInfo$5 implements Function {
   // $FF: synthetic field
   final BucketInfo this$0;

   BucketInfo$5(BucketInfo this$0) {
      this.this$0 = this$0;
   }

   public Rule apply(BucketInfo$DeleteRule deleteRule) {
      return deleteRule.toPb();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((BucketInfo$DeleteRule)var1);
   }
}

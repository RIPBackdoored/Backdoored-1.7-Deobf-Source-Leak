package com.google.cloud.storage;

import com.google.api.services.storage.model.BucketAccessControl;
import com.google.common.base.Function;

class BucketInfo$3 implements Function {
   // $FF: synthetic field
   final BucketInfo this$0;

   BucketInfo$3(BucketInfo this$0) {
      this.this$0 = this$0;
   }

   public BucketAccessControl apply(Acl acl) {
      return acl.toBucketPb();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((Acl)var1);
   }
}

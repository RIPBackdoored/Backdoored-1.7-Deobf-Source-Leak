package com.google.cloud.storage;

import com.google.api.services.storage.model.BucketAccessControl;
import com.google.common.base.Function;

final class BucketInfo$7 implements Function {
   public Acl apply(BucketAccessControl bucketAccessControl) {
      return Acl.fromPb(bucketAccessControl);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((BucketAccessControl)var1);
   }
}

package com.google.cloud.storage;

import com.google.api.services.storage.model.BucketAccessControl;
import com.google.common.base.Function;

final class Acl$2 implements Function {
   public Acl apply(BucketAccessControl aclPb) {
      return Acl.fromPb(aclPb);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((BucketAccessControl)var1);
   }
}

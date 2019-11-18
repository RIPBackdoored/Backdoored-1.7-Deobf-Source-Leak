package com.google.cloud.storage;

import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.common.base.Function;

class BucketInfo$4 implements Function {
   // $FF: synthetic field
   final BucketInfo this$0;

   BucketInfo$4(BucketInfo this$0) {
      this.this$0 = this$0;
   }

   public ObjectAccessControl apply(Acl acl) {
      return acl.toObjectPb();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((Acl)var1);
   }
}

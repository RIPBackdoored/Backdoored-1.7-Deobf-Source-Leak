package com.google.cloud.storage;

import com.google.api.services.storage.model.BucketAccessControl;
import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$23 implements Callable {
   // $FF: synthetic field
   final BucketAccessControl val$aclPb;
   // $FF: synthetic field
   final Map val$optionsMap;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$23(StorageImpl this$0, BucketAccessControl var2, Map var3) {
      this.this$0 = this$0;
      this.val$aclPb = var2;
      this.val$optionsMap = var3;
   }

   public BucketAccessControl call() {
      return StorageImpl.access$000(this.this$0).patchAcl(this.val$aclPb, this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

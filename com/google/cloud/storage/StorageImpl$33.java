package com.google.cloud.storage;

import com.google.api.services.storage.model.ObjectAccessControl;
import java.util.concurrent.Callable;

class StorageImpl$33 implements Callable {
   // $FF: synthetic field
   final ObjectAccessControl val$aclPb;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$33(StorageImpl this$0, ObjectAccessControl var2) {
      this.this$0 = this$0;
      this.val$aclPb = var2;
   }

   public ObjectAccessControl call() {
      return StorageImpl.access$000(this.this$0).patchAcl(this.val$aclPb);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

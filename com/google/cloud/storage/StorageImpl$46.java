package com.google.cloud.storage;

import java.util.concurrent.Callable;

class StorageImpl$46 implements Callable {
   // $FF: synthetic field
   final String val$projectId;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$46(StorageImpl this$0, String var2) {
      this.this$0 = this$0;
      this.val$projectId = var2;
   }

   public com.google.api.services.storage.model.ServiceAccount call() {
      return StorageImpl.access$000(this.this$0).getServiceAccount(this.val$projectId);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

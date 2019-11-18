package com.google.cloud.storage;

import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$2 implements Callable {
   // $FF: synthetic field
   final com.google.api.services.storage.model.Bucket val$bucketPb;
   // $FF: synthetic field
   final Map val$optionsMap;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$2(StorageImpl this$0, com.google.api.services.storage.model.Bucket var2, Map var3) {
      this.this$0 = this$0;
      this.val$bucketPb = var2;
      this.val$optionsMap = var3;
   }

   public com.google.api.services.storage.model.Bucket call() {
      return StorageImpl.access$000(this.this$0).create(this.val$bucketPb, this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

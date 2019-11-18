package com.google.cloud.storage;

import java.util.List;
import java.util.concurrent.Callable;

class StorageImpl$34 implements Callable {
   // $FF: synthetic field
   final BlobId val$blob;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$34(StorageImpl this$0, BlobId var2) {
      this.this$0 = this$0;
      this.val$blob = var2;
   }

   public List call() {
      return StorageImpl.access$000(this.this$0).listAcls(this.val$blob.getBucket(), this.val$blob.getName(), this.val$blob.getGeneration());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

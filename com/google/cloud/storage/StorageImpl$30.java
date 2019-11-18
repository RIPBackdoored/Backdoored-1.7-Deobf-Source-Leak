package com.google.cloud.storage;

import com.google.api.services.storage.model.ObjectAccessControl;
import java.util.concurrent.Callable;

class StorageImpl$30 implements Callable {
   // $FF: synthetic field
   final BlobId val$blob;
   // $FF: synthetic field
   final Acl$Entity val$entity;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$30(StorageImpl this$0, BlobId var2, Acl$Entity var3) {
      this.this$0 = this$0;
      this.val$blob = var2;
      this.val$entity = var3;
   }

   public ObjectAccessControl call() {
      return StorageImpl.access$000(this.this$0).getAcl(this.val$blob.getBucket(), this.val$blob.getName(), this.val$blob.getGeneration(), this.val$entity.toPb());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

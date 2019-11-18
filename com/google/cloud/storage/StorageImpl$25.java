package com.google.cloud.storage;

import com.google.api.services.storage.model.ObjectAccessControl;
import java.util.concurrent.Callable;

class StorageImpl$25 implements Callable {
   // $FF: synthetic field
   final String val$bucket;
   // $FF: synthetic field
   final Acl$Entity val$entity;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$25(StorageImpl this$0, String var2, Acl$Entity var3) {
      this.this$0 = this$0;
      this.val$bucket = var2;
      this.val$entity = var3;
   }

   public ObjectAccessControl call() {
      return StorageImpl.access$000(this.this$0).getDefaultAcl(this.val$bucket, this.val$entity.toPb());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

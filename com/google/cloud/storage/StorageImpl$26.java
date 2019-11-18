package com.google.cloud.storage;

import java.util.concurrent.Callable;

class StorageImpl$26 implements Callable {
   // $FF: synthetic field
   final String val$bucket;
   // $FF: synthetic field
   final Acl$Entity val$entity;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$26(StorageImpl this$0, String var2, Acl$Entity var3) {
      this.this$0 = this$0;
      this.val$bucket = var2;
      this.val$entity = var3;
   }

   public Boolean call() {
      return StorageImpl.access$000(this.this$0).deleteDefaultAcl(this.val$bucket, this.val$entity.toPb());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

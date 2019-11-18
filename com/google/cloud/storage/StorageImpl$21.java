package com.google.cloud.storage;

import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$21 implements Callable {
   // $FF: synthetic field
   final String val$bucket;
   // $FF: synthetic field
   final Acl$Entity val$entity;
   // $FF: synthetic field
   final Map val$optionsMap;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$21(StorageImpl this$0, String var2, Acl$Entity var3, Map var4) {
      this.this$0 = this$0;
      this.val$bucket = var2;
      this.val$entity = var3;
      this.val$optionsMap = var4;
   }

   public Boolean call() {
      return StorageImpl.access$000(this.this$0).deleteAcl(this.val$bucket, this.val$entity.toPb(), this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

package com.google.cloud.storage;

import java.util.List;
import java.util.concurrent.Callable;

class StorageImpl$29 implements Callable {
   // $FF: synthetic field
   final String val$bucket;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$29(StorageImpl this$0, String var2) {
      this.this$0 = this$0;
      this.val$bucket = var2;
   }

   public List call() {
      return StorageImpl.access$000(this.this$0).listDefaultAcls(this.val$bucket);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

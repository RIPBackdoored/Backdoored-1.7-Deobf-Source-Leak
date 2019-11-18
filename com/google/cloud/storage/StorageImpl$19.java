package com.google.cloud.storage;

import com.google.cloud.BatchResult.Callback;
import java.util.List;

class StorageImpl$19 implements Callback {
   // $FF: synthetic field
   final List val$results;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$19(StorageImpl this$0, List var2) {
      this.this$0 = this$0;
      this.val$results = var2;
   }

   public void success(Boolean result) {
      this.val$results.add(result);
   }

   public void error(StorageException exception) {
      this.val$results.add(Boolean.FALSE);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void error(Object var1) {
      this.error((StorageException)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void success(Object var1) {
      this.success((Boolean)var1);
   }
}

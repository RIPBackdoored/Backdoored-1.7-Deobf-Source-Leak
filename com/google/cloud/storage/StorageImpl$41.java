package com.google.cloud.storage;

import com.google.api.services.storage.model.Policy;
import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$41 implements Callable {
   // $FF: synthetic field
   final String val$bucket;
   // $FF: synthetic field
   final Map val$optionsMap;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$41(StorageImpl this$0, String var2, Map var3) {
      this.this$0 = this$0;
      this.val$bucket = var2;
      this.val$optionsMap = var3;
   }

   public Policy call() {
      return StorageImpl.access$000(this.this$0).getIamPolicy(this.val$bucket, this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

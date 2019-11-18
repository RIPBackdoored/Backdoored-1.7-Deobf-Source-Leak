package com.google.cloud.storage;

import com.google.cloud.Policy;
import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$42 implements Callable {
   // $FF: synthetic field
   final String val$bucket;
   // $FF: synthetic field
   final Policy val$policy;
   // $FF: synthetic field
   final Map val$optionsMap;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$42(StorageImpl this$0, String var2, Policy var3, Map var4) {
      this.this$0 = this$0;
      this.val$bucket = var2;
      this.val$policy = var3;
      this.val$optionsMap = var4;
   }

   public com.google.api.services.storage.model.Policy call() {
      return StorageImpl.access$000(this.this$0).setIamPolicy(this.val$bucket, PolicyHelper.convertToApiPolicy(this.val$policy), this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

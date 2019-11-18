package com.google.cloud.storage;

import com.google.api.services.storage.model.TestIamPermissionsResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$43 implements Callable {
   // $FF: synthetic field
   final String val$bucket;
   // $FF: synthetic field
   final List val$permissions;
   // $FF: synthetic field
   final Map val$optionsMap;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$43(StorageImpl this$0, String var2, List var3, Map var4) {
      this.this$0 = this$0;
      this.val$bucket = var2;
      this.val$permissions = var3;
      this.val$optionsMap = var4;
   }

   public TestIamPermissionsResponse call() {
      return StorageImpl.access$000(this.this$0).testIamPermissions(this.val$bucket, this.val$permissions, this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

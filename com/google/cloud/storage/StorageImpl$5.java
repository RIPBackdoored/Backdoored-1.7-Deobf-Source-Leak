package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$5 implements Callable {
   // $FF: synthetic field
   final StorageObject val$storedObject;
   // $FF: synthetic field
   final Map val$optionsMap;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$5(StorageImpl this$0, StorageObject var2, Map var3) {
      this.this$0 = this$0;
      this.val$storedObject = var2;
      this.val$optionsMap = var3;
   }

   public StorageObject call() {
      return StorageImpl.access$000(this.this$0).get(this.val$storedObject, this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

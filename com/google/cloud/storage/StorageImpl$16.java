package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$16 implements Callable {
   // $FF: synthetic field
   final StorageObject val$storageObject;
   // $FF: synthetic field
   final Map val$optionsMap;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$16(StorageImpl this$0, StorageObject var2, Map var3) {
      this.this$0 = this$0;
      this.val$storageObject = var2;
      this.val$optionsMap = var3;
   }

   public byte[] call() {
      return StorageImpl.access$000(this.this$0).load(this.val$storageObject, this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

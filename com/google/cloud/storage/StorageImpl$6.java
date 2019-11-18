package com.google.cloud.storage;

import com.google.cloud.Tuple;
import java.util.Map;
import java.util.concurrent.Callable;

final class StorageImpl$6 implements Callable {
   // $FF: synthetic field
   final StorageOptions val$serviceOptions;
   // $FF: synthetic field
   final Map val$optionsMap;

   StorageImpl$6(StorageOptions var1, Map var2) {
      this.val$serviceOptions = var1;
      this.val$optionsMap = var2;
   }

   public Tuple call() {
      return this.val$serviceOptions.getStorageRpcV1().list(this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

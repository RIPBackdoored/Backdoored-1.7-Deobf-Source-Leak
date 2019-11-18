package com.google.cloud.storage;

import com.google.cloud.Tuple;
import java.util.Map;
import java.util.concurrent.Callable;

final class StorageImpl$39 implements Callable {
   // $FF: synthetic field
   final StorageOptions val$serviceOptions;
   // $FF: synthetic field
   final Map val$options;

   StorageImpl$39(StorageOptions var1, Map var2) {
      this.val$serviceOptions = var1;
      this.val$options = var2;
   }

   public Tuple call() {
      return this.val$serviceOptions.getStorageRpcV1().listHmacKeys(this.val$options);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

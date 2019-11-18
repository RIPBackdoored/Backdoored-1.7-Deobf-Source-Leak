package com.google.cloud.storage;

import com.google.cloud.Tuple;
import java.util.Map;
import java.util.concurrent.Callable;

final class StorageImpl$8 implements Callable {
   // $FF: synthetic field
   final StorageOptions val$serviceOptions;
   // $FF: synthetic field
   final String val$bucket;
   // $FF: synthetic field
   final Map val$optionsMap;

   StorageImpl$8(StorageOptions var1, String var2, Map var3) {
      this.val$serviceOptions = var1;
      this.val$bucket = var2;
      this.val$optionsMap = var3;
   }

   public Tuple call() {
      return this.val$serviceOptions.getStorageRpcV1().list(this.val$bucket, this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

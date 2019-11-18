package com.google.cloud.storage;

import java.util.Map;
import java.util.concurrent.Callable;

final class BlobWriteChannel$2 implements Callable {
   // $FF: synthetic field
   final StorageOptions val$options;
   // $FF: synthetic field
   final BlobInfo val$blob;
   // $FF: synthetic field
   final Map val$optionsMap;

   BlobWriteChannel$2(StorageOptions var1, BlobInfo var2, Map var3) {
      this.val$options = var1;
      this.val$blob = var2;
      this.val$optionsMap = var3;
   }

   public String call() {
      return this.val$options.getStorageRpcV1().open(this.val$blob.toPb(), this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

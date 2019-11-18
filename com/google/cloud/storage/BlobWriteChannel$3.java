package com.google.cloud.storage;

import java.net.URL;
import java.util.concurrent.Callable;

final class BlobWriteChannel$3 implements Callable {
   // $FF: synthetic field
   final URL val$signedURL;
   // $FF: synthetic field
   final StorageOptions val$options;

   BlobWriteChannel$3(URL var1, StorageOptions var2) {
      this.val$signedURL = var1;
      this.val$options = var2;
   }

   public String call() {
      if (!BlobWriteChannel.access$400(this.val$signedURL.getQuery())) {
         throw new StorageException(2, "invalid signedURL");
      } else {
         return this.val$options.getStorageRpcV1().open(this.val$signedURL.toString());
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

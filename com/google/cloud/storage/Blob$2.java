package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.io.CountingOutputStream;
import java.util.Map;

class Blob$2 implements Runnable {
   // $FF: synthetic field
   final StorageRpc val$storageRpc;
   // $FF: synthetic field
   final Map val$requestOptions;
   // $FF: synthetic field
   final CountingOutputStream val$countingOutputStream;
   // $FF: synthetic field
   final Blob this$0;

   Blob$2(Blob this$0, StorageRpc var2, Map var3, CountingOutputStream var4) {
      this.this$0 = this$0;
      this.val$storageRpc = var2;
      this.val$requestOptions = var3;
      this.val$countingOutputStream = var4;
   }

   public void run() {
      this.val$storageRpc.read(this.this$0.getBlobId().toPb(), this.val$requestOptions, this.val$countingOutputStream.getCount(), this.val$countingOutputStream);
   }
}

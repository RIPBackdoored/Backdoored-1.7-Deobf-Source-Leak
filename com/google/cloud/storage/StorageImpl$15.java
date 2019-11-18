package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.spi.v1.StorageRpc$RewriteRequest;
import com.google.cloud.storage.spi.v1.StorageRpc$RewriteResponse;
import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$15 implements Callable {
   // $FF: synthetic field
   final StorageObject val$source;
   // $FF: synthetic field
   final Map val$sourceOptions;
   // $FF: synthetic field
   final Storage$CopyRequest val$copyRequest;
   // $FF: synthetic field
   final StorageObject val$targetObject;
   // $FF: synthetic field
   final Map val$targetOptions;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$15(StorageImpl this$0, StorageObject var2, Map var3, Storage$CopyRequest var4, StorageObject var5, Map var6) {
      this.this$0 = this$0;
      this.val$source = var2;
      this.val$sourceOptions = var3;
      this.val$copyRequest = var4;
      this.val$targetObject = var5;
      this.val$targetOptions = var6;
   }

   public StorageRpc$RewriteResponse call() {
      return StorageImpl.access$000(this.this$0).openRewrite(new StorageRpc$RewriteRequest(this.val$source, this.val$sourceOptions, this.val$copyRequest.overrideInfo(), this.val$targetObject, this.val$targetOptions, this.val$copyRequest.getMegabytesCopiedPerChunk()));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

package com.google.cloud.storage;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.cloud.storage.spi.v1.RpcBatch$Callback;

class StorageBatch$1 implements RpcBatch$Callback {
   // $FF: synthetic field
   final StorageBatchResult val$result;
   // $FF: synthetic field
   final StorageBatch this$0;

   StorageBatch$1(StorageBatch this$0, StorageBatchResult var2) {
      this.this$0 = this$0;
      this.val$result = var2;
   }

   public void onSuccess(Void response) {
      this.val$result.success(true);
   }

   public void onFailure(GoogleJsonError googleJsonError) {
      StorageException serviceException = new StorageException(googleJsonError);
      if (serviceException.getCode() == 404) {
         this.val$result.success(false);
      } else {
         this.val$result.error(serviceException);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void onSuccess(Object var1) {
      this.onSuccess((Void)var1);
   }
}

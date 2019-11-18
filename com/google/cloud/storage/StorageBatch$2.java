package com.google.cloud.storage;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.spi.v1.RpcBatch$Callback;

class StorageBatch$2 implements RpcBatch$Callback {
   // $FF: synthetic field
   final StorageBatchResult val$result;
   // $FF: synthetic field
   final StorageOptions val$serviceOptions;
   // $FF: synthetic field
   final StorageBatch this$0;

   StorageBatch$2(StorageBatch this$0, StorageBatchResult var2, StorageOptions var3) {
      this.this$0 = this$0;
      this.val$result = var2;
      this.val$serviceOptions = var3;
   }

   public void onSuccess(StorageObject response) {
      this.val$result.success(response == null ? null : Blob.fromPb((Storage)this.val$serviceOptions.getService(), response));
   }

   public void onFailure(GoogleJsonError googleJsonError) {
      StorageException serviceException = new StorageException(googleJsonError);
      if (serviceException.getCode() == 404) {
         this.val$result.success((Object)null);
      } else {
         this.val$result.error(serviceException);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void onSuccess(Object var1) {
      this.onSuccess((StorageObject)var1);
   }
}

package com.google.cloud.storage.spi.v1;

import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.HttpHeaders;
import java.io.IOException;

final class HttpStorageRpc$1 extends JsonBatchCallback {
   // $FF: synthetic field
   final RpcBatch$Callback val$callback;

   HttpStorageRpc$1(RpcBatch$Callback var1) {
      this.val$callback = var1;
   }

   public void onSuccess(Object response, HttpHeaders httpHeaders) throws IOException {
      this.val$callback.onSuccess(response);
   }

   public void onFailure(GoogleJsonError googleJsonError, HttpHeaders httpHeaders) throws IOException {
      this.val$callback.onFailure(googleJsonError);
   }
}

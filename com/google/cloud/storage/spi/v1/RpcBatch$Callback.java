package com.google.cloud.storage.spi.v1;

import com.google.api.client.googleapis.json.GoogleJsonError;

public interface RpcBatch$Callback {
   void onSuccess(Object var1);

   void onFailure(GoogleJsonError var1);
}

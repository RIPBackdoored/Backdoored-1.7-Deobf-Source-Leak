package com.google.cloud.storage;

import com.google.cloud.BaseServiceException;
import com.google.cloud.BatchResult;

public class StorageBatchResult extends BatchResult {
   StorageBatchResult() {
   }

   protected void error(StorageException error) {
      super.error(error);
   }

   protected void success(Object result) {
      super.success(result);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void error(BaseServiceException var1) {
      this.error((StorageException)var1);
   }
}

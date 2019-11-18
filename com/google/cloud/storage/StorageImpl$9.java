package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.Function;

final class StorageImpl$9 implements Function {
   // $FF: synthetic field
   final StorageOptions val$serviceOptions;

   StorageImpl$9(StorageOptions var1) {
      this.val$serviceOptions = var1;
   }

   public Blob apply(StorageObject storageObject) {
      return Blob.fromPb((Storage)this.val$serviceOptions.getService(), storageObject);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((StorageObject)var1);
   }
}

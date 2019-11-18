package com.google.cloud.storage;

import com.google.common.base.Function;

final class StorageImpl$7 implements Function {
   // $FF: synthetic field
   final StorageOptions val$serviceOptions;

   StorageImpl$7(StorageOptions var1) {
      this.val$serviceOptions = var1;
   }

   public Bucket apply(com.google.api.services.storage.model.Bucket bucketPb) {
      return Bucket.fromPb((Storage)this.val$serviceOptions.getService(), bucketPb);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((com.google.api.services.storage.model.Bucket)var1);
   }
}

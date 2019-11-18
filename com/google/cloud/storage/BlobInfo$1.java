package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.Function;

final class BlobInfo$1 implements Function {
   public StorageObject apply(BlobInfo blobInfo) {
      return blobInfo.toPb();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((BlobInfo)var1);
   }
}

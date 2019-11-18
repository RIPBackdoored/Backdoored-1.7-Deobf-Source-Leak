package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;
import com.google.common.base.Function;

final class Bucket$BlobTargetOption$1 implements Function {
   public StorageRpc$Option apply(Bucket$BlobTargetOption blobTargetOption) {
      return blobTargetOption.getRpcOption();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((Bucket$BlobTargetOption)var1);
   }
}

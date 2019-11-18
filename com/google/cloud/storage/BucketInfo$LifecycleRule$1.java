package com.google.cloud.storage;

import com.google.common.base.Function;

final class BucketInfo$LifecycleRule$1 implements Function {
   public StorageClass apply(String storageClass) {
      return StorageClass.valueOf(storageClass);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((String)var1);
   }
}

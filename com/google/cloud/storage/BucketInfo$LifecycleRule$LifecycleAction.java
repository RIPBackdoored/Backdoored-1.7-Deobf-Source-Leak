package com.google.cloud.storage;

import java.io.Serializable;

public abstract class BucketInfo$LifecycleRule$LifecycleAction implements Serializable {
   private static final long serialVersionUID = 5801228724709173284L;

   public abstract String getActionType();

   public static BucketInfo$LifecycleRule$DeleteLifecycleAction newDeleteAction() {
      return new BucketInfo$LifecycleRule$DeleteLifecycleAction((BucketInfo$1)null);
   }

   public static BucketInfo$LifecycleRule$SetStorageClassLifecycleAction newSetStorageClassAction(StorageClass storageClass) {
      return new BucketInfo$LifecycleRule$SetStorageClassLifecycleAction(storageClass, (BucketInfo$1)null);
   }
}

package com.google.cloud.storage;

public class BucketInfo$LifecycleRule$SetStorageClassLifecycleAction extends BucketInfo$LifecycleRule$LifecycleAction {
   public static final String TYPE = "SetStorageClass";
   private static final long serialVersionUID = -62615467186000899L;
   private final StorageClass storageClass;

   private BucketInfo$LifecycleRule$SetStorageClassLifecycleAction(StorageClass storageClass) {
      this.storageClass = storageClass;
   }

   public String getActionType() {
      return "SetStorageClass";
   }

   StorageClass getStorageClass() {
      return this.storageClass;
   }

   // $FF: synthetic method
   BucketInfo$LifecycleRule$SetStorageClassLifecycleAction(StorageClass x0, BucketInfo$1 x1) {
      this(x0);
   }
}

package com.google.cloud.storage;

import com.google.cloud.Service;
import com.google.cloud.ServiceOptions;

public class StorageOptions$DefaultStorageFactory implements StorageFactory {
   private static final StorageFactory INSTANCE = new StorageOptions$DefaultStorageFactory();

   public Storage create(StorageOptions options) {
      return new StorageImpl(options);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Service create(ServiceOptions var1) {
      return this.create((StorageOptions)var1);
   }

   // $FF: synthetic method
   static StorageFactory access$200() {
      return INSTANCE;
   }
}

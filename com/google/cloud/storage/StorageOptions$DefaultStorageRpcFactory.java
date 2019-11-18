package com.google.cloud.storage;

import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.HttpStorageRpc;

public class StorageOptions$DefaultStorageRpcFactory implements StorageRpcFactory {
   private static final StorageRpcFactory INSTANCE = new StorageOptions$DefaultStorageRpcFactory();

   public ServiceRpc create(StorageOptions options) {
      return new HttpStorageRpc(options);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public ServiceRpc create(ServiceOptions var1) {
      return this.create((StorageOptions)var1);
   }

   // $FF: synthetic method
   static StorageRpcFactory access$300() {
      return INSTANCE;
   }
}

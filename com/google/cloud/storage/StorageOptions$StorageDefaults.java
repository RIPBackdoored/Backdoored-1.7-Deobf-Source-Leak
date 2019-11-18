package com.google.cloud.storage;

import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceFactory;
import com.google.cloud.TransportOptions;
import com.google.cloud.spi.ServiceRpcFactory;
import com.google.cloud.storage.spi.StorageRpcFactory;

class StorageOptions$StorageDefaults implements ServiceDefaults {
   private StorageOptions$StorageDefaults() {
   }

   public StorageFactory getDefaultServiceFactory() {
      return StorageOptions$DefaultStorageFactory.access$200();
   }

   public StorageRpcFactory getDefaultRpcFactory() {
      return StorageOptions$DefaultStorageRpcFactory.access$300();
   }

   public TransportOptions getDefaultTransportOptions() {
      return StorageOptions.getDefaultHttpTransportOptions();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public ServiceRpcFactory getDefaultRpcFactory() {
      return this.getDefaultRpcFactory();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public ServiceFactory getDefaultServiceFactory() {
      return this.getDefaultServiceFactory();
   }

   // $FF: synthetic method
   StorageOptions$StorageDefaults(StorageOptions$1 x0) {
      this();
   }
}

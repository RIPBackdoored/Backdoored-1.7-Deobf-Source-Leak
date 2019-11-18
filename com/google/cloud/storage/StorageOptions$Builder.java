package com.google.cloud.storage;

import com.google.cloud.ServiceOptions;
import com.google.cloud.TransportOptions;
import com.google.cloud.ServiceOptions.Builder;
import com.google.cloud.http.HttpTransportOptions;

public class StorageOptions$Builder extends Builder {
   private StorageOptions$Builder() {
   }

   private StorageOptions$Builder(StorageOptions options) {
      super(options);
   }

   public StorageOptions$Builder setTransportOptions(TransportOptions transportOptions) {
      if (!(transportOptions instanceof HttpTransportOptions)) {
         throw new IllegalArgumentException("Only http transport is allowed for Storage.");
      } else {
         return (StorageOptions$Builder)super.setTransportOptions(transportOptions);
      }
   }

   public StorageOptions build() {
      return new StorageOptions(this, (StorageOptions$1)null);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Builder setTransportOptions(TransportOptions var1) {
      return this.setTransportOptions(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public ServiceOptions build() {
      return this.build();
   }

   // $FF: synthetic method
   StorageOptions$Builder(StorageOptions x0, StorageOptions$1 x1) {
      this(x0);
   }

   // $FF: synthetic method
   StorageOptions$Builder(StorageOptions$1 x0) {
      this();
   }
}

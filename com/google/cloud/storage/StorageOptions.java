package com.google.cloud.storage;

import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class StorageOptions extends ServiceOptions {
   private static final long serialVersionUID = -2907268477247502947L;
   private static final String API_SHORT_NAME = "Storage";
   private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
   private static final Set SCOPES = ImmutableSet.of("https://www.googleapis.com/auth/devstorage.full_control");

   private StorageOptions(StorageOptions$Builder builder) {
      super(StorageFactory.class, StorageRpcFactory.class, builder, new StorageOptions$StorageDefaults((StorageOptions$1)null));
   }

   public static HttpTransportOptions getDefaultHttpTransportOptions() {
      return HttpTransportOptions.newBuilder().build();
   }

   protected boolean projectIdRequired() {
      return false;
   }

   protected Set getScopes() {
      return SCOPES;
   }

   protected StorageRpc getStorageRpcV1() {
      return (StorageRpc)this.getRpc();
   }

   public static StorageOptions getDefaultInstance() {
      return newBuilder().build();
   }

   public static StorageOptions getUnauthenticatedInstance() {
      return ((StorageOptions$Builder)newBuilder().setCredentials(NoCredentials.getInstance())).build();
   }

   public StorageOptions$Builder toBuilder() {
      return new StorageOptions$Builder(this, (StorageOptions$1)null);
   }

   public int hashCode() {
      return this.baseHashCode();
   }

   public boolean equals(Object obj) {
      return obj instanceof StorageOptions && this.baseEquals((StorageOptions)obj);
   }

   public static StorageOptions$Builder newBuilder() {
      return new StorageOptions$Builder((StorageOptions$1)null);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public com.google.cloud.ServiceOptions.Builder toBuilder() {
      return this.toBuilder();
   }

   // $FF: synthetic method
   StorageOptions(StorageOptions$Builder x0, StorageOptions$1 x1) {
      this(x0);
   }
}

package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.RpcBatch;
import com.google.cloud.storage.spi.v1.RpcBatch$Callback;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.annotations.VisibleForTesting;
import java.util.Map;

public class StorageBatch {
   private final RpcBatch batch;
   private final StorageRpc storageRpc;
   private final StorageOptions options;

   StorageBatch(StorageOptions options) {
      this.options = options;
      this.storageRpc = options.getStorageRpcV1();
      this.batch = this.storageRpc.createBatch();
   }

   @VisibleForTesting
   Object getBatch() {
      return this.batch;
   }

   @VisibleForTesting
   StorageRpc getStorageRpc() {
      return this.storageRpc;
   }

   @VisibleForTesting
   StorageOptions getOptions() {
      return this.options;
   }

   public StorageBatchResult delete(String bucket, String blob, Storage$BlobSourceOption... options) {
      return this.delete(BlobId.of(bucket, blob), options);
   }

   public StorageBatchResult delete(BlobId blob, Storage$BlobSourceOption... options) {
      StorageBatchResult result = new StorageBatchResult();
      RpcBatch$Callback callback = this.createDeleteCallback(result);
      Map optionMap = StorageImpl.optionMap((BlobId)blob, options);
      this.batch.addDelete(blob.toPb(), callback, optionMap);
      return result;
   }

   public StorageBatchResult update(BlobInfo blobInfo, Storage$BlobTargetOption... options) {
      StorageBatchResult result = new StorageBatchResult();
      RpcBatch$Callback callback = this.createUpdateCallback(this.options, result);
      Map optionMap = StorageImpl.optionMap((BlobInfo)blobInfo, options);
      this.batch.addPatch(blobInfo.toPb(), callback, optionMap);
      return result;
   }

   public StorageBatchResult get(String bucket, String blob, Storage$BlobGetOption... options) {
      return this.get(BlobId.of(bucket, blob), options);
   }

   public StorageBatchResult get(BlobId blob, Storage$BlobGetOption... options) {
      StorageBatchResult result = new StorageBatchResult();
      RpcBatch$Callback callback = this.createGetCallback(this.options, result);
      Map optionMap = StorageImpl.optionMap((BlobId)blob, options);
      this.batch.addGet(blob.toPb(), callback, optionMap);
      return result;
   }

   public void submit() {
      this.batch.submit();
   }

   private RpcBatch$Callback createDeleteCallback(StorageBatchResult result) {
      return new StorageBatch$1(this, result);
   }

   private RpcBatch$Callback createGetCallback(StorageOptions serviceOptions, StorageBatchResult result) {
      return new StorageBatch$2(this, result, serviceOptions);
   }

   private RpcBatch$Callback createUpdateCallback(StorageOptions serviceOptions, StorageBatchResult result) {
      return new StorageBatch$3(this, result, serviceOptions);
   }
}

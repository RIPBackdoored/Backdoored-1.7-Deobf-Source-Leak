package com.google.cloud.storage;

import com.google.cloud.Restorable;
import com.google.cloud.RestorableState;
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc$RewriteResponse;

public class CopyWriter implements Restorable {
   private final StorageOptions serviceOptions;
   private final StorageRpc storageRpc;
   private StorageRpc$RewriteResponse rewriteResponse;

   CopyWriter(StorageOptions serviceOptions, StorageRpc$RewriteResponse rewriteResponse) {
      this.serviceOptions = serviceOptions;
      this.rewriteResponse = rewriteResponse;
      this.storageRpc = serviceOptions.getStorageRpcV1();
   }

   public Blob getResult() {
      while(!this.isDone()) {
         this.copyChunk();
      }

      return Blob.fromPb((Storage)this.serviceOptions.getService(), this.rewriteResponse.result);
   }

   public long getBlobSize() {
      return this.rewriteResponse.blobSize;
   }

   public boolean isDone() {
      return this.rewriteResponse.isDone;
   }

   public long getTotalBytesCopied() {
      return this.rewriteResponse.totalBytesRewritten;
   }

   public void copyChunk() {
      if (!this.isDone()) {
         try {
            this.rewriteResponse = (StorageRpc$RewriteResponse)RetryHelper.runWithRetries(new CopyWriter$1(this), this.serviceOptions.getRetrySettings(), StorageImpl.EXCEPTION_HANDLER, this.serviceOptions.getClock());
         } catch (RetryHelperException var2) {
            throw StorageException.translateAndThrow(var2);
         }
      }

   }

   public RestorableState capture() {
      return CopyWriter$StateImpl.newBuilder(this.serviceOptions, BlobId.fromPb(this.rewriteResponse.rewriteRequest.source), this.rewriteResponse.rewriteRequest.sourceOptions, this.rewriteResponse.rewriteRequest.overrideInfo, BlobInfo.fromPb(this.rewriteResponse.rewriteRequest.target), this.rewriteResponse.rewriteRequest.targetOptions).setResult(this.rewriteResponse.result != null ? BlobInfo.fromPb(this.rewriteResponse.result) : null).setBlobSize(this.getBlobSize()).setIsDone(this.isDone()).setMegabytesCopiedPerChunk(this.rewriteResponse.rewriteRequest.megabytesRewrittenPerCall).setRewriteToken(this.rewriteResponse.rewriteToken).setTotalBytesRewritten(this.getTotalBytesCopied()).build();
   }

   // $FF: synthetic method
   static StorageRpc$RewriteResponse access$000(CopyWriter x0) {
      return x0.rewriteResponse;
   }

   // $FF: synthetic method
   static StorageRpc access$100(CopyWriter x0) {
      return x0.storageRpc;
   }
}

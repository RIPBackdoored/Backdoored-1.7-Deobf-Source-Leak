package com.google.cloud.storage.spi.v1;

import com.google.api.services.storage.model.StorageObject;
import java.util.Objects;

public class StorageRpc$RewriteResponse {
   public final StorageRpc$RewriteRequest rewriteRequest;
   public final StorageObject result;
   public final long blobSize;
   public final boolean isDone;
   public final String rewriteToken;
   public final long totalBytesRewritten;

   public StorageRpc$RewriteResponse(StorageRpc$RewriteRequest rewriteRequest, StorageObject result, long blobSize, boolean isDone, String rewriteToken, long totalBytesRewritten) {
      this.rewriteRequest = rewriteRequest;
      this.result = result;
      this.blobSize = blobSize;
      this.isDone = isDone;
      this.rewriteToken = rewriteToken;
      this.totalBytesRewritten = totalBytesRewritten;
   }

   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      } else if (!(obj instanceof StorageRpc$RewriteResponse)) {
         return false;
      } else {
         StorageRpc$RewriteResponse other = (StorageRpc$RewriteResponse)obj;
         return Objects.equals(this.rewriteRequest, other.rewriteRequest) && Objects.equals(this.result, other.result) && Objects.equals(this.rewriteToken, other.rewriteToken) && this.blobSize == other.blobSize && Objects.equals(this.isDone, other.isDone) && this.totalBytesRewritten == other.totalBytesRewritten;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.rewriteRequest, this.result, this.blobSize, this.isDone, this.rewriteToken, this.totalBytesRewritten});
   }
}

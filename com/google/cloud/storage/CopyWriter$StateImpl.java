package com.google.cloud.storage;

import com.google.cloud.Restorable;
import com.google.cloud.RestorableState;
import com.google.cloud.storage.spi.v1.StorageRpc$RewriteRequest;
import com.google.cloud.storage.spi.v1.StorageRpc$RewriteResponse;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

class CopyWriter$StateImpl implements RestorableState, Serializable {
   private static final long serialVersionUID = 1693964441435822700L;
   private final StorageOptions serviceOptions;
   private final BlobId source;
   private final Map sourceOptions;
   private final boolean overrideInfo;
   private final BlobInfo target;
   private final Map targetOptions;
   private final BlobInfo result;
   private final long blobSize;
   private final boolean isDone;
   private final String rewriteToken;
   private final long totalBytesCopied;
   private final Long megabytesCopiedPerChunk;

   CopyWriter$StateImpl(CopyWriter$StateImpl$Builder builder) {
      this.serviceOptions = CopyWriter$StateImpl$Builder.access$200(builder);
      this.source = CopyWriter$StateImpl$Builder.access$300(builder);
      this.sourceOptions = CopyWriter$StateImpl$Builder.access$400(builder);
      this.overrideInfo = CopyWriter$StateImpl$Builder.access$500(builder);
      this.target = CopyWriter$StateImpl$Builder.access$600(builder);
      this.targetOptions = CopyWriter$StateImpl$Builder.access$700(builder);
      this.result = CopyWriter$StateImpl$Builder.access$800(builder);
      this.blobSize = CopyWriter$StateImpl$Builder.access$900(builder);
      this.isDone = CopyWriter$StateImpl$Builder.access$1000(builder);
      this.rewriteToken = CopyWriter$StateImpl$Builder.access$1100(builder);
      this.totalBytesCopied = CopyWriter$StateImpl$Builder.access$1200(builder);
      this.megabytesCopiedPerChunk = CopyWriter$StateImpl$Builder.access$1300(builder);
   }

   static CopyWriter$StateImpl$Builder newBuilder(StorageOptions options, BlobId source, Map sourceOptions, boolean overrideInfo, BlobInfo target, Map targetOptions) {
      return new CopyWriter$StateImpl$Builder(options, source, sourceOptions, overrideInfo, target, targetOptions, (CopyWriter$1)null);
   }

   public CopyWriter restore() {
      StorageRpc$RewriteRequest rewriteRequest = new StorageRpc$RewriteRequest(this.source.toPb(), this.sourceOptions, this.overrideInfo, this.target.toPb(), this.targetOptions, this.megabytesCopiedPerChunk);
      StorageRpc$RewriteResponse rewriteResponse = new StorageRpc$RewriteResponse(rewriteRequest, this.result != null ? this.result.toPb() : null, this.blobSize, this.isDone, this.rewriteToken, this.totalBytesCopied);
      return new CopyWriter(this.serviceOptions, rewriteResponse);
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.serviceOptions, this.source, this.sourceOptions, this.overrideInfo, this.target, this.targetOptions, this.result, this.blobSize, this.isDone, this.megabytesCopiedPerChunk, this.rewriteToken, this.totalBytesCopied});
   }

   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      } else if (!(obj instanceof CopyWriter$StateImpl)) {
         return false;
      } else {
         CopyWriter$StateImpl other = (CopyWriter$StateImpl)obj;
         return Objects.equals(this.serviceOptions, other.serviceOptions) && Objects.equals(this.source, other.source) && Objects.equals(this.sourceOptions, other.sourceOptions) && Objects.equals(this.overrideInfo, other.overrideInfo) && Objects.equals(this.target, other.target) && Objects.equals(this.targetOptions, other.targetOptions) && Objects.equals(this.result, other.result) && Objects.equals(this.rewriteToken, other.rewriteToken) && Objects.equals(this.megabytesCopiedPerChunk, other.megabytesCopiedPerChunk) && this.blobSize == other.blobSize && this.isDone == other.isDone && this.totalBytesCopied == other.totalBytesCopied;
      }
   }

   public String toString() {
      return MoreObjects.toStringHelper(this).add("source", this.source).add("overrideInfo", this.overrideInfo).add("target", this.target).add("result", this.result).add("blobSize", this.blobSize).add("isDone", this.isDone).add("rewriteToken", this.rewriteToken).add("totalBytesCopied", this.totalBytesCopied).add("megabytesCopiedPerChunk", this.megabytesCopiedPerChunk).toString();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Restorable restore() {
      return this.restore();
   }
}

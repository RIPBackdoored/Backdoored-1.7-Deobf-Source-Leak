package com.google.cloud.storage;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.List;

public class Storage$CopyRequest implements Serializable {
   private static final long serialVersionUID = -4498650529476219937L;
   private final BlobId source;
   private final List sourceOptions;
   private final boolean overrideInfo;
   private final BlobInfo target;
   private final List targetOptions;
   private final Long megabytesCopiedPerChunk;

   private Storage$CopyRequest(Storage$CopyRequest$Builder builder) {
      this.source = (BlobId)Preconditions.checkNotNull(Storage$CopyRequest$Builder.access$700(builder));
      this.sourceOptions = ImmutableList.copyOf(Storage$CopyRequest$Builder.access$800(builder));
      this.overrideInfo = Storage$CopyRequest$Builder.access$900(builder);
      this.target = (BlobInfo)Preconditions.checkNotNull(Storage$CopyRequest$Builder.access$1000(builder));
      this.targetOptions = ImmutableList.copyOf(Storage$CopyRequest$Builder.access$1100(builder));
      this.megabytesCopiedPerChunk = Storage$CopyRequest$Builder.access$1200(builder);
   }

   public BlobId getSource() {
      return this.source;
   }

   public List getSourceOptions() {
      return this.sourceOptions;
   }

   public BlobInfo getTarget() {
      return this.target;
   }

   public boolean overrideInfo() {
      return this.overrideInfo;
   }

   public List getTargetOptions() {
      return this.targetOptions;
   }

   public Long getMegabytesCopiedPerChunk() {
      return this.megabytesCopiedPerChunk;
   }

   public static Storage$CopyRequest of(String sourceBucket, String sourceBlob, BlobInfo target) {
      return newBuilder().setSource(sourceBucket, sourceBlob).setTarget(target).build();
   }

   public static Storage$CopyRequest of(BlobId sourceBlobId, BlobInfo target) {
      return newBuilder().setSource(sourceBlobId).setTarget(target).build();
   }

   public static Storage$CopyRequest of(String sourceBucket, String sourceBlob, String targetBlob) {
      return newBuilder().setSource(sourceBucket, sourceBlob).setTarget(BlobId.of(sourceBucket, targetBlob)).build();
   }

   public static Storage$CopyRequest of(String sourceBucket, String sourceBlob, BlobId target) {
      return newBuilder().setSource(sourceBucket, sourceBlob).setTarget(target).build();
   }

   public static Storage$CopyRequest of(BlobId sourceBlobId, String targetBlob) {
      return newBuilder().setSource(sourceBlobId).setTarget(BlobId.of(sourceBlobId.getBucket(), targetBlob)).build();
   }

   public static Storage$CopyRequest of(BlobId sourceBlobId, BlobId targetBlobId) {
      return newBuilder().setSource(sourceBlobId).setTarget(targetBlobId).build();
   }

   public static Storage$CopyRequest$Builder newBuilder() {
      return new Storage$CopyRequest$Builder();
   }

   // $FF: synthetic method
   Storage$CopyRequest(Storage$CopyRequest$Builder x0, Storage$1 x1) {
      this(x0);
   }
}

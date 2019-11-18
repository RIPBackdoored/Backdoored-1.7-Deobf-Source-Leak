package com.google.cloud.storage;

import com.google.cloud.Restorable;
import com.google.cloud.WriteChannel;
import com.google.cloud.BaseWriteChannel.BaseState;

class BlobWriteChannel$StateImpl extends BaseState {
   private static final long serialVersionUID = -9028324143780151286L;

   BlobWriteChannel$StateImpl(BlobWriteChannel$StateImpl$Builder builder) {
      super(builder);
   }

   static BlobWriteChannel$StateImpl$Builder builder(StorageOptions options, BlobInfo blobInfo, String uploadId) {
      return new BlobWriteChannel$StateImpl$Builder(options, blobInfo, uploadId, (BlobWriteChannel$1)null);
   }

   public WriteChannel restore() {
      BlobWriteChannel channel = new BlobWriteChannel((StorageOptions)this.serviceOptions, (BlobInfo)this.entity, this.uploadId);
      BlobWriteChannel.access$600(channel, this);
      return channel;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Restorable restore() {
      return this.restore();
   }
}

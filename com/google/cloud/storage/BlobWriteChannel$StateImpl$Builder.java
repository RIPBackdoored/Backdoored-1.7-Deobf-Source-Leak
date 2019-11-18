package com.google.cloud.storage;

import com.google.cloud.RestorableState;
import com.google.cloud.BaseWriteChannel.BaseState.Builder;

class BlobWriteChannel$StateImpl$Builder extends Builder {
   private BlobWriteChannel$StateImpl$Builder(StorageOptions options, BlobInfo blobInfo, String uploadId) {
      super(options, blobInfo, uploadId);
   }

   public RestorableState build() {
      return new BlobWriteChannel$StateImpl(this);
   }

   // $FF: synthetic method
   BlobWriteChannel$StateImpl$Builder(StorageOptions x0, BlobInfo x1, String x2, BlobWriteChannel$1 x3) {
      this(x0, x1, x2);
   }
}

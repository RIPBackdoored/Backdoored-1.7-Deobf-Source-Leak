package com.google.cloud.storage;

import com.google.cloud.RestorableState;
import java.util.Map;

class CopyWriter$StateImpl$Builder {
   private final StorageOptions serviceOptions;
   private final BlobId source;
   private final Map sourceOptions;
   private final boolean overrideInfo;
   private final BlobInfo target;
   private final Map targetOptions;
   private BlobInfo result;
   private long blobSize;
   private boolean isDone;
   private String rewriteToken;
   private long totalBytesCopied;
   private Long megabytesCopiedPerChunk;

   private CopyWriter$StateImpl$Builder(StorageOptions options, BlobId source, Map sourceOptions, boolean overrideInfo, BlobInfo target, Map targetOptions) {
      this.serviceOptions = options;
      this.source = source;
      this.sourceOptions = sourceOptions;
      this.overrideInfo = overrideInfo;
      this.target = target;
      this.targetOptions = targetOptions;
   }

   CopyWriter$StateImpl$Builder setResult(BlobInfo result) {
      this.result = result;
      return this;
   }

   CopyWriter$StateImpl$Builder setBlobSize(long blobSize) {
      this.blobSize = blobSize;
      return this;
   }

   CopyWriter$StateImpl$Builder setIsDone(boolean isDone) {
      this.isDone = isDone;
      return this;
   }

   CopyWriter$StateImpl$Builder setRewriteToken(String rewriteToken) {
      this.rewriteToken = rewriteToken;
      return this;
   }

   CopyWriter$StateImpl$Builder setTotalBytesRewritten(long totalBytesRewritten) {
      this.totalBytesCopied = totalBytesRewritten;
      return this;
   }

   CopyWriter$StateImpl$Builder setMegabytesCopiedPerChunk(Long megabytesCopiedPerChunk) {
      this.megabytesCopiedPerChunk = megabytesCopiedPerChunk;
      return this;
   }

   RestorableState build() {
      return new CopyWriter$StateImpl(this);
   }

   // $FF: synthetic method
   static StorageOptions access$200(CopyWriter$StateImpl$Builder x0) {
      return x0.serviceOptions;
   }

   // $FF: synthetic method
   static BlobId access$300(CopyWriter$StateImpl$Builder x0) {
      return x0.source;
   }

   // $FF: synthetic method
   static Map access$400(CopyWriter$StateImpl$Builder x0) {
      return x0.sourceOptions;
   }

   // $FF: synthetic method
   static boolean access$500(CopyWriter$StateImpl$Builder x0) {
      return x0.overrideInfo;
   }

   // $FF: synthetic method
   static BlobInfo access$600(CopyWriter$StateImpl$Builder x0) {
      return x0.target;
   }

   // $FF: synthetic method
   static Map access$700(CopyWriter$StateImpl$Builder x0) {
      return x0.targetOptions;
   }

   // $FF: synthetic method
   static BlobInfo access$800(CopyWriter$StateImpl$Builder x0) {
      return x0.result;
   }

   // $FF: synthetic method
   static long access$900(CopyWriter$StateImpl$Builder x0) {
      return x0.blobSize;
   }

   // $FF: synthetic method
   static boolean access$1000(CopyWriter$StateImpl$Builder x0) {
      return x0.isDone;
   }

   // $FF: synthetic method
   static String access$1100(CopyWriter$StateImpl$Builder x0) {
      return x0.rewriteToken;
   }

   // $FF: synthetic method
   static long access$1200(CopyWriter$StateImpl$Builder x0) {
      return x0.totalBytesCopied;
   }

   // $FF: synthetic method
   static Long access$1300(CopyWriter$StateImpl$Builder x0) {
      return x0.megabytesCopiedPerChunk;
   }

   // $FF: synthetic method
   CopyWriter$StateImpl$Builder(StorageOptions x0, BlobId x1, Map x2, boolean x3, BlobInfo x4, Map x5, CopyWriter$1 x6) {
      this(x0, x1, x2, x3, x4, x5);
   }
}

package com.google.cloud.storage;

import com.google.cloud.RestorableState;
import java.util.Map;

class BlobReadChannel$StateImpl$Builder {
   private final StorageOptions serviceOptions;
   private final BlobId blob;
   private final Map requestOptions;
   private String lastEtag;
   private long position;
   private boolean isOpen;
   private boolean endOfStream;
   private int chunkSize;

   private BlobReadChannel$StateImpl$Builder(StorageOptions options, BlobId blob, Map reqOptions) {
      this.serviceOptions = options;
      this.blob = blob;
      this.requestOptions = reqOptions;
   }

   BlobReadChannel$StateImpl$Builder setLastEtag(String lastEtag) {
      this.lastEtag = lastEtag;
      return this;
   }

   BlobReadChannel$StateImpl$Builder setPosition(long position) {
      this.position = position;
      return this;
   }

   BlobReadChannel$StateImpl$Builder setIsOpen(boolean isOpen) {
      this.isOpen = isOpen;
      return this;
   }

   BlobReadChannel$StateImpl$Builder setEndOfStream(boolean endOfStream) {
      this.endOfStream = endOfStream;
      return this;
   }

   BlobReadChannel$StateImpl$Builder setChunkSize(int chunkSize) {
      this.chunkSize = chunkSize;
      return this;
   }

   RestorableState build() {
      return new BlobReadChannel$StateImpl(this);
   }

   // $FF: synthetic method
   static StorageOptions access$400(BlobReadChannel$StateImpl$Builder x0) {
      return x0.serviceOptions;
   }

   // $FF: synthetic method
   static BlobId access$500(BlobReadChannel$StateImpl$Builder x0) {
      return x0.blob;
   }

   // $FF: synthetic method
   static Map access$600(BlobReadChannel$StateImpl$Builder x0) {
      return x0.requestOptions;
   }

   // $FF: synthetic method
   static String access$700(BlobReadChannel$StateImpl$Builder x0) {
      return x0.lastEtag;
   }

   // $FF: synthetic method
   static long access$800(BlobReadChannel$StateImpl$Builder x0) {
      return x0.position;
   }

   // $FF: synthetic method
   static boolean access$900(BlobReadChannel$StateImpl$Builder x0) {
      return x0.isOpen;
   }

   // $FF: synthetic method
   static boolean access$1000(BlobReadChannel$StateImpl$Builder x0) {
      return x0.endOfStream;
   }

   // $FF: synthetic method
   static int access$1100(BlobReadChannel$StateImpl$Builder x0) {
      return x0.chunkSize;
   }

   // $FF: synthetic method
   BlobReadChannel$StateImpl$Builder(StorageOptions x0, BlobId x1, Map x2, BlobReadChannel$1 x3) {
      this(x0, x1, x2);
   }
}

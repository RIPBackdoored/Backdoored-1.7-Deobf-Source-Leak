package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.ReadChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.RetryHelper;
import com.google.cloud.Tuple;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.storage.spi.v1.StorageRpc;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Map;
import java.util.Objects;

class BlobReadChannel implements ReadChannel {
   private static final int DEFAULT_CHUNK_SIZE = 2097152;
   private final StorageOptions serviceOptions;
   private final BlobId blob;
   private final Map requestOptions;
   private String lastEtag;
   private long position;
   private boolean isOpen;
   private boolean endOfStream;
   private int chunkSize = 2097152;
   private final StorageRpc storageRpc;
   private final StorageObject storageObject;
   private int bufferPos;
   private byte[] buffer;

   BlobReadChannel(StorageOptions serviceOptions, BlobId blob, Map requestOptions) {
      this.serviceOptions = serviceOptions;
      this.blob = blob;
      this.requestOptions = requestOptions;
      this.isOpen = true;
      this.storageRpc = serviceOptions.getStorageRpcV1();
      this.storageObject = blob.toPb();
   }

   public RestorableState capture() {
      BlobReadChannel$StateImpl$Builder builder = BlobReadChannel$StateImpl.builder(this.serviceOptions, this.blob, this.requestOptions).setPosition(this.position).setIsOpen(this.isOpen).setEndOfStream(this.endOfStream).setChunkSize(this.chunkSize);
      if (this.buffer != null) {
         builder.setPosition(this.position + (long)this.bufferPos);
         builder.setEndOfStream(false);
      }

      return builder.build();
   }

   public boolean isOpen() {
      return this.isOpen;
   }

   public void close() {
      if (this.isOpen) {
         this.buffer = null;
         this.isOpen = false;
      }

   }

   private void validateOpen() throws ClosedChannelException {
      if (!this.isOpen) {
         throw new ClosedChannelException();
      }
   }

   public void seek(long position) throws IOException {
      this.validateOpen();
      this.position = position;
      this.buffer = null;
      this.bufferPos = 0;
      this.endOfStream = false;
   }

   public void setChunkSize(int chunkSize) {
      this.chunkSize = chunkSize <= 0 ? 2097152 : chunkSize;
   }

   public int read(ByteBuffer byteBuffer) throws IOException {
      this.validateOpen();
      int toRead;
      if (this.buffer == null) {
         if (this.endOfStream) {
            return -1;
         }

         toRead = Math.max(byteBuffer.remaining(), this.chunkSize);

         try {
            Tuple result = (Tuple)RetryHelper.runWithRetries(new BlobReadChannel$1(this, toRead), this.serviceOptions.getRetrySettings(), StorageImpl.EXCEPTION_HANDLER, this.serviceOptions.getClock());
            if (((byte[])result.y()).length > 0 && this.lastEtag != null && !Objects.equals(result.x(), this.lastEtag)) {
               StringBuilder messageBuilder = new StringBuilder();
               messageBuilder.append("Blob ").append(this.blob).append(" was updated while reading");
               throw new StorageException(0, messageBuilder.toString());
            }

            this.lastEtag = (String)result.x();
            this.buffer = (byte[])result.y();
         } catch (RetryHelperException var5) {
            throw StorageException.translateAndThrow(var5);
         }

         if (toRead > this.buffer.length) {
            this.endOfStream = true;
            if (this.buffer.length == 0) {
               this.buffer = null;
               return -1;
            }
         }
      }

      toRead = Math.min(this.buffer.length - this.bufferPos, byteBuffer.remaining());
      byteBuffer.put(this.buffer, this.bufferPos, toRead);
      this.bufferPos += toRead;
      if (this.bufferPos >= this.buffer.length) {
         this.position += (long)this.buffer.length;
         this.buffer = null;
         this.bufferPos = 0;
      }

      return toRead;
   }

   // $FF: synthetic method
   static StorageObject access$000(BlobReadChannel x0) {
      return x0.storageObject;
   }

   // $FF: synthetic method
   static Map access$100(BlobReadChannel x0) {
      return x0.requestOptions;
   }

   // $FF: synthetic method
   static long access$200(BlobReadChannel x0) {
      return x0.position;
   }

   // $FF: synthetic method
   static StorageRpc access$300(BlobReadChannel x0) {
      return x0.storageRpc;
   }

   // $FF: synthetic method
   static String access$1302(BlobReadChannel x0, String x1) {
      return x0.lastEtag = x1;
   }

   // $FF: synthetic method
   static long access$202(BlobReadChannel x0, long x1) {
      return x0.position = x1;
   }

   // $FF: synthetic method
   static boolean access$1402(BlobReadChannel x0, boolean x1) {
      return x0.isOpen = x1;
   }

   // $FF: synthetic method
   static boolean access$1502(BlobReadChannel x0, boolean x1) {
      return x0.endOfStream = x1;
   }

   // $FF: synthetic method
   static int access$1602(BlobReadChannel x0, int x1) {
      return x0.chunkSize = x1;
   }
}

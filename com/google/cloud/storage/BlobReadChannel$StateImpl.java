package com.google.cloud.storage;

import com.google.cloud.ReadChannel;
import com.google.cloud.Restorable;
import com.google.cloud.RestorableState;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

class BlobReadChannel$StateImpl implements RestorableState, Serializable {
   private static final long serialVersionUID = 3889420316004453706L;
   private final StorageOptions serviceOptions;
   private final BlobId blob;
   private final Map requestOptions;
   private final String lastEtag;
   private final long position;
   private final boolean isOpen;
   private final boolean endOfStream;
   private final int chunkSize;

   BlobReadChannel$StateImpl(BlobReadChannel$StateImpl$Builder builder) {
      this.serviceOptions = BlobReadChannel$StateImpl$Builder.access$400(builder);
      this.blob = BlobReadChannel$StateImpl$Builder.access$500(builder);
      this.requestOptions = BlobReadChannel$StateImpl$Builder.access$600(builder);
      this.lastEtag = BlobReadChannel$StateImpl$Builder.access$700(builder);
      this.position = BlobReadChannel$StateImpl$Builder.access$800(builder);
      this.isOpen = BlobReadChannel$StateImpl$Builder.access$900(builder);
      this.endOfStream = BlobReadChannel$StateImpl$Builder.access$1000(builder);
      this.chunkSize = BlobReadChannel$StateImpl$Builder.access$1100(builder);
   }

   static BlobReadChannel$StateImpl$Builder builder(StorageOptions options, BlobId blob, Map reqOptions) {
      return new BlobReadChannel$StateImpl$Builder(options, blob, reqOptions, (BlobReadChannel$1)null);
   }

   public ReadChannel restore() {
      BlobReadChannel channel = new BlobReadChannel(this.serviceOptions, this.blob, this.requestOptions);
      BlobReadChannel.access$1302(channel, this.lastEtag);
      BlobReadChannel.access$202(channel, this.position);
      BlobReadChannel.access$1402(channel, this.isOpen);
      BlobReadChannel.access$1502(channel, this.endOfStream);
      BlobReadChannel.access$1602(channel, this.chunkSize);
      return channel;
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.serviceOptions, this.blob, this.requestOptions, this.lastEtag, this.position, this.isOpen, this.endOfStream, this.chunkSize});
   }

   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      } else if (!(obj instanceof BlobReadChannel$StateImpl)) {
         return false;
      } else {
         BlobReadChannel$StateImpl other = (BlobReadChannel$StateImpl)obj;
         return Objects.equals(this.serviceOptions, other.serviceOptions) && Objects.equals(this.blob, other.blob) && Objects.equals(this.requestOptions, other.requestOptions) && Objects.equals(this.lastEtag, other.lastEtag) && this.position == other.position && this.isOpen == other.isOpen && this.endOfStream == other.endOfStream && this.chunkSize == other.chunkSize;
      }
   }

   public String toString() {
      return MoreObjects.toStringHelper(this).add("blob", this.blob).add("position", this.position).add("isOpen", this.isOpen).add("endOfStream", this.endOfStream).toString();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Restorable restore() {
      return this.restore();
   }
}

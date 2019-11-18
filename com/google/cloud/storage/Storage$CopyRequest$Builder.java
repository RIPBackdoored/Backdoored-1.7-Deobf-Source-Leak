package com.google.cloud.storage;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Storage$CopyRequest$Builder {
   private final Set sourceOptions = new LinkedHashSet();
   private final Set targetOptions = new LinkedHashSet();
   private BlobId source;
   private boolean overrideInfo;
   private BlobInfo target;
   private Long megabytesCopiedPerChunk;

   public Storage$CopyRequest$Builder setSource(String bucket, String blob) {
      this.source = BlobId.of(bucket, blob);
      return this;
   }

   public Storage$CopyRequest$Builder setSource(BlobId source) {
      this.source = source;
      return this;
   }

   public Storage$CopyRequest$Builder setSourceOptions(Storage$BlobSourceOption... options) {
      Collections.addAll(this.sourceOptions, options);
      return this;
   }

   public Storage$CopyRequest$Builder setSourceOptions(Iterable options) {
      Iterables.addAll(this.sourceOptions, options);
      return this;
   }

   public Storage$CopyRequest$Builder setTarget(BlobId targetId) {
      this.overrideInfo = false;
      this.target = BlobInfo.newBuilder(targetId).build();
      return this;
   }

   public Storage$CopyRequest$Builder setTarget(BlobId targetId, Storage$BlobTargetOption... options) {
      this.overrideInfo = false;
      this.target = BlobInfo.newBuilder(targetId).build();
      Collections.addAll(this.targetOptions, options);
      return this;
   }

   public Storage$CopyRequest$Builder setTarget(BlobInfo target, Storage$BlobTargetOption... options) {
      this.overrideInfo = true;
      this.target = (BlobInfo)Preconditions.checkNotNull(target);
      Collections.addAll(this.targetOptions, options);
      return this;
   }

   public Storage$CopyRequest$Builder setTarget(BlobInfo target, Iterable options) {
      this.overrideInfo = true;
      this.target = (BlobInfo)Preconditions.checkNotNull(target);
      Iterables.addAll(this.targetOptions, options);
      return this;
   }

   public Storage$CopyRequest$Builder setTarget(BlobId targetId, Iterable options) {
      this.overrideInfo = false;
      this.target = BlobInfo.newBuilder(targetId).build();
      Iterables.addAll(this.targetOptions, options);
      return this;
   }

   public Storage$CopyRequest$Builder setMegabytesCopiedPerChunk(Long megabytesCopiedPerChunk) {
      this.megabytesCopiedPerChunk = megabytesCopiedPerChunk;
      return this;
   }

   public Storage$CopyRequest build() {
      return new Storage$CopyRequest(this, (Storage$1)null);
   }

   // $FF: synthetic method
   static BlobId access$700(Storage$CopyRequest$Builder x0) {
      return x0.source;
   }

   // $FF: synthetic method
   static Set access$800(Storage$CopyRequest$Builder x0) {
      return x0.sourceOptions;
   }

   // $FF: synthetic method
   static boolean access$900(Storage$CopyRequest$Builder x0) {
      return x0.overrideInfo;
   }

   // $FF: synthetic method
   static BlobInfo access$1000(Storage$CopyRequest$Builder x0) {
      return x0.target;
   }

   // $FF: synthetic method
   static Set access$1100(Storage$CopyRequest$Builder x0) {
      return x0.targetOptions;
   }

   // $FF: synthetic method
   static Long access$1200(Storage$CopyRequest$Builder x0) {
      return x0.megabytesCopiedPerChunk;
   }
}

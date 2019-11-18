package com.google.cloud.storage;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.List;

public class Storage$ComposeRequest implements Serializable {
   private static final long serialVersionUID = -7385681353748590911L;
   private final List sourceBlobs;
   private final BlobInfo target;
   private final List targetOptions;

   private Storage$ComposeRequest(Storage$ComposeRequest$Builder builder) {
      this.sourceBlobs = ImmutableList.copyOf(Storage$ComposeRequest$Builder.access$300(builder));
      this.target = Storage$ComposeRequest$Builder.access$400(builder);
      this.targetOptions = ImmutableList.copyOf(Storage$ComposeRequest$Builder.access$500(builder));
   }

   public List getSourceBlobs() {
      return this.sourceBlobs;
   }

   public BlobInfo getTarget() {
      return this.target;
   }

   public List getTargetOptions() {
      return this.targetOptions;
   }

   public static Storage$ComposeRequest of(Iterable sources, BlobInfo target) {
      return newBuilder().setTarget(target).addSource(sources).build();
   }

   public static Storage$ComposeRequest of(String bucket, Iterable sources, String target) {
      return of(sources, BlobInfo.newBuilder(BlobId.of(bucket, target)).build());
   }

   public static Storage$ComposeRequest$Builder newBuilder() {
      return new Storage$ComposeRequest$Builder();
   }

   // $FF: synthetic method
   Storage$ComposeRequest(Storage$ComposeRequest$Builder x0, Storage$1 x1) {
      this(x0);
   }
}

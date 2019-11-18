package com.google.cloud.storage;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Storage$ComposeRequest$Builder {
   private final List sourceBlobs = new LinkedList();
   private final Set targetOptions = new LinkedHashSet();
   private BlobInfo target;

   public Storage$ComposeRequest$Builder addSource(Iterable blobs) {
      Iterator var2 = blobs.iterator();

      while(var2.hasNext()) {
         String blob = (String)var2.next();
         this.sourceBlobs.add(new Storage$ComposeRequest$SourceBlob(blob));
      }

      return this;
   }

   public Storage$ComposeRequest$Builder addSource(String... blobs) {
      return this.addSource((Iterable)Arrays.asList(blobs));
   }

   public Storage$ComposeRequest$Builder addSource(String blob, long generation) {
      this.sourceBlobs.add(new Storage$ComposeRequest$SourceBlob(blob, generation));
      return this;
   }

   public Storage$ComposeRequest$Builder setTarget(BlobInfo target) {
      this.target = target;
      return this;
   }

   public Storage$ComposeRequest$Builder setTargetOptions(Storage$BlobTargetOption... options) {
      Collections.addAll(this.targetOptions, options);
      return this;
   }

   public Storage$ComposeRequest$Builder setTargetOptions(Iterable options) {
      Iterables.addAll(this.targetOptions, options);
      return this;
   }

   public Storage$ComposeRequest build() {
      Preconditions.checkArgument(!this.sourceBlobs.isEmpty());
      Preconditions.checkNotNull(this.target);
      return new Storage$ComposeRequest(this, (Storage$1)null);
   }

   // $FF: synthetic method
   static List access$300(Storage$ComposeRequest$Builder x0) {
      return x0.sourceBlobs;
   }

   // $FF: synthetic method
   static BlobInfo access$400(Storage$ComposeRequest$Builder x0) {
      return x0.target;
   }

   // $FF: synthetic method
   static Set access$500(Storage$ComposeRequest$Builder x0) {
      return x0.targetOptions;
   }
}

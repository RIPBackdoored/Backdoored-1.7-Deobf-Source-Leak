package com.google.cloud.storage;

import com.google.cloud.Tuple;
import java.util.concurrent.Callable;

class BlobReadChannel$1 implements Callable {
   // $FF: synthetic field
   final int val$toRead;
   // $FF: synthetic field
   final BlobReadChannel this$0;

   BlobReadChannel$1(BlobReadChannel this$0, int var2) {
      this.this$0 = this$0;
      this.val$toRead = var2;
   }

   public Tuple call() {
      return BlobReadChannel.access$300(this.this$0).read(BlobReadChannel.access$000(this.this$0), BlobReadChannel.access$100(this.this$0), BlobReadChannel.access$200(this.this$0), this.val$toRead);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

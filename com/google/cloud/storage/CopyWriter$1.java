package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$RewriteResponse;
import java.util.concurrent.Callable;

class CopyWriter$1 implements Callable {
   // $FF: synthetic field
   final CopyWriter this$0;

   CopyWriter$1(CopyWriter this$0) {
      this.this$0 = this$0;
   }

   public StorageRpc$RewriteResponse call() {
      return CopyWriter.access$100(this.this$0).continueRewrite(CopyWriter.access$000(this.this$0));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

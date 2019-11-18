package com.google.cloud.storage;

import java.util.concurrent.Callable;

class StorageImpl$38 implements Callable {
   // $FF: synthetic field
   final HmacKey$HmacKeyMetadata val$metadata;
   // $FF: synthetic field
   final Storage$DeleteHmacKeyOption[] val$options;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$38(StorageImpl this$0, HmacKey$HmacKeyMetadata var2, Storage$DeleteHmacKeyOption[] var3) {
      this.this$0 = this$0;
      this.val$metadata = var2;
      this.val$options = var3;
   }

   public Void call() {
      StorageImpl.access$000(this.this$0).deleteHmacKey(this.val$metadata.toPb(), StorageImpl.access$400(this.val$options));
      return null;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

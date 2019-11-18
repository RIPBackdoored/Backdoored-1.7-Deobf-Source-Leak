package com.google.cloud.storage;

import com.google.api.services.storage.model.HmacKeyMetadata;
import java.util.concurrent.Callable;

class StorageImpl$37 implements Callable {
   // $FF: synthetic field
   final HmacKey$HmacKeyMetadata val$hmacKeyMetadata;
   // $FF: synthetic field
   final Storage$UpdateHmacKeyOption[] val$options;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$37(StorageImpl this$0, HmacKey$HmacKeyMetadata var2, Storage$UpdateHmacKeyOption[] var3) {
      this.this$0 = this$0;
      this.val$hmacKeyMetadata = var2;
      this.val$options = var3;
   }

   public HmacKeyMetadata call() {
      return StorageImpl.access$000(this.this$0).updateHmacKey(this.val$hmacKeyMetadata.toPb(), StorageImpl.access$400(this.val$options));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

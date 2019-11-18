package com.google.cloud.storage;

import com.google.api.services.storage.model.HmacKeyMetadata;
import java.util.concurrent.Callable;

class StorageImpl$36 implements Callable {
   // $FF: synthetic field
   final String val$accessId;
   // $FF: synthetic field
   final Storage$GetHmacKeyOption[] val$options;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$36(StorageImpl this$0, String var2, Storage$GetHmacKeyOption[] var3) {
      this.this$0 = this$0;
      this.val$accessId = var2;
      this.val$options = var3;
   }

   public HmacKeyMetadata call() {
      return StorageImpl.access$000(this.this$0).getHmacKey(this.val$accessId, StorageImpl.access$400(this.val$options));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

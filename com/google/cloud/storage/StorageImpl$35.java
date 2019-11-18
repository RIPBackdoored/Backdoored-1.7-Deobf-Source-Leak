package com.google.cloud.storage;

import java.util.concurrent.Callable;

class StorageImpl$35 implements Callable {
   // $FF: synthetic field
   final ServiceAccount val$serviceAccount;
   // $FF: synthetic field
   final Storage$CreateHmacKeyOption[] val$options;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$35(StorageImpl this$0, ServiceAccount var2, Storage$CreateHmacKeyOption[] var3) {
      this.this$0 = this$0;
      this.val$serviceAccount = var2;
      this.val$options = var3;
   }

   public com.google.api.services.storage.model.HmacKey call() {
      return StorageImpl.access$000(this.this$0).createHmacKey(this.val$serviceAccount.getEmail(), StorageImpl.access$400(this.val$options));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

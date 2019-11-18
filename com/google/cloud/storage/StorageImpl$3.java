package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$3 implements Callable {
   // $FF: synthetic field
   final StorageObject val$blobPb;
   // $FF: synthetic field
   final byte[] val$content;
   // $FF: synthetic field
   final Map val$optionsMap;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$3(StorageImpl this$0, StorageObject var2, byte[] var3, Map var4) {
      this.this$0 = this$0;
      this.val$blobPb = var2;
      this.val$content = var3;
      this.val$optionsMap = var4;
   }

   public StorageObject call() {
      return StorageImpl.access$000(this.this$0).create(this.val$blobPb, new ByteArrayInputStream(this.val$content), this.val$optionsMap);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

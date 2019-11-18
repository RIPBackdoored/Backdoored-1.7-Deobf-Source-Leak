package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

class StorageImpl$14 implements Callable {
   // $FF: synthetic field
   final List val$sources;
   // $FF: synthetic field
   final StorageObject val$target;
   // $FF: synthetic field
   final Map val$targetOptions;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$14(StorageImpl this$0, List var2, StorageObject var3, Map var4) {
      this.this$0 = this$0;
      this.val$sources = var2;
      this.val$target = var3;
      this.val$targetOptions = var4;
   }

   public StorageObject call() {
      return StorageImpl.access$000(this.this$0).compose(this.val$sources, this.val$target, this.val$targetOptions);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

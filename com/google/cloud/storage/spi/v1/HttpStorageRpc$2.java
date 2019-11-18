package com.google.cloud.storage.spi.v1;

import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.Function;
import java.math.BigInteger;

final class HttpStorageRpc$2 implements Function {
   // $FF: synthetic field
   final String val$bucket;

   HttpStorageRpc$2(String var1) {
      this.val$bucket = var1;
   }

   public StorageObject apply(String prefix) {
      return (new StorageObject()).set("isDirectory", true).setBucket(this.val$bucket).setName(prefix).setSize(BigInteger.ZERO);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((String)var1);
   }
}

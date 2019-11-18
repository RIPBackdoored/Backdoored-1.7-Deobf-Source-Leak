package com.google.cloud.storage;

import com.google.api.services.storage.model.HmacKeyMetadata;
import com.google.common.base.Function;

final class StorageImpl$40 implements Function {
   public HmacKey$HmacKeyMetadata apply(HmacKeyMetadata metadataPb) {
      return HmacKey$HmacKeyMetadata.fromPb(metadataPb);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((HmacKeyMetadata)var1);
   }
}

package com.google.cloud.storage;

import com.google.common.base.Function;

final class ServiceAccount$2 implements Function {
   public com.google.api.services.storage.model.ServiceAccount apply(ServiceAccount metadata) {
      return metadata.toPb();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((ServiceAccount)var1);
   }
}

package com.google.cloud.storage;

import com.google.common.base.Function;

final class ServiceAccount$1 implements Function {
   public ServiceAccount apply(com.google.api.services.storage.model.ServiceAccount pb) {
      return ServiceAccount.fromPb(pb);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((com.google.api.services.storage.model.ServiceAccount)var1);
   }
}

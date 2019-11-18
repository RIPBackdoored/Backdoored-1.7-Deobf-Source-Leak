package com.google.cloud.storage;

import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.common.base.Function;

final class Acl$1 implements Function {
   public Acl apply(ObjectAccessControl aclPb) {
      return Acl.fromPb(aclPb);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((ObjectAccessControl)var1);
   }
}

package com.google.cloud.storage;

import com.google.common.base.Function;
import java.util.Set;

class StorageImpl$44 implements Function {
   // $FF: synthetic field
   final Set val$heldPermissions;
   // $FF: synthetic field
   final StorageImpl this$0;

   StorageImpl$44(StorageImpl this$0, Set var2) {
      this.this$0 = this$0;
      this.val$heldPermissions = var2;
   }

   public Boolean apply(String permission) {
      return this.val$heldPermissions.contains(permission);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((String)var1);
   }
}

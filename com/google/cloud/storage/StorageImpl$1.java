package com.google.cloud.storage;

import com.google.cloud.Tuple;
import com.google.common.base.Function;

final class StorageImpl$1 implements Function {
   public Boolean apply(Tuple tuple) {
      return (Boolean)tuple.y();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((Tuple)var1);
   }
}

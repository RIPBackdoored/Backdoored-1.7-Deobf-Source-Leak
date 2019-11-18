package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.Tuple;
import com.google.common.base.Function;

final class Blob$1 implements Function {
   public Blob apply(Tuple pb) {
      return Blob.fromPb((Storage)pb.x(), (StorageObject)pb.y());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((Tuple)var1);
   }
}

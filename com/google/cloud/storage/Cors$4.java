package com.google.cloud.storage;

import com.google.common.base.Function;

final class Cors$4 implements Function {
   public Cors$Origin apply(String value) {
      return Cors$Origin.of(value);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((String)var1);
   }
}

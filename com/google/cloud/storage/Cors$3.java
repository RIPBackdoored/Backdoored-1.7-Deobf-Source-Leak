package com.google.cloud.storage;

import com.google.common.base.Function;

final class Cors$3 implements Function {
   public HttpMethod apply(String name) {
      return HttpMethod.valueOf(name.toUpperCase());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((String)var1);
   }
}

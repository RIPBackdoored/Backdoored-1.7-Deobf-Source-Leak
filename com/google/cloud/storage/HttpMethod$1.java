package com.google.cloud.storage;

import com.google.api.core.ApiFunction;

final class HttpMethod$1 implements ApiFunction {
   public HttpMethod apply(String constant) {
      return new HttpMethod(constant, (HttpMethod$1)null);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object apply(Object var1) {
      return this.apply((String)var1);
   }
}

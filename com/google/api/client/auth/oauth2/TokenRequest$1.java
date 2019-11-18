package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import java.io.IOException;

class TokenRequest$1 implements HttpRequestInitializer {
   // $FF: synthetic field
   final TokenRequest this$0;

   TokenRequest$1(TokenRequest this$0) {
      this.this$0 = this$0;
   }

   public void initialize(HttpRequest request) throws IOException {
      if (this.this$0.requestInitializer != null) {
         this.this$0.requestInitializer.initialize(request);
      }

      HttpExecuteInterceptor interceptor = request.getInterceptor();
      request.setInterceptor(new TokenRequest$1$1(this, interceptor));
   }
}

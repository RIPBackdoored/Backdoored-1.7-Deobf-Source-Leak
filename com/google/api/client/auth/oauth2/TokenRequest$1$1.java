package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;

class TokenRequest$1$1 implements HttpExecuteInterceptor {
   // $FF: synthetic field
   final HttpExecuteInterceptor val$interceptor;
   // $FF: synthetic field
   final TokenRequest$1 this$1;

   TokenRequest$1$1(TokenRequest$1 this$1, HttpExecuteInterceptor var2) {
      this.this$1 = this$1;
      this.val$interceptor = var2;
   }

   public void intercept(HttpRequest request) throws IOException {
      if (this.val$interceptor != null) {
         this.val$interceptor.intercept(request);
      }

      if (this.this$1.this$0.clientAuthentication != null) {
         this.this$1.this$0.clientAuthentication.intercept(request);
      }

   }
}

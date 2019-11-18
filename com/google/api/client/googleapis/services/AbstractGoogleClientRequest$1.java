package com.google.api.client.googleapis.services;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseInterceptor;
import java.io.IOException;

class AbstractGoogleClientRequest$1 implements HttpResponseInterceptor {
   // $FF: synthetic field
   final HttpResponseInterceptor val$responseInterceptor;
   // $FF: synthetic field
   final HttpRequest val$httpRequest;
   // $FF: synthetic field
   final AbstractGoogleClientRequest this$0;

   AbstractGoogleClientRequest$1(AbstractGoogleClientRequest var1, HttpResponseInterceptor var2, HttpRequest var3) {
      this.this$0 = var1;
      this.val$responseInterceptor = var2;
      this.val$httpRequest = var3;
   }

   public void interceptResponse(HttpResponse response) throws IOException {
      if (this.val$responseInterceptor != null) {
         this.val$responseInterceptor.interceptResponse(response);
      }

      if (!response.isSuccessStatusCode() && this.val$httpRequest.getThrowExceptionOnExecuteError()) {
         throw this.this$0.newExceptionOnError(response);
      }
   }
}

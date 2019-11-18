package com.google.api.client.http;

import java.util.concurrent.Callable;

class HttpRequest$1 implements Callable {
   // $FF: synthetic field
   final HttpRequest this$0;

   HttpRequest$1(HttpRequest this$0) {
      this.this$0 = this$0;
   }

   public HttpResponse call() throws Exception {
      return this.this$0.execute();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object call() throws Exception {
      return this.call();
   }
}

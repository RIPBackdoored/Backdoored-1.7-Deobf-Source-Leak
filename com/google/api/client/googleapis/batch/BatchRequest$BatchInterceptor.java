package com.google.api.client.googleapis.batch;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import java.util.Iterator;

class BatchRequest$BatchInterceptor implements HttpExecuteInterceptor {
   private HttpExecuteInterceptor originalInterceptor;
   // $FF: synthetic field
   final BatchRequest this$0;

   BatchRequest$BatchInterceptor(BatchRequest var1, HttpExecuteInterceptor originalInterceptor) {
      this.this$0 = var1;
      this.originalInterceptor = originalInterceptor;
   }

   public void intercept(HttpRequest batchRequest) throws IOException {
      if (this.originalInterceptor != null) {
         this.originalInterceptor.intercept(batchRequest);
      }

      Iterator i$ = this.this$0.requestInfos.iterator();

      while(i$.hasNext()) {
         BatchRequest$RequestInfo requestInfo = (BatchRequest$RequestInfo)i$.next();
         HttpExecuteInterceptor interceptor = requestInfo.request.getInterceptor();
         if (interceptor != null) {
            interceptor.intercept(requestInfo.request);
         }
      }

   }
}

package com.google.api.client.testing.http.apache;

import com.google.api.client.util.Beta;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.RequestDirector;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.protocol.HttpContext;

class MockHttpClient$1 implements RequestDirector {
   // $FF: synthetic field
   final MockHttpClient this$0;

   MockHttpClient$1(MockHttpClient this$0) {
      this.this$0 = this$0;
   }

   @Beta
   public HttpResponse execute(HttpHost target, HttpRequest request, HttpContext context) throws HttpException, IOException {
      return new BasicHttpResponse(HttpVersion.HTTP_1_1, this.this$0.responseCode, (String)null);
   }
}

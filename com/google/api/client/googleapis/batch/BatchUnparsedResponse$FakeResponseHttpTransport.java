package com.google.api.client.googleapis.batch;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import java.io.InputStream;
import java.util.List;

class BatchUnparsedResponse$FakeResponseHttpTransport extends HttpTransport {
   private int statusCode;
   private InputStream partContent;
   private List headerNames;
   private List headerValues;

   BatchUnparsedResponse$FakeResponseHttpTransport(int statusCode, InputStream partContent, List headerNames, List headerValues) {
      this.statusCode = statusCode;
      this.partContent = partContent;
      this.headerNames = headerNames;
      this.headerValues = headerValues;
   }

   protected LowLevelHttpRequest buildRequest(String method, String url) {
      return new BatchUnparsedResponse$FakeLowLevelHttpRequest(this.partContent, this.statusCode, this.headerNames, this.headerValues);
   }
}

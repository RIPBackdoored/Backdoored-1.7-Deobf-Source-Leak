package com.google.api.client.googleapis.batch;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import java.io.InputStream;
import java.util.List;

class BatchUnparsedResponse$FakeLowLevelHttpRequest extends LowLevelHttpRequest {
   private InputStream partContent;
   private int statusCode;
   private List headerNames;
   private List headerValues;

   BatchUnparsedResponse$FakeLowLevelHttpRequest(InputStream partContent, int statusCode, List headerNames, List headerValues) {
      this.partContent = partContent;
      this.statusCode = statusCode;
      this.headerNames = headerNames;
      this.headerValues = headerValues;
   }

   public void addHeader(String name, String value) {
   }

   public LowLevelHttpResponse execute() {
      BatchUnparsedResponse$FakeLowLevelHttpResponse response = new BatchUnparsedResponse$FakeLowLevelHttpResponse(this.partContent, this.statusCode, this.headerNames, this.headerValues);
      return response;
   }
}

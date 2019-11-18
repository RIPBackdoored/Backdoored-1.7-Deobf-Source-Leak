package com.google.api.client.googleapis.batch;

import com.google.api.client.http.LowLevelHttpResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class BatchUnparsedResponse$FakeLowLevelHttpResponse extends LowLevelHttpResponse {
   private InputStream partContent;
   private int statusCode;
   private List headerNames = new ArrayList();
   private List headerValues = new ArrayList();

   BatchUnparsedResponse$FakeLowLevelHttpResponse(InputStream partContent, int statusCode, List headerNames, List headerValues) {
      this.partContent = partContent;
      this.statusCode = statusCode;
      this.headerNames = headerNames;
      this.headerValues = headerValues;
   }

   public InputStream getContent() {
      return this.partContent;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public String getContentEncoding() {
      return null;
   }

   public long getContentLength() {
      return 0L;
   }

   public String getContentType() {
      return null;
   }

   public String getStatusLine() {
      return null;
   }

   public String getReasonPhrase() {
      return null;
   }

   public int getHeaderCount() {
      return this.headerNames.size();
   }

   public String getHeaderName(int index) {
      return (String)this.headerNames.get(index);
   }

   public String getHeaderValue(int index) {
      return (String)this.headerValues.get(index);
   }
}

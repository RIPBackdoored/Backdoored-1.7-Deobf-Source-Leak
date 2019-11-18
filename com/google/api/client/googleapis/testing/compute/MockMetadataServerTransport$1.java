package com.google.api.client.googleapis.testing.compute;

import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import java.io.IOException;

class MockMetadataServerTransport$1 extends MockLowLevelHttpRequest {
   // $FF: synthetic field
   final MockMetadataServerTransport this$0;

   MockMetadataServerTransport$1(MockMetadataServerTransport var1, String x0) {
      super(x0);
      this.this$0 = var1;
   }

   public LowLevelHttpResponse execute() throws IOException {
      if (this.this$0.tokenRequestStatusCode != null) {
         MockLowLevelHttpResponse response = (new MockLowLevelHttpResponse()).setStatusCode(this.this$0.tokenRequestStatusCode).setContent("Token Fetch Error");
         return response;
      } else {
         String metadataRequestHeader = this.getFirstHeaderValue("Metadata-Flavor");
         if (!"Google".equals(metadataRequestHeader)) {
            throw new IOException("Metadata request header not found.");
         } else {
            GenericJson refreshContents = new GenericJson();
            refreshContents.setFactory(MockMetadataServerTransport.JSON_FACTORY);
            refreshContents.put("access_token", this.this$0.accessToken);
            refreshContents.put("expires_in", 3600000);
            refreshContents.put("token_type", "Bearer");
            String refreshText = refreshContents.toPrettyString();
            MockLowLevelHttpResponse response = (new MockLowLevelHttpResponse()).setContentType("application/json; charset=UTF-8").setContent(refreshText);
            return response;
         }
      }
   }
}

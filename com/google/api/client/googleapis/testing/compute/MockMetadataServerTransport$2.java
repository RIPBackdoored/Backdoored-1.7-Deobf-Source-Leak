package com.google.api.client.googleapis.testing.compute;

import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;

class MockMetadataServerTransport$2 extends MockLowLevelHttpRequest {
   // $FF: synthetic field
   final MockMetadataServerTransport this$0;

   MockMetadataServerTransport$2(MockMetadataServerTransport var1, String x0) {
      super(x0);
      this.this$0 = var1;
   }

   public LowLevelHttpResponse execute() {
      MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
      response.addHeader("Metadata-Flavor", "Google");
      return response;
   }
}

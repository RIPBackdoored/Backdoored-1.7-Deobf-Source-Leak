package com.google.api.client.googleapis.testing.compute;

import com.google.api.client.googleapis.auth.oauth2.OAuth2Utils;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
public class MockMetadataServerTransport extends MockHttpTransport {
   private static final String METADATA_SERVER_URL = OAuth2Utils.getMetadataServerUrl();
   private static final String METADATA_TOKEN_SERVER_URL;
   static final JsonFactory JSON_FACTORY;
   String accessToken;
   Integer tokenRequestStatusCode;

   public MockMetadataServerTransport(String accessToken) {
      this.accessToken = accessToken;
   }

   public void setTokenRequestStatusCode(Integer tokenRequestStatusCode) {
      this.tokenRequestStatusCode = tokenRequestStatusCode;
   }

   public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
      if (url.equals(METADATA_TOKEN_SERVER_URL)) {
         MockLowLevelHttpRequest request = new MockMetadataServerTransport$1(this, url);
         return request;
      } else if (url.equals(METADATA_SERVER_URL)) {
         MockLowLevelHttpRequest request = new MockMetadataServerTransport$2(this, url);
         return request;
      } else {
         return super.buildRequest(method, url);
      }
   }

   static {
      METADATA_TOKEN_SERVER_URL = String.valueOf(METADATA_SERVER_URL).concat("/computeMetadata/v1/instance/service-accounts/default/token");
      JSON_FACTORY = new JacksonFactory();
   }
}

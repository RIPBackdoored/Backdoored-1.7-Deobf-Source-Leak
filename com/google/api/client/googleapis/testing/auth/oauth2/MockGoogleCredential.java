package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockHttpTransport$Builder;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Beta;

@Beta
public class MockGoogleCredential extends GoogleCredential {
   public static final String ACCESS_TOKEN = "access_xyz";
   public static final String REFRESH_TOKEN = "refresh123";
   private static final String EXPIRES_IN_SECONDS = "3600";
   private static final String TOKEN_TYPE = "Bearer";
   private static final String TOKEN_RESPONSE = "{\"access_token\": \"%s\", \"expires_in\":  %s, \"refresh_token\": \"%s\", \"token_type\": \"%s\"}";
   private static final String DEFAULT_TOKEN_RESPONSE_JSON = String.format("{\"access_token\": \"%s\", \"expires_in\":  %s, \"refresh_token\": \"%s\", \"token_type\": \"%s\"}", "access_xyz", "3600", "refresh123", "Bearer");

   public MockGoogleCredential(MockGoogleCredential$Builder builder) {
      super(builder);
   }

   public static MockHttpTransport newMockHttpTransportWithSampleTokenResponse() {
      MockLowLevelHttpResponse mockLowLevelHttpResponse = (new MockLowLevelHttpResponse()).setContentType("application/json; charset=UTF-8").setContent(DEFAULT_TOKEN_RESPONSE_JSON);
      MockLowLevelHttpRequest request = (new MockLowLevelHttpRequest()).setResponse(mockLowLevelHttpResponse);
      return (new MockHttpTransport$Builder()).setLowLevelHttpRequest(request).build();
   }
}

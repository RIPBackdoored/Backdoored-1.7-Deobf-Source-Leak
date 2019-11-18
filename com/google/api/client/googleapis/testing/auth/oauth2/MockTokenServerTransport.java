package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Beta
public class MockTokenServerTransport extends MockHttpTransport {
   static final String EXPECTED_GRANT_TYPE = "urn:ietf:params:oauth:grant-type:jwt-bearer";
   static final JsonFactory JSON_FACTORY = new JacksonFactory();
   final String tokenServerUrl;
   Map serviceAccounts;
   Map clients;
   Map refreshTokens;

   public MockTokenServerTransport() {
      this("https://accounts.google.com/o/oauth2/token");
   }

   public MockTokenServerTransport(String tokenServerUrl) {
      this.serviceAccounts = new HashMap();
      this.clients = new HashMap();
      this.refreshTokens = new HashMap();
      this.tokenServerUrl = tokenServerUrl;
   }

   public void addServiceAccount(String email, String accessToken) {
      this.serviceAccounts.put(email, accessToken);
   }

   public void addClient(String clientId, String clientSecret) {
      this.clients.put(clientId, clientSecret);
   }

   public void addRefreshToken(String refreshToken, String accessTokenToReturn) {
      this.refreshTokens.put(refreshToken, accessTokenToReturn);
   }

   public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
      if (url.equals(this.tokenServerUrl)) {
         MockLowLevelHttpRequest request = new MockTokenServerTransport$1(this, url);
         return request;
      } else {
         return super.buildRequest(method, url);
      }
   }
}

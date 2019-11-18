package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.googleapis.testing.TestUtils;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import java.io.IOException;
import java.util.Map;

class MockTokenServerTransport$1 extends MockLowLevelHttpRequest {
   // $FF: synthetic field
   final MockTokenServerTransport this$0;

   MockTokenServerTransport$1(MockTokenServerTransport var1, String x0) {
      super(x0);
      this.this$0 = var1;
   }

   public LowLevelHttpResponse execute() throws IOException {
      String content = this.getContentAsString();
      Map query = TestUtils.parseQuery(content);
      String accessToken = null;
      String foundId = (String)query.get("client_id");
      String grantType;
      String refreshText;
      if (foundId != null) {
         if (!this.this$0.clients.containsKey(foundId)) {
            throw new IOException("Client ID not found.");
         }

         grantType = (String)query.get("client_secret");
         refreshText = (String)this.this$0.clients.get(foundId);
         if (grantType == null || !grantType.equals(refreshText)) {
            throw new IOException("Client secret not found.");
         }

         String foundRefresh = (String)query.get("refresh_token");
         if (!this.this$0.refreshTokens.containsKey(foundRefresh)) {
            throw new IOException("Refresh Token not found.");
         }

         accessToken = (String)this.this$0.refreshTokens.get(foundRefresh);
      } else {
         if (!query.containsKey("grant_type")) {
            throw new IOException("Unknown token type.");
         }

         grantType = (String)query.get("grant_type");
         if (!"urn:ietf:params:oauth:grant-type:jwt-bearer".equals(grantType)) {
            throw new IOException("Unexpected Grant Type.");
         }

         refreshText = (String)query.get("assertion");
         JsonWebSignature signature = JsonWebSignature.parse(MockTokenServerTransport.JSON_FACTORY, refreshText);
         String foundEmail = signature.getPayload().getIssuer();
         if (!this.this$0.serviceAccounts.containsKey(foundEmail)) {
            throw new IOException("Service Account Email not found as issuer.");
         }

         accessToken = (String)this.this$0.serviceAccounts.get(foundEmail);
         String foundScopes = (String)signature.getPayload().get("scope");
         if (foundScopes == null || foundScopes.length() == 0) {
            throw new IOException("Scopes not found.");
         }
      }

      GenericJson refreshContents = new GenericJson();
      refreshContents.setFactory(MockTokenServerTransport.JSON_FACTORY);
      refreshContents.put("access_token", accessToken);
      refreshContents.put("expires_in", 3600000);
      refreshContents.put("token_type", "Bearer");
      refreshText = refreshContents.toPrettyString();
      MockLowLevelHttpResponse response = (new MockLowLevelHttpResponse()).setContentType("application/json; charset=UTF-8").setContent(refreshText);
      return response;
   }
}

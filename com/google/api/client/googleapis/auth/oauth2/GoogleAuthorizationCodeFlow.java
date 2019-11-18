package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import java.util.Collection;

public class GoogleAuthorizationCodeFlow extends AuthorizationCodeFlow {
   private final String approvalPrompt;
   private final String accessType;

   public GoogleAuthorizationCodeFlow(HttpTransport transport, JsonFactory jsonFactory, String clientId, String clientSecret, Collection scopes) {
      this(new GoogleAuthorizationCodeFlow$Builder(transport, jsonFactory, clientId, clientSecret, scopes));
   }

   protected GoogleAuthorizationCodeFlow(GoogleAuthorizationCodeFlow$Builder builder) {
      super(builder);
      this.accessType = builder.accessType;
      this.approvalPrompt = builder.approvalPrompt;
   }

   public GoogleAuthorizationCodeTokenRequest newTokenRequest(String authorizationCode) {
      return (new GoogleAuthorizationCodeTokenRequest(this.getTransport(), this.getJsonFactory(), this.getTokenServerEncodedUrl(), "", "", authorizationCode, "")).setClientAuthentication(this.getClientAuthentication()).setRequestInitializer(this.getRequestInitializer()).setScopes(this.getScopes());
   }

   public GoogleAuthorizationCodeRequestUrl newAuthorizationUrl() {
      return (new GoogleAuthorizationCodeRequestUrl(this.getAuthorizationServerEncodedUrl(), this.getClientId(), "", this.getScopes())).setAccessType(this.accessType).setApprovalPrompt(this.approvalPrompt);
   }

   public final String getApprovalPrompt() {
      return this.approvalPrompt;
   }

   public final String getAccessType() {
      return this.accessType;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeTokenRequest newTokenRequest(String var1) {
      return this.newTokenRequest(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeRequestUrl newAuthorizationUrl() {
      return this.newAuthorizationUrl();
   }
}

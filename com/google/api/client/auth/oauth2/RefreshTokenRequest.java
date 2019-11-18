package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.util.Collection;

public class RefreshTokenRequest extends TokenRequest {
   @Key("refresh_token")
   private String refreshToken;

   public RefreshTokenRequest(HttpTransport transport, JsonFactory jsonFactory, GenericUrl tokenServerUrl, String refreshToken) {
      super(transport, jsonFactory, tokenServerUrl, "refresh_token");
      this.setRefreshToken(refreshToken);
   }

   public RefreshTokenRequest setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (RefreshTokenRequest)super.setRequestInitializer(requestInitializer);
   }

   public RefreshTokenRequest setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (RefreshTokenRequest)super.setTokenServerUrl(tokenServerUrl);
   }

   public RefreshTokenRequest setScopes(Collection scopes) {
      return (RefreshTokenRequest)super.setScopes(scopes);
   }

   public RefreshTokenRequest setGrantType(String grantType) {
      return (RefreshTokenRequest)super.setGrantType(grantType);
   }

   public RefreshTokenRequest setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      return (RefreshTokenRequest)super.setClientAuthentication(clientAuthentication);
   }

   public final String getRefreshToken() {
      return this.refreshToken;
   }

   public RefreshTokenRequest setRefreshToken(String refreshToken) {
      this.refreshToken = (String)Preconditions.checkNotNull(refreshToken);
      return this;
   }

   public RefreshTokenRequest set(String fieldName, Object value) {
      return (RefreshTokenRequest)super.set(fieldName, value);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenRequest setGrantType(String var1) {
      return this.setGrantType(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenRequest setScopes(Collection var1) {
      return this.setScopes(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenRequest setTokenServerUrl(GenericUrl var1) {
      return this.setTokenServerUrl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenRequest setClientAuthentication(HttpExecuteInterceptor var1) {
      return this.setClientAuthentication(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenRequest setRequestInitializer(HttpRequestInitializer var1) {
      return this.setRequestInitializer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }
}

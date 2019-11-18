package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.RefreshTokenRequest;
import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.GenericData;
import java.io.IOException;
import java.util.Collection;

public class GoogleRefreshTokenRequest extends RefreshTokenRequest {
   public GoogleRefreshTokenRequest(HttpTransport transport, JsonFactory jsonFactory, String refreshToken, String clientId, String clientSecret) {
      super(transport, jsonFactory, new GenericUrl("https://accounts.google.com/o/oauth2/token"), refreshToken);
      this.setClientAuthentication(new ClientParametersAuthentication(clientId, clientSecret));
   }

   public GoogleRefreshTokenRequest setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (GoogleRefreshTokenRequest)super.setRequestInitializer(requestInitializer);
   }

   public GoogleRefreshTokenRequest setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (GoogleRefreshTokenRequest)super.setTokenServerUrl(tokenServerUrl);
   }

   public GoogleRefreshTokenRequest setScopes(Collection scopes) {
      return (GoogleRefreshTokenRequest)super.setScopes(scopes);
   }

   public GoogleRefreshTokenRequest setGrantType(String grantType) {
      return (GoogleRefreshTokenRequest)super.setGrantType(grantType);
   }

   public GoogleRefreshTokenRequest setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      return (GoogleRefreshTokenRequest)super.setClientAuthentication(clientAuthentication);
   }

   public GoogleRefreshTokenRequest setRefreshToken(String refreshToken) {
      return (GoogleRefreshTokenRequest)super.setRefreshToken(refreshToken);
   }

   public GoogleTokenResponse execute() throws IOException {
      return (GoogleTokenResponse)this.executeUnparsed().parseAs(GoogleTokenResponse.class);
   }

   public GoogleRefreshTokenRequest set(String fieldName, Object value) {
      return (GoogleRefreshTokenRequest)super.set(fieldName, value);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public RefreshTokenRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public RefreshTokenRequest setRefreshToken(String var1) {
      return this.setRefreshToken(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public RefreshTokenRequest setClientAuthentication(HttpExecuteInterceptor var1) {
      return this.setClientAuthentication(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public RefreshTokenRequest setGrantType(String var1) {
      return this.setGrantType(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public RefreshTokenRequest setScopes(Collection var1) {
      return this.setScopes(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public RefreshTokenRequest setTokenServerUrl(GenericUrl var1) {
      return this.setTokenServerUrl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public RefreshTokenRequest setRequestInitializer(HttpRequestInitializer var1) {
      return this.setRequestInitializer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenResponse execute() throws IOException {
      return this.execute();
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

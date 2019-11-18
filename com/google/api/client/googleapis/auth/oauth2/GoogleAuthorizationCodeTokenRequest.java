package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;

public class GoogleAuthorizationCodeTokenRequest extends AuthorizationCodeTokenRequest {
   public GoogleAuthorizationCodeTokenRequest(HttpTransport transport, JsonFactory jsonFactory, String clientId, String clientSecret, String code, String redirectUri) {
      this(transport, jsonFactory, "https://accounts.google.com/o/oauth2/token", clientId, clientSecret, code, redirectUri);
   }

   public GoogleAuthorizationCodeTokenRequest(HttpTransport transport, JsonFactory jsonFactory, String tokenServerEncodedUrl, String clientId, String clientSecret, String code, String redirectUri) {
      super(transport, jsonFactory, new GenericUrl(tokenServerEncodedUrl), code);
      this.setClientAuthentication(new ClientParametersAuthentication(clientId, clientSecret));
      this.setRedirectUri(redirectUri);
   }

   public GoogleAuthorizationCodeTokenRequest setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (GoogleAuthorizationCodeTokenRequest)super.setRequestInitializer(requestInitializer);
   }

   public GoogleAuthorizationCodeTokenRequest setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (GoogleAuthorizationCodeTokenRequest)super.setTokenServerUrl(tokenServerUrl);
   }

   public GoogleAuthorizationCodeTokenRequest setScopes(Collection scopes) {
      return (GoogleAuthorizationCodeTokenRequest)super.setScopes(scopes);
   }

   public GoogleAuthorizationCodeTokenRequest setGrantType(String grantType) {
      return (GoogleAuthorizationCodeTokenRequest)super.setGrantType(grantType);
   }

   public GoogleAuthorizationCodeTokenRequest setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      Preconditions.checkNotNull(clientAuthentication);
      return (GoogleAuthorizationCodeTokenRequest)super.setClientAuthentication(clientAuthentication);
   }

   public GoogleAuthorizationCodeTokenRequest setCode(String code) {
      return (GoogleAuthorizationCodeTokenRequest)super.setCode(code);
   }

   public GoogleAuthorizationCodeTokenRequest setRedirectUri(String redirectUri) {
      Preconditions.checkNotNull(redirectUri);
      return (GoogleAuthorizationCodeTokenRequest)super.setRedirectUri(redirectUri);
   }

   public GoogleTokenResponse execute() throws IOException {
      return (GoogleTokenResponse)this.executeUnparsed().parseAs(GoogleTokenResponse.class);
   }

   public GoogleAuthorizationCodeTokenRequest set(String fieldName, Object value) {
      return (GoogleAuthorizationCodeTokenRequest)super.set(fieldName, value);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeTokenRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeTokenRequest setRedirectUri(String var1) {
      return this.setRedirectUri(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeTokenRequest setCode(String var1) {
      return this.setCode(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeTokenRequest setClientAuthentication(HttpExecuteInterceptor var1) {
      return this.setClientAuthentication(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeTokenRequest setGrantType(String var1) {
      return this.setGrantType(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeTokenRequest setScopes(Collection var1) {
      return this.setScopes(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeTokenRequest setTokenServerUrl(GenericUrl var1) {
      return this.setTokenServerUrl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeTokenRequest setRequestInitializer(HttpRequestInitializer var1) {
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

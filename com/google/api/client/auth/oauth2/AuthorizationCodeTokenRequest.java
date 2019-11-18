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

public class AuthorizationCodeTokenRequest extends TokenRequest {
   @Key
   private String code;
   @Key("redirect_uri")
   private String redirectUri;

   public AuthorizationCodeTokenRequest(HttpTransport transport, JsonFactory jsonFactory, GenericUrl tokenServerUrl, String code) {
      super(transport, jsonFactory, tokenServerUrl, "authorization_code");
      this.setCode(code);
   }

   public AuthorizationCodeTokenRequest setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (AuthorizationCodeTokenRequest)super.setRequestInitializer(requestInitializer);
   }

   public AuthorizationCodeTokenRequest setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (AuthorizationCodeTokenRequest)super.setTokenServerUrl(tokenServerUrl);
   }

   public AuthorizationCodeTokenRequest setScopes(Collection scopes) {
      return (AuthorizationCodeTokenRequest)super.setScopes(scopes);
   }

   public AuthorizationCodeTokenRequest setGrantType(String grantType) {
      return (AuthorizationCodeTokenRequest)super.setGrantType(grantType);
   }

   public AuthorizationCodeTokenRequest setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      return (AuthorizationCodeTokenRequest)super.setClientAuthentication(clientAuthentication);
   }

   public final String getCode() {
      return this.code;
   }

   public AuthorizationCodeTokenRequest setCode(String code) {
      this.code = (String)Preconditions.checkNotNull(code);
      return this;
   }

   public final String getRedirectUri() {
      return this.redirectUri;
   }

   public AuthorizationCodeTokenRequest setRedirectUri(String redirectUri) {
      this.redirectUri = redirectUri;
      return this;
   }

   public AuthorizationCodeTokenRequest set(String fieldName, Object value) {
      return (AuthorizationCodeTokenRequest)super.set(fieldName, value);
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

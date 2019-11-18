package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.GenericData;
import java.util.Collection;

public class ClientCredentialsTokenRequest extends TokenRequest {
   public ClientCredentialsTokenRequest(HttpTransport transport, JsonFactory jsonFactory, GenericUrl tokenServerUrl) {
      super(transport, jsonFactory, tokenServerUrl, "client_credentials");
   }

   public ClientCredentialsTokenRequest setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (ClientCredentialsTokenRequest)super.setRequestInitializer(requestInitializer);
   }

   public ClientCredentialsTokenRequest setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (ClientCredentialsTokenRequest)super.setTokenServerUrl(tokenServerUrl);
   }

   public ClientCredentialsTokenRequest setScopes(Collection scopes) {
      return (ClientCredentialsTokenRequest)super.setScopes(scopes);
   }

   public ClientCredentialsTokenRequest setGrantType(String grantType) {
      return (ClientCredentialsTokenRequest)super.setGrantType(grantType);
   }

   public ClientCredentialsTokenRequest setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      return (ClientCredentialsTokenRequest)super.setClientAuthentication(clientAuthentication);
   }

   public ClientCredentialsTokenRequest set(String fieldName, Object value) {
      return (ClientCredentialsTokenRequest)super.set(fieldName, value);
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

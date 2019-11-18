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

public class PasswordTokenRequest extends TokenRequest {
   @Key
   private String username;
   @Key
   private String password;

   public PasswordTokenRequest(HttpTransport transport, JsonFactory jsonFactory, GenericUrl tokenServerUrl, String username, String password) {
      super(transport, jsonFactory, tokenServerUrl, "password");
      this.setUsername(username);
      this.setPassword(password);
   }

   public PasswordTokenRequest setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (PasswordTokenRequest)super.setRequestInitializer(requestInitializer);
   }

   public PasswordTokenRequest setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (PasswordTokenRequest)super.setTokenServerUrl(tokenServerUrl);
   }

   public PasswordTokenRequest setScopes(Collection scopes) {
      return (PasswordTokenRequest)super.setScopes(scopes);
   }

   public PasswordTokenRequest setGrantType(String grantType) {
      return (PasswordTokenRequest)super.setGrantType(grantType);
   }

   public PasswordTokenRequest setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      return (PasswordTokenRequest)super.setClientAuthentication(clientAuthentication);
   }

   public final String getUsername() {
      return this.username;
   }

   public PasswordTokenRequest setUsername(String username) {
      this.username = (String)Preconditions.checkNotNull(username);
      return this;
   }

   public final String getPassword() {
      return this.password;
   }

   public PasswordTokenRequest setPassword(String password) {
      this.password = (String)Preconditions.checkNotNull(password);
      return this;
   }

   public PasswordTokenRequest set(String fieldName, Object value) {
      return (PasswordTokenRequest)super.set(fieldName, value);
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

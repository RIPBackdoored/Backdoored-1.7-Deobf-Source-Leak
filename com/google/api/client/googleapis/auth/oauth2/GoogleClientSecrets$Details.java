package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class GoogleClientSecrets$Details extends GenericJson {
   @Key("client_id")
   private String clientId;
   @Key("client_secret")
   private String clientSecret;
   @Key("redirect_uris")
   private List redirectUris;
   @Key("auth_uri")
   private String authUri;
   @Key("token_uri")
   private String tokenUri;

   public String getClientId() {
      return this.clientId;
   }

   public GoogleClientSecrets$Details setClientId(String clientId) {
      this.clientId = clientId;
      return this;
   }

   public String getClientSecret() {
      return this.clientSecret;
   }

   public GoogleClientSecrets$Details setClientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
   }

   public List getRedirectUris() {
      return this.redirectUris;
   }

   public GoogleClientSecrets$Details setRedirectUris(List redirectUris) {
      this.redirectUris = redirectUris;
      return this;
   }

   public String getAuthUri() {
      return this.authUri;
   }

   public GoogleClientSecrets$Details setAuthUri(String authUri) {
      this.authUri = authUri;
      return this;
   }

   public String getTokenUri() {
      return this.tokenUri;
   }

   public GoogleClientSecrets$Details setTokenUri(String tokenUri) {
      this.tokenUri = tokenUri;
      return this;
   }

   public GoogleClientSecrets$Details set(String fieldName, Object value) {
      return (GoogleClientSecrets$Details)super.set(fieldName, value);
   }

   public GoogleClientSecrets$Details clone() {
      return (GoogleClientSecrets$Details)super.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object clone() throws CloneNotSupportedException {
      return this.clone();
   }
}

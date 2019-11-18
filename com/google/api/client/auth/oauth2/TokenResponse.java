package com.google.api.client.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;

public class TokenResponse extends GenericJson {
   @Key("access_token")
   private String accessToken;
   @Key("token_type")
   private String tokenType;
   @Key("expires_in")
   private Long expiresInSeconds;
   @Key("refresh_token")
   private String refreshToken;
   @Key
   private String scope;

   public final String getAccessToken() {
      return this.accessToken;
   }

   public TokenResponse setAccessToken(String accessToken) {
      this.accessToken = (String)Preconditions.checkNotNull(accessToken);
      return this;
   }

   public final String getTokenType() {
      return this.tokenType;
   }

   public TokenResponse setTokenType(String tokenType) {
      this.tokenType = (String)Preconditions.checkNotNull(tokenType);
      return this;
   }

   public final Long getExpiresInSeconds() {
      return this.expiresInSeconds;
   }

   public TokenResponse setExpiresInSeconds(Long expiresInSeconds) {
      this.expiresInSeconds = expiresInSeconds;
      return this;
   }

   public final String getRefreshToken() {
      return this.refreshToken;
   }

   public TokenResponse setRefreshToken(String refreshToken) {
      this.refreshToken = refreshToken;
      return this;
   }

   public final String getScope() {
      return this.scope;
   }

   public TokenResponse setScope(String scope) {
      this.scope = scope;
      return this;
   }

   public TokenResponse set(String fieldName, Object value) {
      return (TokenResponse)super.set(fieldName, value);
   }

   public TokenResponse clone() {
      return (TokenResponse)super.clone();
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

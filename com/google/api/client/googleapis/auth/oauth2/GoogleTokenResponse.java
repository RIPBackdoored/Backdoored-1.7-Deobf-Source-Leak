package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Beta;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

public class GoogleTokenResponse extends TokenResponse {
   @Key("id_token")
   private String idToken;

   public GoogleTokenResponse setAccessToken(String accessToken) {
      return (GoogleTokenResponse)super.setAccessToken(accessToken);
   }

   public GoogleTokenResponse setTokenType(String tokenType) {
      return (GoogleTokenResponse)super.setTokenType(tokenType);
   }

   public GoogleTokenResponse setExpiresInSeconds(Long expiresIn) {
      return (GoogleTokenResponse)super.setExpiresInSeconds(expiresIn);
   }

   public GoogleTokenResponse setRefreshToken(String refreshToken) {
      return (GoogleTokenResponse)super.setRefreshToken(refreshToken);
   }

   public GoogleTokenResponse setScope(String scope) {
      return (GoogleTokenResponse)super.setScope(scope);
   }

   @Beta
   @Beta
   public final String getIdToken() {
      return this.idToken;
   }

   @Beta
   @Beta
   public GoogleTokenResponse setIdToken(String idToken) {
      this.idToken = (String)Preconditions.checkNotNull(idToken);
      return this;
   }

   @Beta
   @Beta
   public GoogleIdToken parseIdToken() throws IOException {
      return GoogleIdToken.parse(this.getFactory(), this.getIdToken());
   }

   public GoogleTokenResponse set(String fieldName, Object value) {
      return (GoogleTokenResponse)super.set(fieldName, value);
   }

   public GoogleTokenResponse clone() {
      return (GoogleTokenResponse)super.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenResponse clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenResponse set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenResponse setScope(String var1) {
      return this.setScope(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenResponse setRefreshToken(String var1) {
      return this.setRefreshToken(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenResponse setExpiresInSeconds(Long var1) {
      return this.setExpiresInSeconds(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenResponse setTokenType(String var1) {
      return this.setTokenType(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public TokenResponse setAccessToken(String var1) {
      return this.setAccessToken(var1);
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

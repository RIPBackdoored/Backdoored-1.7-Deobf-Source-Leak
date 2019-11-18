package com.google.api.client.auth.openidconnect;

import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Beta;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

@Beta
public class IdTokenResponse extends TokenResponse {
   @Key("id_token")
   private String idToken;

   public final String getIdToken() {
      return this.idToken;
   }

   public IdTokenResponse setIdToken(String idToken) {
      this.idToken = (String)Preconditions.checkNotNull(idToken);
      return this;
   }

   public IdTokenResponse setAccessToken(String accessToken) {
      super.setAccessToken(accessToken);
      return this;
   }

   public IdTokenResponse setTokenType(String tokenType) {
      super.setTokenType(tokenType);
      return this;
   }

   public IdTokenResponse setExpiresInSeconds(Long expiresIn) {
      super.setExpiresInSeconds(expiresIn);
      return this;
   }

   public IdTokenResponse setRefreshToken(String refreshToken) {
      super.setRefreshToken(refreshToken);
      return this;
   }

   public IdTokenResponse setScope(String scope) {
      super.setScope(scope);
      return this;
   }

   public IdToken parseIdToken() throws IOException {
      return IdToken.parse(this.getFactory(), this.idToken);
   }

   public static IdTokenResponse execute(TokenRequest tokenRequest) throws IOException {
      return (IdTokenResponse)tokenRequest.executeUnparsed().parseAs(IdTokenResponse.class);
   }

   public IdTokenResponse set(String fieldName, Object value) {
      return (IdTokenResponse)super.set(fieldName, value);
   }

   public IdTokenResponse clone() {
      return (IdTokenResponse)super.clone();
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

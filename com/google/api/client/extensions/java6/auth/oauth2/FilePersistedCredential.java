package com.google.api.client.extensions.java6.auth.oauth2;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Beta;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

/** @deprecated */
@Deprecated
@Beta
public class FilePersistedCredential extends GenericJson {
   @Key("access_token")
   private String accessToken;
   @Key("refresh_token")
   private String refreshToken;
   @Key("expiration_time_millis")
   private Long expirationTimeMillis;

   void store(Credential credential) {
      this.accessToken = credential.getAccessToken();
      this.refreshToken = credential.getRefreshToken();
      this.expirationTimeMillis = credential.getExpirationTimeMilliseconds();
   }

   void load(Credential credential) {
      credential.setAccessToken(this.accessToken);
      credential.setRefreshToken(this.refreshToken);
      credential.setExpirationTimeMilliseconds(this.expirationTimeMillis);
   }

   public FilePersistedCredential set(String fieldName, Object value) {
      return (FilePersistedCredential)super.set(fieldName, value);
   }

   public FilePersistedCredential clone() {
      return (FilePersistedCredential)super.clone();
   }

   StoredCredential toStoredCredential() {
      return (new StoredCredential()).setAccessToken(this.accessToken).setRefreshToken(this.refreshToken).setExpirationTimeMilliseconds(this.expirationTimeMillis);
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

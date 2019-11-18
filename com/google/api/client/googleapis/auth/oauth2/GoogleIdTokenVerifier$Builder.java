package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.openidconnect.IdTokenVerifier;
import com.google.api.client.auth.openidconnect.IdTokenVerifier$Builder;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;
import java.util.Arrays;
import java.util.Collection;

@Beta
public class GoogleIdTokenVerifier$Builder extends IdTokenVerifier$Builder {
   GooglePublicKeysManager publicKeys;

   public GoogleIdTokenVerifier$Builder(HttpTransport transport, JsonFactory jsonFactory) {
      this(new GooglePublicKeysManager(transport, jsonFactory));
   }

   public GoogleIdTokenVerifier$Builder(GooglePublicKeysManager publicKeys) {
      this.publicKeys = (GooglePublicKeysManager)Preconditions.checkNotNull(publicKeys);
      this.setIssuers(Arrays.asList("accounts.google.com", "https://accounts.google.com"));
   }

   public GoogleIdTokenVerifier build() {
      return new GoogleIdTokenVerifier(this);
   }

   public final GooglePublicKeysManager getPublicCerts() {
      return this.publicKeys;
   }

   public final HttpTransport getTransport() {
      return this.publicKeys.getTransport();
   }

   public final JsonFactory getJsonFactory() {
      return this.publicKeys.getJsonFactory();
   }

   /** @deprecated */
   @Deprecated
   @Deprecated
   public final String getPublicCertsEncodedUrl() {
      return this.publicKeys.getPublicCertsEncodedUrl();
   }

   /** @deprecated */
   @Deprecated
   @Deprecated
   public GoogleIdTokenVerifier$Builder setPublicCertsEncodedUrl(String publicKeysEncodedUrl) {
      this.publicKeys = (new GooglePublicKeysManager$Builder(this.getTransport(), this.getJsonFactory())).setPublicCertsEncodedUrl(publicKeysEncodedUrl).setClock(this.publicKeys.getClock()).build();
      return this;
   }

   public GoogleIdTokenVerifier$Builder setIssuer(String issuer) {
      return (GoogleIdTokenVerifier$Builder)super.setIssuer(issuer);
   }

   public GoogleIdTokenVerifier$Builder setIssuers(Collection issuers) {
      return (GoogleIdTokenVerifier$Builder)super.setIssuers(issuers);
   }

   public GoogleIdTokenVerifier$Builder setAudience(Collection audience) {
      return (GoogleIdTokenVerifier$Builder)super.setAudience(audience);
   }

   public GoogleIdTokenVerifier$Builder setAcceptableTimeSkewSeconds(long acceptableTimeSkewSeconds) {
      return (GoogleIdTokenVerifier$Builder)super.setAcceptableTimeSkewSeconds(acceptableTimeSkewSeconds);
   }

   public GoogleIdTokenVerifier$Builder setClock(Clock clock) {
      return (GoogleIdTokenVerifier$Builder)super.setClock(clock);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdTokenVerifier$Builder setAcceptableTimeSkewSeconds(long var1) {
      return this.setAcceptableTimeSkewSeconds(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdTokenVerifier$Builder setAudience(Collection var1) {
      return this.setAudience(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdTokenVerifier$Builder setIssuers(Collection var1) {
      return this.setIssuers(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdTokenVerifier$Builder setIssuer(String var1) {
      return this.setIssuer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdTokenVerifier$Builder setClock(Clock var1) {
      return this.setClock(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdTokenVerifier build() {
      return this.build();
   }
}

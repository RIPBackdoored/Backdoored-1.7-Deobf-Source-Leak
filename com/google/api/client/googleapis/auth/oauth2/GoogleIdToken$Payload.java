package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.openidconnect.IdToken$Payload;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.webtoken.JsonWebToken$Payload;
import com.google.api.client.util.Beta;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

@Beta
public class GoogleIdToken$Payload extends IdToken$Payload {
   @Key("hd")
   private String hostedDomain;
   @Key("email")
   private String email;
   @Key("email_verified")
   private Object emailVerified;

   /** @deprecated */
   @Deprecated
   @Deprecated
   public String getUserId() {
      return this.getSubject();
   }

   /** @deprecated */
   @Deprecated
   @Deprecated
   public GoogleIdToken$Payload setUserId(String userId) {
      return this.setSubject(userId);
   }

   /** @deprecated */
   @Deprecated
   @Deprecated
   public String getIssuee() {
      return this.getAuthorizedParty();
   }

   /** @deprecated */
   @Deprecated
   @Deprecated
   public GoogleIdToken$Payload setIssuee(String issuee) {
      return this.setAuthorizedParty(issuee);
   }

   public String getHostedDomain() {
      return this.hostedDomain;
   }

   public GoogleIdToken$Payload setHostedDomain(String hostedDomain) {
      this.hostedDomain = hostedDomain;
      return this;
   }

   public String getEmail() {
      return this.email;
   }

   public GoogleIdToken$Payload setEmail(String email) {
      this.email = email;
      return this;
   }

   public Boolean getEmailVerified() {
      if (this.emailVerified == null) {
         return null;
      } else {
         return this.emailVerified instanceof Boolean ? (Boolean)this.emailVerified : Boolean.valueOf((String)this.emailVerified);
      }
   }

   public GoogleIdToken$Payload setEmailVerified(Boolean emailVerified) {
      this.emailVerified = emailVerified;
      return this;
   }

   public GoogleIdToken$Payload setAuthorizationTimeSeconds(Long authorizationTimeSeconds) {
      return (GoogleIdToken$Payload)super.setAuthorizationTimeSeconds(authorizationTimeSeconds);
   }

   public GoogleIdToken$Payload setAuthorizedParty(String authorizedParty) {
      return (GoogleIdToken$Payload)super.setAuthorizedParty(authorizedParty);
   }

   public GoogleIdToken$Payload setNonce(String nonce) {
      return (GoogleIdToken$Payload)super.setNonce(nonce);
   }

   public GoogleIdToken$Payload setAccessTokenHash(String accessTokenHash) {
      return (GoogleIdToken$Payload)super.setAccessTokenHash(accessTokenHash);
   }

   public GoogleIdToken$Payload setClassReference(String classReference) {
      return (GoogleIdToken$Payload)super.setClassReference(classReference);
   }

   public GoogleIdToken$Payload setMethodsReferences(List methodsReferences) {
      return (GoogleIdToken$Payload)super.setMethodsReferences(methodsReferences);
   }

   public GoogleIdToken$Payload setExpirationTimeSeconds(Long expirationTimeSeconds) {
      return (GoogleIdToken$Payload)super.setExpirationTimeSeconds(expirationTimeSeconds);
   }

   public GoogleIdToken$Payload setNotBeforeTimeSeconds(Long notBeforeTimeSeconds) {
      return (GoogleIdToken$Payload)super.setNotBeforeTimeSeconds(notBeforeTimeSeconds);
   }

   public GoogleIdToken$Payload setIssuedAtTimeSeconds(Long issuedAtTimeSeconds) {
      return (GoogleIdToken$Payload)super.setIssuedAtTimeSeconds(issuedAtTimeSeconds);
   }

   public GoogleIdToken$Payload setIssuer(String issuer) {
      return (GoogleIdToken$Payload)super.setIssuer(issuer);
   }

   public GoogleIdToken$Payload setAudience(Object audience) {
      return (GoogleIdToken$Payload)super.setAudience(audience);
   }

   public GoogleIdToken$Payload setJwtId(String jwtId) {
      return (GoogleIdToken$Payload)super.setJwtId(jwtId);
   }

   public GoogleIdToken$Payload setType(String type) {
      return (GoogleIdToken$Payload)super.setType(type);
   }

   public GoogleIdToken$Payload setSubject(String subject) {
      return (GoogleIdToken$Payload)super.setSubject(subject);
   }

   public GoogleIdToken$Payload set(String fieldName, Object value) {
      return (GoogleIdToken$Payload)super.set(fieldName, value);
   }

   public GoogleIdToken$Payload clone() {
      return (GoogleIdToken$Payload)super.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setSubject(String var1) {
      return this.setSubject(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setType(String var1) {
      return this.setType(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setJwtId(String var1) {
      return this.setJwtId(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setAudience(Object var1) {
      return this.setAudience(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setIssuer(String var1) {
      return this.setIssuer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setIssuedAtTimeSeconds(Long var1) {
      return this.setIssuedAtTimeSeconds(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setNotBeforeTimeSeconds(Long var1) {
      return this.setNotBeforeTimeSeconds(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setExpirationTimeSeconds(Long var1) {
      return this.setExpirationTimeSeconds(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setMethodsReferences(List var1) {
      return this.setMethodsReferences(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setClassReference(String var1) {
      return this.setClassReference(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setAccessTokenHash(String var1) {
      return this.setAccessTokenHash(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setNonce(String var1) {
      return this.setNonce(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setAuthorizedParty(String var1) {
      return this.setAuthorizedParty(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload setAuthorizationTimeSeconds(Long var1) {
      return this.setAuthorizationTimeSeconds(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload setSubject(String var1) {
      return this.setSubject(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload setType(String var1) {
      return this.setType(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload setJwtId(String var1) {
      return this.setJwtId(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload setAudience(Object var1) {
      return this.setAudience(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload setIssuer(String var1) {
      return this.setIssuer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload setIssuedAtTimeSeconds(Long var1) {
      return this.setIssuedAtTimeSeconds(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload setNotBeforeTimeSeconds(Long var1) {
      return this.setNotBeforeTimeSeconds(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload setExpirationTimeSeconds(Long var1) {
      return this.setExpirationTimeSeconds(var1);
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

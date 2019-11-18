package com.google.api.client.auth.openidconnect;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.webtoken.JsonWebToken$Payload;
import com.google.api.client.util.Beta;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

@Beta
public class IdToken$Payload extends JsonWebToken$Payload {
   @Key("auth_time")
   private Long authorizationTimeSeconds;
   @Key("azp")
   private String authorizedParty;
   @Key
   private String nonce;
   @Key("at_hash")
   private String accessTokenHash;
   @Key("acr")
   private String classReference;
   @Key("amr")
   private List methodsReferences;

   public final Long getAuthorizationTimeSeconds() {
      return this.authorizationTimeSeconds;
   }

   public IdToken$Payload setAuthorizationTimeSeconds(Long authorizationTimeSeconds) {
      this.authorizationTimeSeconds = authorizationTimeSeconds;
      return this;
   }

   public final String getAuthorizedParty() {
      return this.authorizedParty;
   }

   public IdToken$Payload setAuthorizedParty(String authorizedParty) {
      this.authorizedParty = authorizedParty;
      return this;
   }

   public final String getNonce() {
      return this.nonce;
   }

   public IdToken$Payload setNonce(String nonce) {
      this.nonce = nonce;
      return this;
   }

   public final String getAccessTokenHash() {
      return this.accessTokenHash;
   }

   public IdToken$Payload setAccessTokenHash(String accessTokenHash) {
      this.accessTokenHash = accessTokenHash;
      return this;
   }

   public final String getClassReference() {
      return this.classReference;
   }

   public IdToken$Payload setClassReference(String classReference) {
      this.classReference = classReference;
      return this;
   }

   public final List getMethodsReferences() {
      return this.methodsReferences;
   }

   public IdToken$Payload setMethodsReferences(List methodsReferences) {
      this.methodsReferences = methodsReferences;
      return this;
   }

   public IdToken$Payload setExpirationTimeSeconds(Long expirationTimeSeconds) {
      return (IdToken$Payload)super.setExpirationTimeSeconds(expirationTimeSeconds);
   }

   public IdToken$Payload setNotBeforeTimeSeconds(Long notBeforeTimeSeconds) {
      return (IdToken$Payload)super.setNotBeforeTimeSeconds(notBeforeTimeSeconds);
   }

   public IdToken$Payload setIssuedAtTimeSeconds(Long issuedAtTimeSeconds) {
      return (IdToken$Payload)super.setIssuedAtTimeSeconds(issuedAtTimeSeconds);
   }

   public IdToken$Payload setIssuer(String issuer) {
      return (IdToken$Payload)super.setIssuer(issuer);
   }

   public IdToken$Payload setAudience(Object audience) {
      return (IdToken$Payload)super.setAudience(audience);
   }

   public IdToken$Payload setJwtId(String jwtId) {
      return (IdToken$Payload)super.setJwtId(jwtId);
   }

   public IdToken$Payload setType(String type) {
      return (IdToken$Payload)super.setType(type);
   }

   public IdToken$Payload setSubject(String subject) {
      return (IdToken$Payload)super.setSubject(subject);
   }

   public IdToken$Payload set(String fieldName, Object value) {
      return (IdToken$Payload)super.set(fieldName, value);
   }

   public IdToken$Payload clone() {
      return (IdToken$Payload)super.clone();
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

package com.google.api.client.json.webtoken;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.ArrayList;
import java.util.List;

public class JsonWebSignature$Header extends JsonWebToken$Header {
   @Key("alg")
   private String algorithm;
   @Key("jku")
   private String jwkUrl;
   @Key("jwk")
   private String jwk;
   @Key("kid")
   private String keyId;
   @Key("x5u")
   private String x509Url;
   @Key("x5t")
   private String x509Thumbprint;
   @Key("x5c")
   private List x509Certificates;
   @Key("crit")
   private List critical;

   public JsonWebSignature$Header setType(String type) {
      super.setType(type);
      return this;
   }

   public final String getAlgorithm() {
      return this.algorithm;
   }

   public JsonWebSignature$Header setAlgorithm(String algorithm) {
      this.algorithm = algorithm;
      return this;
   }

   public final String getJwkUrl() {
      return this.jwkUrl;
   }

   public JsonWebSignature$Header setJwkUrl(String jwkUrl) {
      this.jwkUrl = jwkUrl;
      return this;
   }

   public final String getJwk() {
      return this.jwk;
   }

   public JsonWebSignature$Header setJwk(String jwk) {
      this.jwk = jwk;
      return this;
   }

   public final String getKeyId() {
      return this.keyId;
   }

   public JsonWebSignature$Header setKeyId(String keyId) {
      this.keyId = keyId;
      return this;
   }

   public final String getX509Url() {
      return this.x509Url;
   }

   public JsonWebSignature$Header setX509Url(String x509Url) {
      this.x509Url = x509Url;
      return this;
   }

   public final String getX509Thumbprint() {
      return this.x509Thumbprint;
   }

   public JsonWebSignature$Header setX509Thumbprint(String x509Thumbprint) {
      this.x509Thumbprint = x509Thumbprint;
      return this;
   }

   /** @deprecated */
   @Deprecated
   public final String getX509Certificate() {
      return this.x509Certificates != null && !this.x509Certificates.isEmpty() ? (String)this.x509Certificates.get(0) : null;
   }

   public final List getX509Certificates() {
      return this.x509Certificates;
   }

   /** @deprecated */
   @Deprecated
   public JsonWebSignature$Header setX509Certificate(String x509Certificate) {
      ArrayList x509Certificates = new ArrayList();
      x509Certificates.add(x509Certificate);
      this.x509Certificates = x509Certificates;
      return this;
   }

   public JsonWebSignature$Header setX509Certificates(List x509Certificates) {
      this.x509Certificates = x509Certificates;
      return this;
   }

   public final List getCritical() {
      return this.critical;
   }

   public JsonWebSignature$Header setCritical(List critical) {
      this.critical = critical;
      return this;
   }

   public JsonWebSignature$Header set(String fieldName, Object value) {
      return (JsonWebSignature$Header)super.set(fieldName, value);
   }

   public JsonWebSignature$Header clone() {
      return (JsonWebSignature$Header)super.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Header clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Header set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Header setType(String var1) {
      return this.setType(var1);
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

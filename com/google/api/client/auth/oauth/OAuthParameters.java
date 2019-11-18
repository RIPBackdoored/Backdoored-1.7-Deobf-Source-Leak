package com.google.api.client.auth.oauth;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Beta;
import com.google.api.client.util.escape.PercentEscaper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

@Beta
public final class OAuthParameters implements HttpExecuteInterceptor, HttpRequestInitializer {
   private static final SecureRandom RANDOM = new SecureRandom();
   public OAuthSigner signer;
   public String callback;
   public String consumerKey;
   public String nonce;
   public String realm;
   public String signature;
   public String signatureMethod;
   public String timestamp;
   public String token;
   public String verifier;
   public String version;
   private static final PercentEscaper ESCAPER = new PercentEscaper("-_.~", false);

   public void computeNonce() {
      this.nonce = Long.toHexString(Math.abs(RANDOM.nextLong()));
   }

   public void computeTimestamp() {
      this.timestamp = Long.toString(System.currentTimeMillis() / 1000L);
   }

   public void computeSignature(String requestMethod, GenericUrl requestUrl) throws GeneralSecurityException {
      OAuthSigner signer = this.signer;
      String signatureMethod = this.signatureMethod = signer.getSignatureMethod();
      TreeMap parameters = new TreeMap();
      this.putParameterIfValueNotNull(parameters, "oauth_callback", this.callback);
      this.putParameterIfValueNotNull(parameters, "oauth_consumer_key", this.consumerKey);
      this.putParameterIfValueNotNull(parameters, "oauth_nonce", this.nonce);
      this.putParameterIfValueNotNull(parameters, "oauth_signature_method", signatureMethod);
      this.putParameterIfValueNotNull(parameters, "oauth_timestamp", this.timestamp);
      this.putParameterIfValueNotNull(parameters, "oauth_token", this.token);
      this.putParameterIfValueNotNull(parameters, "oauth_verifier", this.verifier);
      this.putParameterIfValueNotNull(parameters, "oauth_version", this.version);
      Iterator var6 = requestUrl.entrySet().iterator();

      while(true) {
         while(true) {
            Entry fieldEntry;
            Object value;
            do {
               if (!var6.hasNext()) {
                  StringBuilder parametersBuf = new StringBuilder();
                  boolean first = true;
                  Iterator var17 = parameters.entrySet().iterator();

                  String value;
                  while(var17.hasNext()) {
                     Entry entry = (Entry)var17.next();
                     if (first) {
                        first = false;
                     } else {
                        parametersBuf.append('&');
                     }

                     parametersBuf.append((String)entry.getKey());
                     value = (String)entry.getValue();
                     if (value != null) {
                        parametersBuf.append('=').append(value);
                     }
                  }

                  String normalizedParameters = parametersBuf.toString();
                  GenericUrl normalized = new GenericUrl();
                  value = requestUrl.getScheme();
                  normalized.setScheme(value);
                  normalized.setHost(requestUrl.getHost());
                  normalized.setPathParts(requestUrl.getPathParts());
                  int port = requestUrl.getPort();
                  if ("http".equals(value) && port == 80 || "https".equals(value) && port == 443) {
                     port = -1;
                  }

                  normalized.setPort(port);
                  String normalizedPath = normalized.build();
                  StringBuilder buf = new StringBuilder();
                  buf.append(escape(requestMethod)).append('&');
                  buf.append(escape(normalizedPath)).append('&');
                  buf.append(escape(normalizedParameters));
                  String signatureBaseString = buf.toString();
                  this.signature = signer.computeSignature(signatureBaseString);
                  return;
               }

               fieldEntry = (Entry)var6.next();
               value = fieldEntry.getValue();
            } while(value == null);

            String name = (String)fieldEntry.getKey();
            if (value instanceof Collection) {
               Iterator var10 = ((Collection)value).iterator();

               while(var10.hasNext()) {
                  Object repeatedValue = var10.next();
                  this.putParameter(parameters, name, repeatedValue);
               }
            } else {
               this.putParameter(parameters, name, value);
            }
         }
      }
   }

   public String getAuthorizationHeader() {
      StringBuilder buf = new StringBuilder("OAuth");
      this.appendParameter(buf, "realm", this.realm);
      this.appendParameter(buf, "oauth_callback", this.callback);
      this.appendParameter(buf, "oauth_consumer_key", this.consumerKey);
      this.appendParameter(buf, "oauth_nonce", this.nonce);
      this.appendParameter(buf, "oauth_signature", this.signature);
      this.appendParameter(buf, "oauth_signature_method", this.signatureMethod);
      this.appendParameter(buf, "oauth_timestamp", this.timestamp);
      this.appendParameter(buf, "oauth_token", this.token);
      this.appendParameter(buf, "oauth_verifier", this.verifier);
      this.appendParameter(buf, "oauth_version", this.version);
      return buf.substring(0, buf.length() - 1);
   }

   private void appendParameter(StringBuilder buf, String name, String value) {
      if (value != null) {
         buf.append(' ').append(escape(name)).append("=\"").append(escape(value)).append("\",");
      }

   }

   private void putParameterIfValueNotNull(TreeMap parameters, String key, String value) {
      if (value != null) {
         this.putParameter(parameters, key, value);
      }

   }

   private void putParameter(TreeMap parameters, String key, Object value) {
      parameters.put(escape(key), value == null ? null : escape(value.toString()));
   }

   public static String escape(String value) {
      return ESCAPER.escape(value);
   }

   public void initialize(HttpRequest request) throws IOException {
      request.setInterceptor(this);
   }

   public void intercept(HttpRequest request) throws IOException {
      this.computeNonce();
      this.computeTimestamp();

      try {
         this.computeSignature(request.getRequestMethod(), request.getUrl());
      } catch (GeneralSecurityException var4) {
         IOException io = new IOException();
         io.initCause(var4);
         throw io;
      }

      request.getHeaders().setAuthorization(this.getAuthorizationHeader());
   }
}

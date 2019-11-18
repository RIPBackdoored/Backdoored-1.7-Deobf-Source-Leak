package com.google.api.client.json.webtoken;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class JsonWebSignature extends JsonWebToken {
   private final byte[] signatureBytes;
   private final byte[] signedContentBytes;

   public JsonWebSignature(JsonWebSignature$Header header, JsonWebToken$Payload payload, byte[] signatureBytes, byte[] signedContentBytes) {
      super(header, payload);
      this.signatureBytes = (byte[])Preconditions.checkNotNull(signatureBytes);
      this.signedContentBytes = (byte[])Preconditions.checkNotNull(signedContentBytes);
   }

   public JsonWebSignature$Header getHeader() {
      return (JsonWebSignature$Header)super.getHeader();
   }

   public final boolean verifySignature(PublicKey publicKey) throws GeneralSecurityException {
      Signature signatureAlg = null;
      String algorithm = this.getHeader().getAlgorithm();
      if ("RS256".equals(algorithm)) {
         signatureAlg = SecurityUtils.getSha256WithRsaSignatureAlgorithm();
         return SecurityUtils.verify(signatureAlg, publicKey, this.signatureBytes, this.signedContentBytes);
      } else {
         return false;
      }
   }

   @Beta
   public final X509Certificate verifySignature(X509TrustManager trustManager) throws GeneralSecurityException {
      List x509Certificates = this.getHeader().getX509Certificates();
      if (x509Certificates != null && !x509Certificates.isEmpty()) {
         String algorithm = this.getHeader().getAlgorithm();
         Signature signatureAlg = null;
         if ("RS256".equals(algorithm)) {
            signatureAlg = SecurityUtils.getSha256WithRsaSignatureAlgorithm();
            return SecurityUtils.verify(signatureAlg, trustManager, x509Certificates, this.signatureBytes, this.signedContentBytes);
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @Beta
   public final X509Certificate verifySignature() throws GeneralSecurityException {
      X509TrustManager trustManager = getDefaultX509TrustManager();
      return trustManager == null ? null : this.verifySignature(trustManager);
   }

   private static X509TrustManager getDefaultX509TrustManager() {
      X509TrustManager var10000;
      try {
         TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         factory.init((KeyStore)null);
         TrustManager[] var1 = factory.getTrustManagers();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            TrustManager manager = var1[var3];
            if (manager instanceof X509TrustManager) {
               var10000 = (X509TrustManager)manager;
               return var10000;
            }
         }

         var10000 = null;
      } catch (NoSuchAlgorithmException var5) {
         return null;
      } catch (KeyStoreException var6) {
         return null;
      }

      return var10000;
   }

   public final byte[] getSignatureBytes() {
      return this.signatureBytes;
   }

   public final byte[] getSignedContentBytes() {
      return this.signedContentBytes;
   }

   public static JsonWebSignature parse(JsonFactory jsonFactory, String tokenString) throws IOException {
      return parser(jsonFactory).parse(tokenString);
   }

   public static JsonWebSignature$Parser parser(JsonFactory jsonFactory) {
      return new JsonWebSignature$Parser(jsonFactory);
   }

   public static String signUsingRsaSha256(PrivateKey privateKey, JsonFactory jsonFactory, JsonWebSignature$Header header, JsonWebToken$Payload payload) throws GeneralSecurityException, IOException {
      String content = Base64.encodeBase64URLSafeString(jsonFactory.toByteArray(header)) + "." + Base64.encodeBase64URLSafeString(jsonFactory.toByteArray(payload));
      byte[] contentBytes = StringUtils.getBytesUtf8(content);
      byte[] signature = SecurityUtils.sign(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), privateKey, contentBytes);
      return content + "." + Base64.encodeBase64URLSafeString(signature);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Header getHeader() {
      return this.getHeader();
   }
}

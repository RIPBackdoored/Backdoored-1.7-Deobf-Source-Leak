package com.google.api.client.util;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public final class SslUtils {
   public static SSLContext getSslContext() throws NoSuchAlgorithmException {
      return SSLContext.getInstance("SSL");
   }

   public static SSLContext getTlsSslContext() throws NoSuchAlgorithmException {
      return SSLContext.getInstance("TLS");
   }

   public static TrustManagerFactory getDefaultTrustManagerFactory() throws NoSuchAlgorithmException {
      return TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
   }

   public static TrustManagerFactory getPkixTrustManagerFactory() throws NoSuchAlgorithmException {
      return TrustManagerFactory.getInstance("PKIX");
   }

   public static KeyManagerFactory getDefaultKeyManagerFactory() throws NoSuchAlgorithmException {
      return KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
   }

   public static KeyManagerFactory getPkixKeyManagerFactory() throws NoSuchAlgorithmException {
      return KeyManagerFactory.getInstance("PKIX");
   }

   public static SSLContext initSslContext(SSLContext sslContext, KeyStore trustStore, TrustManagerFactory trustManagerFactory) throws GeneralSecurityException {
      trustManagerFactory.init(trustStore);
      sslContext.init((KeyManager[])null, trustManagerFactory.getTrustManagers(), (SecureRandom)null);
      return sslContext;
   }

   @Beta
   public static SSLContext trustAllSSLContext() throws GeneralSecurityException {
      TrustManager[] trustAllCerts = new TrustManager[]{new SslUtils$1()};
      SSLContext context = getTlsSslContext();
      context.init((KeyManager[])null, trustAllCerts, (SecureRandom)null);
      return context;
   }

   @Beta
   public static HostnameVerifier trustAllHostnameVerifier() {
      return new SslUtils$2();
   }

   private SslUtils() {
   }
}

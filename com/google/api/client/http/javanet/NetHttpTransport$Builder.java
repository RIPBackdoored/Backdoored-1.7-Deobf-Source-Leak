package com.google.api.client.http.javanet;

import com.google.api.client.util.Beta;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.SslUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class NetHttpTransport$Builder {
   private SSLSocketFactory sslSocketFactory;
   private HostnameVerifier hostnameVerifier;
   private Proxy proxy;
   private ConnectionFactory connectionFactory;

   public NetHttpTransport$Builder setProxy(Proxy proxy) {
      this.proxy = proxy;
      return this;
   }

   public NetHttpTransport$Builder setConnectionFactory(ConnectionFactory connectionFactory) {
      this.connectionFactory = connectionFactory;
      return this;
   }

   public NetHttpTransport$Builder trustCertificatesFromJavaKeyStore(InputStream keyStoreStream, String storePass) throws GeneralSecurityException, IOException {
      KeyStore trustStore = SecurityUtils.getJavaKeyStore();
      SecurityUtils.loadKeyStore(trustStore, keyStoreStream, storePass);
      return this.trustCertificates(trustStore);
   }

   public NetHttpTransport$Builder trustCertificatesFromStream(InputStream certificateStream) throws GeneralSecurityException, IOException {
      KeyStore trustStore = SecurityUtils.getJavaKeyStore();
      trustStore.load((InputStream)null, (char[])null);
      SecurityUtils.loadKeyStoreFromCertificates(trustStore, SecurityUtils.getX509CertificateFactory(), certificateStream);
      return this.trustCertificates(trustStore);
   }

   public NetHttpTransport$Builder trustCertificates(KeyStore trustStore) throws GeneralSecurityException {
      SSLContext sslContext = SslUtils.getTlsSslContext();
      SslUtils.initSslContext(sslContext, trustStore, SslUtils.getPkixTrustManagerFactory());
      return this.setSslSocketFactory(sslContext.getSocketFactory());
   }

   @Beta
   public NetHttpTransport$Builder doNotValidateCertificate() throws GeneralSecurityException {
      this.hostnameVerifier = SslUtils.trustAllHostnameVerifier();
      this.sslSocketFactory = SslUtils.trustAllSSLContext().getSocketFactory();
      return this;
   }

   public SSLSocketFactory getSslSocketFactory() {
      return this.sslSocketFactory;
   }

   public NetHttpTransport$Builder setSslSocketFactory(SSLSocketFactory sslSocketFactory) {
      this.sslSocketFactory = sslSocketFactory;
      return this;
   }

   public HostnameVerifier getHostnameVerifier() {
      return this.hostnameVerifier;
   }

   public NetHttpTransport$Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
      this.hostnameVerifier = hostnameVerifier;
      return this;
   }

   public NetHttpTransport build() {
      if (System.getProperty("com.google.api.client.should_use_proxy") != null) {
         this.setProxy(NetHttpTransport.access$000());
      }

      return this.proxy == null ? new NetHttpTransport(this.connectionFactory, this.sslSocketFactory, this.hostnameVerifier) : new NetHttpTransport(this.proxy, this.sslSocketFactory, this.hostnameVerifier);
   }
}

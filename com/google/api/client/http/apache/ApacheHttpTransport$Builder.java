package com.google.api.client.http.apache;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.SslUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpHost;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;

public final class ApacheHttpTransport$Builder {
   private SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
   private HttpParams params = ApacheHttpTransport.newDefaultHttpParams();
   private ProxySelector proxySelector = ProxySelector.getDefault();

   public ApacheHttpTransport$Builder setProxy(HttpHost proxy) {
      ConnRouteParams.setDefaultProxy(this.params, proxy);
      if (proxy != null) {
         this.proxySelector = null;
      }

      return this;
   }

   public ApacheHttpTransport$Builder setProxySelector(ProxySelector proxySelector) {
      this.proxySelector = proxySelector;
      if (proxySelector != null) {
         ConnRouteParams.setDefaultProxy(this.params, (HttpHost)null);
      }

      return this;
   }

   public ApacheHttpTransport$Builder trustCertificatesFromJavaKeyStore(InputStream keyStoreStream, String storePass) throws GeneralSecurityException, IOException {
      KeyStore trustStore = SecurityUtils.getJavaKeyStore();
      SecurityUtils.loadKeyStore(trustStore, keyStoreStream, storePass);
      return this.trustCertificates(trustStore);
   }

   public ApacheHttpTransport$Builder trustCertificatesFromStream(InputStream certificateStream) throws GeneralSecurityException, IOException {
      KeyStore trustStore = SecurityUtils.getJavaKeyStore();
      trustStore.load((InputStream)null, (char[])null);
      SecurityUtils.loadKeyStoreFromCertificates(trustStore, SecurityUtils.getX509CertificateFactory(), certificateStream);
      return this.trustCertificates(trustStore);
   }

   public ApacheHttpTransport$Builder trustCertificates(KeyStore trustStore) throws GeneralSecurityException {
      SSLContext sslContext = SslUtils.getTlsSslContext();
      SslUtils.initSslContext(sslContext, trustStore, SslUtils.getPkixTrustManagerFactory());
      return this.setSocketFactory(new SSLSocketFactoryExtension(sslContext));
   }

   @Beta
   public ApacheHttpTransport$Builder doNotValidateCertificate() throws GeneralSecurityException {
      this.socketFactory = new SSLSocketFactoryExtension(SslUtils.trustAllSSLContext());
      this.socketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      return this;
   }

   public ApacheHttpTransport$Builder setSocketFactory(SSLSocketFactory socketFactory) {
      this.socketFactory = (SSLSocketFactory)Preconditions.checkNotNull(socketFactory);
      return this;
   }

   public SSLSocketFactory getSSLSocketFactory() {
      return this.socketFactory;
   }

   public HttpParams getHttpParams() {
      return this.params;
   }

   public ApacheHttpTransport build() {
      return new ApacheHttpTransport(ApacheHttpTransport.newDefaultHttpClient(this.socketFactory, this.params, this.proxySelector));
   }
}

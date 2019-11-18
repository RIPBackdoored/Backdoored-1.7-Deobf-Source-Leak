package com.google.api.client.testing.json.webtoken;

import com.google.api.client.util.Base64;
import com.google.api.client.util.Beta;
import com.google.api.client.util.PemReader;
import com.google.api.client.util.SecurityUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

@Beta
public class TestCertificates$CertData {
   private String pem;

   public TestCertificates$CertData(String pem) {
      this.pem = pem;
   }

   public Certificate getCertfificate() throws IOException, CertificateException {
      byte[] bytes = this.getDer();
      ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
      return SecurityUtils.getX509CertificateFactory().generateCertificate(bis);
   }

   public byte[] getDer() throws IOException {
      return PemReader.readFirstSectionAndClose(new StringReader(this.pem), "CERTIFICATE").getBase64DecodedBytes();
   }

   public String getBase64Der() throws IOException {
      return Base64.encodeBase64String(this.getDer());
   }

   public X509TrustManager getTrustManager() throws IOException, GeneralSecurityException {
      KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      keyStore.load((InputStream)null, (char[])null);
      keyStore.setCertificateEntry("ca", this.getCertfificate());
      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      trustManagerFactory.init(keyStore);
      return (X509TrustManager)trustManagerFactory.getTrustManagers()[0];
   }
}

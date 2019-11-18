package com.google.api.client.googleapis.apache;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport$Builder;
import java.io.IOException;
import java.security.GeneralSecurityException;

public final class GoogleApacheHttpTransport {
   public static ApacheHttpTransport newTrustedTransport() throws GeneralSecurityException, IOException {
      return (new ApacheHttpTransport$Builder()).trustCertificates(GoogleUtils.getCertificateTrustStore()).build();
   }

   private GoogleApacheHttpTransport() {
   }
}

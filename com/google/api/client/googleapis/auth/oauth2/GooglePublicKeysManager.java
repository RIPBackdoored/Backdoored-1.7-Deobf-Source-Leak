package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Beta
public class GooglePublicKeysManager {
   private static final long REFRESH_SKEW_MILLIS = 300000L;
   private static final Pattern MAX_AGE_PATTERN = Pattern.compile("\\s*max-age\\s*=\\s*(\\d+)\\s*");
   private final JsonFactory jsonFactory;
   private List publicKeys;
   private long expirationTimeMilliseconds;
   private final HttpTransport transport;
   private final Lock lock;
   private final Clock clock;
   private final String publicCertsEncodedUrl;

   public GooglePublicKeysManager(HttpTransport transport, JsonFactory jsonFactory) {
      this(new GooglePublicKeysManager$Builder(transport, jsonFactory));
   }

   protected GooglePublicKeysManager(GooglePublicKeysManager$Builder builder) {
      this.lock = new ReentrantLock();
      this.transport = builder.transport;
      this.jsonFactory = builder.jsonFactory;
      this.clock = builder.clock;
      this.publicCertsEncodedUrl = builder.publicCertsEncodedUrl;
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final String getPublicCertsEncodedUrl() {
      return this.publicCertsEncodedUrl;
   }

   public final Clock getClock() {
      return this.clock;
   }

   public final List getPublicKeys() throws GeneralSecurityException, IOException {
      this.lock.lock();

      List var1;
      try {
         if (this.publicKeys == null || this.clock.currentTimeMillis() + 300000L > this.expirationTimeMilliseconds) {
            this.refresh();
         }

         var1 = this.publicKeys;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public final long getExpirationTimeMilliseconds() {
      return this.expirationTimeMilliseconds;
   }

   public GooglePublicKeysManager refresh() throws GeneralSecurityException, IOException {
      this.lock.lock();

      GooglePublicKeysManager var15;
      try {
         this.publicKeys = new ArrayList();
         CertificateFactory factory = SecurityUtils.getX509CertificateFactory();
         HttpResponse certsResponse = this.transport.createRequestFactory().buildGetRequest(new GenericUrl(this.publicCertsEncodedUrl)).execute();
         this.expirationTimeMilliseconds = this.clock.currentTimeMillis() + this.getCacheTimeInSec(certsResponse.getHeaders()) * 1000L;
         JsonParser parser = this.jsonFactory.createJsonParser(certsResponse.getContent());
         JsonToken currentToken = parser.getCurrentToken();
         if (currentToken == null) {
            currentToken = parser.nextToken();
         }

         Preconditions.checkArgument(currentToken == JsonToken.START_OBJECT);

         try {
            while(parser.nextToken() != JsonToken.END_OBJECT) {
               parser.nextToken();
               String certValue = parser.getText();
               X509Certificate x509Cert = (X509Certificate)factory.generateCertificate(new ByteArrayInputStream(StringUtils.getBytesUtf8(certValue)));
               this.publicKeys.add(x509Cert.getPublicKey());
            }

            this.publicKeys = Collections.unmodifiableList(this.publicKeys);
         } finally {
            parser.close();
         }

         var15 = this;
      } finally {
         this.lock.unlock();
      }

      return var15;
   }

   long getCacheTimeInSec(HttpHeaders httpHeaders) {
      long cacheTimeInSec = 0L;
      if (httpHeaders.getCacheControl() != null) {
         String[] arr$ = httpHeaders.getCacheControl().split(",");
         int len$ = arr$.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            String arg = arr$[i$];
            Matcher m = MAX_AGE_PATTERN.matcher(arg);
            if (m.matches()) {
               cacheTimeInSec = Long.valueOf(m.group(1));
               break;
            }
         }
      }

      if (httpHeaders.getAge() != null) {
         cacheTimeInSec -= httpHeaders.getAge();
      }

      return Math.max(0L, cacheTimeInSec);
   }
}

package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;

@Beta
public class GooglePublicKeysManager$Builder {
   Clock clock;
   final HttpTransport transport;
   final JsonFactory jsonFactory;
   String publicCertsEncodedUrl;

   public GooglePublicKeysManager$Builder(HttpTransport transport, JsonFactory jsonFactory) {
      this.clock = Clock.SYSTEM;
      this.publicCertsEncodedUrl = "https://www.googleapis.com/oauth2/v1/certs";
      this.transport = (HttpTransport)Preconditions.checkNotNull(transport);
      this.jsonFactory = (JsonFactory)Preconditions.checkNotNull(jsonFactory);
   }

   public GooglePublicKeysManager build() {
      return new GooglePublicKeysManager(this);
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

   public GooglePublicKeysManager$Builder setPublicCertsEncodedUrl(String publicCertsEncodedUrl) {
      this.publicCertsEncodedUrl = (String)Preconditions.checkNotNull(publicCertsEncodedUrl);
      return this;
   }

   public final Clock getClock() {
      return this.clock;
   }

   public GooglePublicKeysManager$Builder setClock(Clock clock) {
      this.clock = (Clock)Preconditions.checkNotNull(clock);
      return this;
   }
}

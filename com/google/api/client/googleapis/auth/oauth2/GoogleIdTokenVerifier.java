package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.openidconnect.IdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.List;

@Beta
public class GoogleIdTokenVerifier extends IdTokenVerifier {
   private final GooglePublicKeysManager publicKeys;

   public GoogleIdTokenVerifier(HttpTransport transport, JsonFactory jsonFactory) {
      this(new GoogleIdTokenVerifier$Builder(transport, jsonFactory));
   }

   public GoogleIdTokenVerifier(GooglePublicKeysManager publicKeys) {
      this(new GoogleIdTokenVerifier$Builder(publicKeys));
   }

   protected GoogleIdTokenVerifier(GoogleIdTokenVerifier$Builder builder) {
      super(builder);
      this.publicKeys = builder.publicKeys;
   }

   public final GooglePublicKeysManager getPublicKeysManager() {
      return this.publicKeys;
   }

   public final HttpTransport getTransport() {
      return this.publicKeys.getTransport();
   }

   public final JsonFactory getJsonFactory() {
      return this.publicKeys.getJsonFactory();
   }

   /** @deprecated */
   @Deprecated
   @Deprecated
   public final String getPublicCertsEncodedUrl() {
      return this.publicKeys.getPublicCertsEncodedUrl();
   }

   /** @deprecated */
   @Deprecated
   @Deprecated
   public final List getPublicKeys() throws GeneralSecurityException, IOException {
      return this.publicKeys.getPublicKeys();
   }

   /** @deprecated */
   @Deprecated
   @Deprecated
   public final long getExpirationTimeMilliseconds() {
      return this.publicKeys.getExpirationTimeMilliseconds();
   }

   public boolean verify(GoogleIdToken googleIdToken) throws GeneralSecurityException, IOException {
      if (!super.verify(googleIdToken)) {
         return false;
      } else {
         Iterator i$ = this.publicKeys.getPublicKeys().iterator();

         PublicKey publicKey;
         do {
            if (!i$.hasNext()) {
               return false;
            }

            publicKey = (PublicKey)i$.next();
         } while(!googleIdToken.verifySignature(publicKey));

         return true;
      }
   }

   public GoogleIdToken verify(String idTokenString) throws GeneralSecurityException, IOException {
      GoogleIdToken idToken = GoogleIdToken.parse(this.getJsonFactory(), idTokenString);
      return this.verify(idToken) ? idToken : null;
   }

   /** @deprecated */
   @Deprecated
   @Deprecated
   public GoogleIdTokenVerifier loadPublicCerts() throws GeneralSecurityException, IOException {
      this.publicKeys.refresh();
      return this;
   }
}

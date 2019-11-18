package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.auth.openidconnect.IdToken$Payload;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebSignature$Header;
import com.google.api.client.json.webtoken.JsonWebToken$Payload;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Beta
public class GoogleIdToken extends IdToken {
   public static GoogleIdToken parse(JsonFactory jsonFactory, String idTokenString) throws IOException {
      JsonWebSignature jws = JsonWebSignature.parser(jsonFactory).setPayloadClass(GoogleIdToken$Payload.class).parse(idTokenString);
      return new GoogleIdToken(jws.getHeader(), (GoogleIdToken$Payload)jws.getPayload(), jws.getSignatureBytes(), jws.getSignedContentBytes());
   }

   public GoogleIdToken(JsonWebSignature$Header header, GoogleIdToken$Payload payload, byte[] signatureBytes, byte[] signedContentBytes) {
      super(header, payload, signatureBytes, signedContentBytes);
   }

   public boolean verify(GoogleIdTokenVerifier verifier) throws GeneralSecurityException, IOException {
      return verifier.verify(this);
   }

   public GoogleIdToken$Payload getPayload() {
      return (GoogleIdToken$Payload)super.getPayload();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IdToken$Payload getPayload() {
      return this.getPayload();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload getPayload() {
      return this.getPayload();
   }
}

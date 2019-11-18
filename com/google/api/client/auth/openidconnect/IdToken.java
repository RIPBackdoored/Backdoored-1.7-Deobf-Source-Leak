package com.google.api.client.auth.openidconnect;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebSignature$Header;
import com.google.api.client.json.webtoken.JsonWebToken$Payload;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

@Beta
public class IdToken extends JsonWebSignature {
   public IdToken(JsonWebSignature$Header header, IdToken$Payload payload, byte[] signatureBytes, byte[] signedContentBytes) {
      super(header, payload, signatureBytes, signedContentBytes);
   }

   public IdToken$Payload getPayload() {
      return (IdToken$Payload)super.getPayload();
   }

   public final boolean verifyIssuer(String expectedIssuer) {
      return this.verifyIssuer((Collection)Collections.singleton(expectedIssuer));
   }

   public final boolean verifyIssuer(Collection expectedIssuer) {
      return expectedIssuer.contains(this.getPayload().getIssuer());
   }

   public final boolean verifyAudience(Collection trustedClientIds) {
      Collection audience = this.getPayload().getAudienceAsList();
      return audience.isEmpty() ? false : trustedClientIds.containsAll(audience);
   }

   public final boolean verifyTime(long currentTimeMillis, long acceptableTimeSkewSeconds) {
      return this.verifyExpirationTime(currentTimeMillis, acceptableTimeSkewSeconds) && this.verifyIssuedAtTime(currentTimeMillis, acceptableTimeSkewSeconds);
   }

   public final boolean verifyExpirationTime(long currentTimeMillis, long acceptableTimeSkewSeconds) {
      return currentTimeMillis <= (this.getPayload().getExpirationTimeSeconds() + acceptableTimeSkewSeconds) * 1000L;
   }

   public final boolean verifyIssuedAtTime(long currentTimeMillis, long acceptableTimeSkewSeconds) {
      return currentTimeMillis >= (this.getPayload().getIssuedAtTimeSeconds() - acceptableTimeSkewSeconds) * 1000L;
   }

   public static IdToken parse(JsonFactory jsonFactory, String idTokenString) throws IOException {
      JsonWebSignature jws = JsonWebSignature.parser(jsonFactory).setPayloadClass(IdToken$Payload.class).parse(idTokenString);
      return new IdToken(jws.getHeader(), (IdToken$Payload)jws.getPayload(), jws.getSignatureBytes(), jws.getSignedContentBytes());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonWebToken$Payload getPayload() {
      return this.getPayload();
   }
}

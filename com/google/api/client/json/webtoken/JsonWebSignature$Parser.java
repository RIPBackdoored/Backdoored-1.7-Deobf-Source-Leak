package com.google.api.client.json.webtoken;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public final class JsonWebSignature$Parser {
   private final JsonFactory jsonFactory;
   private Class headerClass = JsonWebSignature$Header.class;
   private Class payloadClass = JsonWebToken$Payload.class;

   public JsonWebSignature$Parser(JsonFactory jsonFactory) {
      this.jsonFactory = (JsonFactory)Preconditions.checkNotNull(jsonFactory);
   }

   public Class getHeaderClass() {
      return this.headerClass;
   }

   public JsonWebSignature$Parser setHeaderClass(Class headerClass) {
      this.headerClass = headerClass;
      return this;
   }

   public Class getPayloadClass() {
      return this.payloadClass;
   }

   public JsonWebSignature$Parser setPayloadClass(Class payloadClass) {
      this.payloadClass = payloadClass;
      return this;
   }

   public JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public JsonWebSignature parse(String tokenString) throws IOException {
      int firstDot = tokenString.indexOf(46);
      Preconditions.checkArgument(firstDot != -1);
      byte[] headerBytes = Base64.decodeBase64(tokenString.substring(0, firstDot));
      int secondDot = tokenString.indexOf(46, firstDot + 1);
      Preconditions.checkArgument(secondDot != -1);
      Preconditions.checkArgument(tokenString.indexOf(46, secondDot + 1) == -1);
      byte[] payloadBytes = Base64.decodeBase64(tokenString.substring(firstDot + 1, secondDot));
      byte[] signatureBytes = Base64.decodeBase64(tokenString.substring(secondDot + 1));
      byte[] signedContentBytes = StringUtils.getBytesUtf8(tokenString.substring(0, secondDot));
      JsonWebSignature$Header header = (JsonWebSignature$Header)this.jsonFactory.fromInputStream(new ByteArrayInputStream(headerBytes), this.headerClass);
      Preconditions.checkArgument(header.getAlgorithm() != null);
      JsonWebToken$Payload payload = (JsonWebToken$Payload)this.jsonFactory.fromInputStream(new ByteArrayInputStream(payloadBytes), this.payloadClass);
      return new JsonWebSignature(header, payload, signatureBytes, signedContentBytes);
   }
}

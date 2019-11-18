package com.google.api.client.json.webtoken;

import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;

public class JsonWebToken {
   private final JsonWebToken$Header header;
   private final JsonWebToken$Payload payload;

   public JsonWebToken(JsonWebToken$Header header, JsonWebToken$Payload payload) {
      this.header = (JsonWebToken$Header)Preconditions.checkNotNull(header);
      this.payload = (JsonWebToken$Payload)Preconditions.checkNotNull(payload);
   }

   public String toString() {
      return Objects.toStringHelper(this).add("header", this.header).add("payload", this.payload).toString();
   }

   public JsonWebToken$Header getHeader() {
      return this.header;
   }

   public JsonWebToken$Payload getPayload() {
      return this.payload;
   }
}

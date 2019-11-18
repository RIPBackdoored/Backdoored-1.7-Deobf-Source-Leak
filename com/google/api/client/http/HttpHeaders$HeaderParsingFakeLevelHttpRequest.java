package com.google.api.client.http;

import java.io.IOException;

class HttpHeaders$HeaderParsingFakeLevelHttpRequest extends LowLevelHttpRequest {
   private final HttpHeaders target;
   private final HttpHeaders$ParseHeaderState state;

   HttpHeaders$HeaderParsingFakeLevelHttpRequest(HttpHeaders target, HttpHeaders$ParseHeaderState state) {
      this.target = target;
      this.state = state;
   }

   public void addHeader(String name, String value) {
      this.target.parseHeader(name, value, this.state);
   }

   public LowLevelHttpResponse execute() throws IOException {
      throw new UnsupportedOperationException();
   }
}

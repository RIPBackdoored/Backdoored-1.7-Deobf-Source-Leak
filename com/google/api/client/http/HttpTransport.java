package com.google.api.client.http;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public abstract class HttpTransport {
   static final Logger LOGGER = Logger.getLogger(HttpTransport.class.getName());
   private static final String[] SUPPORTED_METHODS = new String[]{"DELETE", "GET", "POST", "PUT"};

   public final HttpRequestFactory createRequestFactory() {
      return this.createRequestFactory((HttpRequestInitializer)null);
   }

   public final HttpRequestFactory createRequestFactory(HttpRequestInitializer initializer) {
      return new HttpRequestFactory(this, initializer);
   }

   HttpRequest buildRequest() {
      return new HttpRequest(this, (String)null);
   }

   public boolean supportsMethod(String method) throws IOException {
      return Arrays.binarySearch(SUPPORTED_METHODS, method) >= 0;
   }

   protected abstract LowLevelHttpRequest buildRequest(String var1, String var2) throws IOException;

   public void shutdown() throws IOException {
   }

   static {
      Arrays.sort(SUPPORTED_METHODS);
   }
}

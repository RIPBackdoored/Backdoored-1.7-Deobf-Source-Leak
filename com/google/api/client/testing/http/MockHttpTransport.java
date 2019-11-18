package com.google.api.client.testing.http;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

@Beta
public class MockHttpTransport extends HttpTransport {
   private Set supportedMethods;
   private MockLowLevelHttpRequest lowLevelHttpRequest;
   private MockLowLevelHttpResponse lowLevelHttpResponse;

   public MockHttpTransport() {
   }

   protected MockHttpTransport(MockHttpTransport$Builder builder) {
      this.supportedMethods = builder.supportedMethods;
      this.lowLevelHttpRequest = builder.lowLevelHttpRequest;
      this.lowLevelHttpResponse = builder.lowLevelHttpResponse;
   }

   public boolean supportsMethod(String method) throws IOException {
      return this.supportedMethods == null || this.supportedMethods.contains(method);
   }

   public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
      Preconditions.checkArgument(this.supportsMethod(method), "HTTP method %s not supported", method);
      if (this.lowLevelHttpRequest != null) {
         return this.lowLevelHttpRequest;
      } else {
         this.lowLevelHttpRequest = new MockLowLevelHttpRequest(url);
         if (this.lowLevelHttpResponse != null) {
            this.lowLevelHttpRequest.setResponse(this.lowLevelHttpResponse);
         }

         return this.lowLevelHttpRequest;
      }
   }

   public final Set getSupportedMethods() {
      return this.supportedMethods == null ? null : Collections.unmodifiableSet(this.supportedMethods);
   }

   public final MockLowLevelHttpRequest getLowLevelHttpRequest() {
      return this.lowLevelHttpRequest;
   }

   /** @deprecated */
   @Deprecated
   public static MockHttpTransport$Builder builder() {
      return new MockHttpTransport$Builder();
   }
}

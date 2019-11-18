package com.google.api.client.testing.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.util.Set;

@Beta
public class MockHttpTransport$Builder {
   Set supportedMethods;
   MockLowLevelHttpRequest lowLevelHttpRequest;
   MockLowLevelHttpResponse lowLevelHttpResponse;

   public MockHttpTransport build() {
      return new MockHttpTransport(this);
   }

   public final Set getSupportedMethods() {
      return this.supportedMethods;
   }

   public final MockHttpTransport$Builder setSupportedMethods(Set supportedMethods) {
      this.supportedMethods = supportedMethods;
      return this;
   }

   public final MockHttpTransport$Builder setLowLevelHttpRequest(MockLowLevelHttpRequest lowLevelHttpRequest) {
      Preconditions.checkState(this.lowLevelHttpResponse == null, "Cannnot set a low level HTTP request when a low level HTTP response has been set.");
      this.lowLevelHttpRequest = lowLevelHttpRequest;
      return this;
   }

   public final MockLowLevelHttpRequest getLowLevelHttpRequest() {
      return this.lowLevelHttpRequest;
   }

   public final MockHttpTransport$Builder setLowLevelHttpResponse(MockLowLevelHttpResponse lowLevelHttpResponse) {
      Preconditions.checkState(this.lowLevelHttpRequest == null, "Cannot set a low level HTTP response when a low level HTTP request has been set.");
      this.lowLevelHttpResponse = lowLevelHttpResponse;
      return this;
   }

   MockLowLevelHttpResponse getLowLevelHttpResponse() {
      return this.lowLevelHttpResponse;
   }
}

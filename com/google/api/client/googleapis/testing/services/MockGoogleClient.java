package com.google.api.client.googleapis.testing.services;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;

@Beta
public class MockGoogleClient extends AbstractGoogleClient {
   public MockGoogleClient(HttpTransport transport, String rootUrl, String servicePath, ObjectParser objectParser, HttpRequestInitializer httpRequestInitializer) {
      this(new MockGoogleClient$Builder(transport, rootUrl, servicePath, objectParser, httpRequestInitializer));
   }

   protected MockGoogleClient(MockGoogleClient$Builder builder) {
      super(builder);
   }
}

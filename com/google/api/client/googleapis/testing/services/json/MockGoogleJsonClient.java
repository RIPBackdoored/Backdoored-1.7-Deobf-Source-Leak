package com.google.api.client.googleapis.testing.services.json;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;

@Beta
public class MockGoogleJsonClient extends AbstractGoogleJsonClient {
   protected MockGoogleJsonClient(MockGoogleJsonClient$Builder builder) {
      super(builder);
   }

   public MockGoogleJsonClient(HttpTransport transport, JsonFactory jsonFactory, String rootUrl, String servicePath, HttpRequestInitializer httpRequestInitializer, boolean legacyDataWrapper) {
      this(new MockGoogleJsonClient$Builder(transport, jsonFactory, rootUrl, servicePath, httpRequestInitializer, legacyDataWrapper));
   }
}

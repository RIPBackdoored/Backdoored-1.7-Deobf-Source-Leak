package com.google.api.client.googleapis.testing.services.json;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Beta;

@Beta
public class MockGoogleJsonClientRequest extends AbstractGoogleJsonClientRequest {
   public MockGoogleJsonClientRequest(AbstractGoogleJsonClient client, String method, String uriTemplate, Object content, Class responseClass) {
      super(client, method, uriTemplate, content, responseClass);
   }

   public MockGoogleJsonClient getAbstractGoogleClient() {
      return (MockGoogleJsonClient)super.getAbstractGoogleClient();
   }

   public MockGoogleJsonClientRequest setDisableGZipContent(boolean disableGZipContent) {
      return (MockGoogleJsonClientRequest)super.setDisableGZipContent(disableGZipContent);
   }

   public MockGoogleJsonClientRequest setRequestHeaders(HttpHeaders headers) {
      return (MockGoogleJsonClientRequest)super.setRequestHeaders(headers);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClientRequest setRequestHeaders(HttpHeaders var1) {
      return this.setRequestHeaders(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClientRequest setDisableGZipContent(boolean var1) {
      return this.setDisableGZipContent(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient getAbstractGoogleClient() {
      return this.getAbstractGoogleClient();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest setRequestHeaders(HttpHeaders var1) {
      return this.setRequestHeaders(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient getAbstractGoogleClient() {
      return this.getAbstractGoogleClient();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest setDisableGZipContent(boolean var1) {
      return this.setDisableGZipContent(var1);
   }
}

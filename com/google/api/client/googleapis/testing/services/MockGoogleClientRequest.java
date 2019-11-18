package com.google.api.client.googleapis.testing.services;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Beta;
import com.google.api.client.util.GenericData;

@Beta
public class MockGoogleClientRequest extends AbstractGoogleClientRequest {
   public MockGoogleClientRequest(AbstractGoogleClient client, String method, String uriTemplate, HttpContent content, Class responseClass) {
      super(client, method, uriTemplate, content, responseClass);
   }

   public MockGoogleClientRequest setDisableGZipContent(boolean disableGZipContent) {
      return (MockGoogleClientRequest)super.setDisableGZipContent(disableGZipContent);
   }

   public MockGoogleClientRequest setRequestHeaders(HttpHeaders headers) {
      return (MockGoogleClientRequest)super.setRequestHeaders(headers);
   }

   public MockGoogleClientRequest set(String fieldName, Object value) {
      return (MockGoogleClientRequest)super.set(fieldName, value);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest setRequestHeaders(HttpHeaders var1) {
      return this.setRequestHeaders(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest setDisableGZipContent(boolean var1) {
      return this.setDisableGZipContent(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }
}

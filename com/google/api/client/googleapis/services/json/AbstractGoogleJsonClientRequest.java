package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonErrorContainer;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.util.GenericData;
import java.io.IOException;

public abstract class AbstractGoogleJsonClientRequest extends AbstractGoogleClientRequest {
   private final Object jsonContent;

   protected AbstractGoogleJsonClientRequest(AbstractGoogleJsonClient abstractGoogleJsonClient, String requestMethod, String uriTemplate, Object jsonContent, Class responseClass) {
      super(abstractGoogleJsonClient, requestMethod, uriTemplate, jsonContent == null ? null : (new JsonHttpContent(abstractGoogleJsonClient.getJsonFactory(), jsonContent)).setWrapperKey(abstractGoogleJsonClient.getObjectParser().getWrapperKeys().isEmpty() ? null : "data"), responseClass);
      this.jsonContent = jsonContent;
   }

   public AbstractGoogleJsonClient getAbstractGoogleClient() {
      return (AbstractGoogleJsonClient)super.getAbstractGoogleClient();
   }

   public AbstractGoogleJsonClientRequest setDisableGZipContent(boolean disableGZipContent) {
      return (AbstractGoogleJsonClientRequest)super.setDisableGZipContent(disableGZipContent);
   }

   public AbstractGoogleJsonClientRequest setRequestHeaders(HttpHeaders headers) {
      return (AbstractGoogleJsonClientRequest)super.setRequestHeaders(headers);
   }

   public final void queue(BatchRequest batchRequest, JsonBatchCallback callback) throws IOException {
      super.queue(batchRequest, GoogleJsonErrorContainer.class, callback);
   }

   protected GoogleJsonResponseException newExceptionOnError(HttpResponse response) {
      return GoogleJsonResponseException.from(this.getAbstractGoogleClient().getJsonFactory(), response);
   }

   public Object getJsonContent() {
      return this.jsonContent;
   }

   public AbstractGoogleJsonClientRequest set(String fieldName, Object value) {
      return (AbstractGoogleJsonClientRequest)super.set(fieldName, value);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected IOException newExceptionOnError(HttpResponse var1) {
      return this.newExceptionOnError(var1);
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

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }
}

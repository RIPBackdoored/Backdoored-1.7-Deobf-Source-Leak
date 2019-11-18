package com.google.api.client.googleapis.batch;

import com.google.api.client.http.BackOffPolicy;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.http.MultipartContent$Part;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class BatchRequest {
   private GenericUrl batchUrl = new GenericUrl("https://www.googleapis.com/batch");
   private final HttpRequestFactory requestFactory;
   List requestInfos = new ArrayList();
   private Sleeper sleeper;

   public BatchRequest(HttpTransport transport, HttpRequestInitializer httpRequestInitializer) {
      this.sleeper = Sleeper.DEFAULT;
      this.requestFactory = httpRequestInitializer == null ? transport.createRequestFactory() : transport.createRequestFactory(httpRequestInitializer);
   }

   public BatchRequest setBatchUrl(GenericUrl batchUrl) {
      this.batchUrl = batchUrl;
      return this;
   }

   public GenericUrl getBatchUrl() {
      return this.batchUrl;
   }

   public Sleeper getSleeper() {
      return this.sleeper;
   }

   public BatchRequest setSleeper(Sleeper sleeper) {
      this.sleeper = (Sleeper)Preconditions.checkNotNull(sleeper);
      return this;
   }

   public BatchRequest queue(HttpRequest httpRequest, Class dataClass, Class errorClass, BatchCallback callback) throws IOException {
      Preconditions.checkNotNull(httpRequest);
      Preconditions.checkNotNull(callback);
      Preconditions.checkNotNull(dataClass);
      Preconditions.checkNotNull(errorClass);
      this.requestInfos.add(new BatchRequest$RequestInfo(callback, dataClass, errorClass, httpRequest));
      return this;
   }

   public int size() {
      return this.requestInfos.size();
   }

   public void execute() throws IOException {
      Preconditions.checkState(!this.requestInfos.isEmpty());
      HttpRequest batchRequest = this.requestFactory.buildPostRequest(this.batchUrl, (HttpContent)null);
      HttpExecuteInterceptor originalInterceptor = batchRequest.getInterceptor();
      batchRequest.setInterceptor(new BatchRequest$BatchInterceptor(this, originalInterceptor));
      int retriesRemaining = batchRequest.getNumberOfRetries();
      BackOffPolicy backOffPolicy = batchRequest.getBackOffPolicy();
      if (backOffPolicy != null) {
         backOffPolicy.reset();
      }

      boolean retryAllowed;
      do {
         retryAllowed = retriesRemaining > 0;
         MultipartContent batchContent = new MultipartContent();
         batchContent.getMediaType().setSubType("mixed");
         int contentId = 1;
         Iterator i$ = this.requestInfos.iterator();

         while(i$.hasNext()) {
            BatchRequest$RequestInfo requestInfo = (BatchRequest$RequestInfo)i$.next();
            batchContent.addPart(new MultipartContent$Part((new HttpHeaders()).setAcceptEncoding((String)null).set("Content-ID", contentId++), new HttpRequestContent(requestInfo.request)));
         }

         batchRequest.setContent(batchContent);
         HttpResponse response = batchRequest.execute();

         BatchUnparsedResponse batchResponse;
         try {
            String var10001 = String.valueOf(response.getMediaType().getParameter("boundary"));
            String var10000;
            if (var10001.length() != 0) {
               var10000 = "--".concat(var10001);
            } else {
               String var10002 = new String;
               var10000 = var10002;
               var10002.<init>("--");
            }

            String boundary = var10000;
            InputStream contentStream = response.getContent();
            batchResponse = new BatchUnparsedResponse(contentStream, boundary, this.requestInfos, retryAllowed);

            while(batchResponse.hasNext) {
               batchResponse.parseNextResponse();
            }
         } finally {
            response.disconnect();
         }

         List unsuccessfulRequestInfos = batchResponse.unsuccessfulRequestInfos;
         if (unsuccessfulRequestInfos.isEmpty()) {
            break;
         }

         this.requestInfos = unsuccessfulRequestInfos;
         if (batchResponse.backOffRequired && backOffPolicy != null) {
            long backOffTime = backOffPolicy.getNextBackOffMillis();
            if (backOffTime != -1L) {
               try {
                  this.sleeper.sleep(backOffTime);
               } catch (InterruptedException var16) {
               }
            }
         }

         --retriesRemaining;
      } while(retryAllowed);

      this.requestInfos.clear();
   }
}

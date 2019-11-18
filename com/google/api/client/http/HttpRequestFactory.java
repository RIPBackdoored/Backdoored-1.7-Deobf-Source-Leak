package com.google.api.client.http;

import java.io.IOException;

public final class HttpRequestFactory {
   private final HttpTransport transport;
   private final HttpRequestInitializer initializer;

   HttpRequestFactory(HttpTransport transport, HttpRequestInitializer initializer) {
      this.transport = transport;
      this.initializer = initializer;
   }

   public HttpTransport getTransport() {
      return this.transport;
   }

   public HttpRequestInitializer getInitializer() {
      return this.initializer;
   }

   public HttpRequest buildRequest(String requestMethod, GenericUrl url, HttpContent content) throws IOException {
      HttpRequest request = this.transport.buildRequest();
      if (this.initializer != null) {
         this.initializer.initialize(request);
      }

      request.setRequestMethod(requestMethod);
      if (url != null) {
         request.setUrl(url);
      }

      if (content != null) {
         request.setContent(content);
      }

      return request;
   }

   public HttpRequest buildDeleteRequest(GenericUrl url) throws IOException {
      return this.buildRequest("DELETE", url, (HttpContent)null);
   }

   public HttpRequest buildGetRequest(GenericUrl url) throws IOException {
      return this.buildRequest("GET", url, (HttpContent)null);
   }

   public HttpRequest buildPostRequest(GenericUrl url, HttpContent content) throws IOException {
      return this.buildRequest("POST", url, content);
   }

   public HttpRequest buildPutRequest(GenericUrl url, HttpContent content) throws IOException {
      return this.buildRequest("PUT", url, content);
   }

   public HttpRequest buildPatchRequest(GenericUrl url, HttpContent content) throws IOException {
      return this.buildRequest("PATCH", url, content);
   }

   public HttpRequest buildHeadRequest(GenericUrl url) throws IOException {
      return this.buildRequest("HEAD", url, (HttpContent)null);
   }
}

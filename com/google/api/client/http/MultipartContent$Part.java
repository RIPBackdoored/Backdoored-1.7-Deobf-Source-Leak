package com.google.api.client.http;

public final class MultipartContent$Part {
   HttpContent content;
   HttpHeaders headers;
   HttpEncoding encoding;

   public MultipartContent$Part() {
      this((HttpContent)null);
   }

   public MultipartContent$Part(HttpContent content) {
      this((HttpHeaders)null, content);
   }

   public MultipartContent$Part(HttpHeaders headers, HttpContent content) {
      this.setHeaders(headers);
      this.setContent(content);
   }

   public MultipartContent$Part setContent(HttpContent content) {
      this.content = content;
      return this;
   }

   public HttpContent getContent() {
      return this.content;
   }

   public MultipartContent$Part setHeaders(HttpHeaders headers) {
      this.headers = headers;
      return this;
   }

   public HttpHeaders getHeaders() {
      return this.headers;
   }

   public MultipartContent$Part setEncoding(HttpEncoding encoding) {
      this.encoding = encoding;
      return this;
   }

   public HttpEncoding getEncoding() {
      return this.encoding;
   }
}

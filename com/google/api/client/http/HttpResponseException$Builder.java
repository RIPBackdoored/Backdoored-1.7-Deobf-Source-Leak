package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.IOException;

public class HttpResponseException$Builder {
   int statusCode;
   String statusMessage;
   HttpHeaders headers;
   String content;
   String message;

   public HttpResponseException$Builder(int statusCode, String statusMessage, HttpHeaders headers) {
      this.setStatusCode(statusCode);
      this.setStatusMessage(statusMessage);
      this.setHeaders(headers);
   }

   public HttpResponseException$Builder(HttpResponse response) {
      this(response.getStatusCode(), response.getStatusMessage(), response.getHeaders());

      try {
         this.content = response.parseAsString();
         if (this.content.length() == 0) {
            this.content = null;
         }
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      StringBuilder builder = HttpResponseException.computeMessageBuffer(response);
      if (this.content != null) {
         builder.append(StringUtils.LINE_SEPARATOR).append(this.content);
      }

      this.message = builder.toString();
   }

   public final String getMessage() {
      return this.message;
   }

   public HttpResponseException$Builder setMessage(String message) {
      this.message = message;
      return this;
   }

   public final int getStatusCode() {
      return this.statusCode;
   }

   public HttpResponseException$Builder setStatusCode(int statusCode) {
      Preconditions.checkArgument(statusCode >= 0);
      this.statusCode = statusCode;
      return this;
   }

   public final String getStatusMessage() {
      return this.statusMessage;
   }

   public HttpResponseException$Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
   }

   public HttpHeaders getHeaders() {
      return this.headers;
   }

   public HttpResponseException$Builder setHeaders(HttpHeaders headers) {
      this.headers = (HttpHeaders)Preconditions.checkNotNull(headers);
      return this;
   }

   public final String getContent() {
      return this.content;
   }

   public HttpResponseException$Builder setContent(String content) {
      this.content = content;
      return this;
   }

   public HttpResponseException build() {
      return new HttpResponseException(this);
   }
}

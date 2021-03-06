package com.google.api.client.http;

import java.io.IOException;

public class HttpResponseException extends IOException {
   private static final long serialVersionUID = -1875819453475890043L;
   private final int statusCode;
   private final String statusMessage;
   private final transient HttpHeaders headers;
   private final String content;

   public HttpResponseException(HttpResponse response) {
      this(new HttpResponseException$Builder(response));
   }

   protected HttpResponseException(HttpResponseException$Builder builder) {
      super(builder.message);
      this.statusCode = builder.statusCode;
      this.statusMessage = builder.statusMessage;
      this.headers = builder.headers;
      this.content = builder.content;
   }

   public final boolean isSuccessStatusCode() {
      return HttpStatusCodes.isSuccess(this.statusCode);
   }

   public final int getStatusCode() {
      return this.statusCode;
   }

   public final String getStatusMessage() {
      return this.statusMessage;
   }

   public HttpHeaders getHeaders() {
      return this.headers;
   }

   public final String getContent() {
      return this.content;
   }

   public static StringBuilder computeMessageBuffer(HttpResponse response) {
      StringBuilder builder = new StringBuilder();
      int statusCode = response.getStatusCode();
      if (statusCode != 0) {
         builder.append(statusCode);
      }

      String statusMessage = response.getStatusMessage();
      if (statusMessage != null) {
         if (statusCode != 0) {
            builder.append(' ');
         }

         builder.append(statusMessage);
      }

      return builder;
   }
}

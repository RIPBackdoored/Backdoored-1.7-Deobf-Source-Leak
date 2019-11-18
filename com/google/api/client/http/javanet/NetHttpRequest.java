package com.google.api.client.http.javanet;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

final class NetHttpRequest extends LowLevelHttpRequest {
   private final HttpURLConnection connection;

   NetHttpRequest(HttpURLConnection connection) {
      this.connection = connection;
      connection.setInstanceFollowRedirects(false);
   }

   public void addHeader(String name, String value) {
      this.connection.addRequestProperty(name, value);
   }

   public void setTimeout(int connectTimeout, int readTimeout) {
      this.connection.setReadTimeout(readTimeout);
      this.connection.setConnectTimeout(connectTimeout);
   }

   public LowLevelHttpResponse execute() throws IOException {
      HttpURLConnection connection = this.connection;
      if (this.getStreamingContent() != null) {
         String contentType = this.getContentType();
         if (contentType != null) {
            this.addHeader("Content-Type", contentType);
         }

         String contentEncoding = this.getContentEncoding();
         if (contentEncoding != null) {
            this.addHeader("Content-Encoding", contentEncoding);
         }

         long contentLength = this.getContentLength();
         if (contentLength >= 0L) {
            connection.setRequestProperty("Content-Length", Long.toString(contentLength));
         }

         String requestMethod = connection.getRequestMethod();
         if (!"POST".equals(requestMethod) && !"PUT".equals(requestMethod)) {
            Preconditions.checkArgument(contentLength == 0L, "%s with non-zero content length is not supported", requestMethod);
         } else {
            connection.setDoOutput(true);
            if (contentLength >= 0L && contentLength <= 0L) {
               connection.setFixedLengthStreamingMode((int)contentLength);
            } else {
               connection.setChunkedStreamingMode(0);
            }

            OutputStream out = connection.getOutputStream();
            boolean threw = true;

            try {
               this.getStreamingContent().writeTo(out);
               threw = false;
            } finally {
               try {
                  out.close();
               } catch (IOException var23) {
                  if (!threw) {
                     throw var23;
                  }
               }

            }
         }
      }

      boolean successfulConnection = false;

      NetHttpResponse var12;
      try {
         connection.connect();
         NetHttpResponse response = new NetHttpResponse(connection);
         successfulConnection = true;
         var12 = response;
      } finally {
         if (!successfulConnection) {
            connection.disconnect();
         }

      }

      return var12;
   }
}

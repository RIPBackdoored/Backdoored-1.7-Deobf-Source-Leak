package com.google.api.client.http.javanet;

import com.google.api.client.http.LowLevelHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class NetHttpResponse extends LowLevelHttpResponse {
   private final HttpURLConnection connection;
   private final int responseCode;
   private final String responseMessage;
   private final ArrayList headerNames = new ArrayList();
   private final ArrayList headerValues = new ArrayList();

   NetHttpResponse(HttpURLConnection connection) throws IOException {
      this.connection = connection;
      int responseCode = connection.getResponseCode();
      this.responseCode = responseCode == -1 ? 0 : responseCode;
      this.responseMessage = connection.getResponseMessage();
      List headerNames = this.headerNames;
      List headerValues = this.headerValues;
      Iterator var5 = connection.getHeaderFields().entrySet().iterator();

      while(true) {
         Entry entry;
         String key;
         do {
            if (!var5.hasNext()) {
               return;
            }

            entry = (Entry)var5.next();
            key = (String)entry.getKey();
         } while(key == null);

         Iterator var8 = ((List)entry.getValue()).iterator();

         while(var8.hasNext()) {
            String value = (String)var8.next();
            if (value != null) {
               headerNames.add(key);
               headerValues.add(value);
            }
         }
      }
   }

   public int getStatusCode() {
      return this.responseCode;
   }

   public InputStream getContent() throws IOException {
      InputStream in = null;

      try {
         in = this.connection.getInputStream();
      } catch (IOException var3) {
         in = this.connection.getErrorStream();
      }

      return in == null ? null : new NetHttpResponse$SizeValidatingInputStream(this, in);
   }

   public String getContentEncoding() {
      return this.connection.getContentEncoding();
   }

   public long getContentLength() {
      String string = this.connection.getHeaderField("Content-Length");
      return string == null ? -1L : Long.parseLong(string);
   }

   public String getContentType() {
      return this.connection.getHeaderField("Content-Type");
   }

   public String getReasonPhrase() {
      return this.responseMessage;
   }

   public String getStatusLine() {
      String result = this.connection.getHeaderField(0);
      return result != null && result.startsWith("HTTP/1.") ? result : null;
   }

   public int getHeaderCount() {
      return this.headerNames.size();
   }

   public String getHeaderName(int index) {
      return (String)this.headerNames.get(index);
   }

   public String getHeaderValue(int index) {
      return (String)this.headerValues.get(index);
   }

   public void disconnect() {
      this.connection.disconnect();
   }
}

package com.google.api.client.googleapis.batch;

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Logger;

class HttpRequestContent extends AbstractHttpContent {
   static final String NEWLINE = "\r\n";
   private final HttpRequest request;
   private static final String HTTP_VERSION = "HTTP/1.1";

   HttpRequestContent(HttpRequest request) {
      super("application/http");
      this.request = request;
   }

   public void writeTo(OutputStream out) throws IOException {
      Writer writer = new OutputStreamWriter(out, this.getCharset());
      writer.write(this.request.getRequestMethod());
      writer.write(" ");
      writer.write(this.request.getUrl().build());
      writer.write(" ");
      writer.write("HTTP/1.1");
      writer.write("\r\n");
      HttpHeaders headers = new HttpHeaders();
      headers.fromHttpHeaders(this.request.getHeaders());
      headers.setAcceptEncoding((String)null).setUserAgent((String)null).setContentEncoding((String)null).setContentType((String)null).setContentLength((Long)null);
      HttpContent content = this.request.getContent();
      if (content != null) {
         headers.setContentType(content.getType());
         long contentLength = content.getLength();
         if (contentLength != -1L) {
            headers.setContentLength(contentLength);
         }
      }

      HttpHeaders.serializeHeadersForMultipartRequests(headers, (StringBuilder)null, (Logger)null, writer);
      writer.write("\r\n");
      writer.flush();
      if (content != null) {
         content.writeTo(out);
      }

   }
}

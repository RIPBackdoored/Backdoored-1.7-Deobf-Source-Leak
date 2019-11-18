package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.LoggingInputStream;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

public final class HttpResponse {
   private InputStream content;
   private final String contentEncoding;
   private final String contentType;
   private final HttpMediaType mediaType;
   LowLevelHttpResponse response;
   private final int statusCode;
   private final String statusMessage;
   private final HttpRequest request;
   private int contentLoggingLimit;
   private boolean loggingEnabled;
   private boolean contentRead;

   HttpResponse(HttpRequest request, LowLevelHttpResponse response) throws IOException {
      this.request = request;
      this.contentLoggingLimit = request.getContentLoggingLimit();
      this.loggingEnabled = request.isLoggingEnabled();
      this.response = response;
      this.contentEncoding = response.getContentEncoding();
      int code = response.getStatusCode();
      this.statusCode = code < 0 ? 0 : code;
      String message = response.getReasonPhrase();
      this.statusMessage = message;
      Logger logger = HttpTransport.LOGGER;
      boolean loggable = this.loggingEnabled && logger.isLoggable(Level.CONFIG);
      StringBuilder logbuf = null;
      String contentType;
      if (loggable) {
         logbuf = new StringBuilder();
         logbuf.append("-------------- RESPONSE --------------").append(StringUtils.LINE_SEPARATOR);
         contentType = response.getStatusLine();
         if (contentType != null) {
            logbuf.append(contentType);
         } else {
            logbuf.append(this.statusCode);
            if (message != null) {
               logbuf.append(' ').append(message);
            }
         }

         logbuf.append(StringUtils.LINE_SEPARATOR);
      }

      request.getResponseHeaders().fromHttpResponse(response, loggable ? logbuf : null);
      contentType = response.getContentType();
      if (contentType == null) {
         contentType = request.getResponseHeaders().getContentType();
      }

      this.contentType = contentType;
      this.mediaType = contentType == null ? null : new HttpMediaType(contentType);
      if (loggable) {
         logger.config(logbuf.toString());
      }

   }

   public int getContentLoggingLimit() {
      return this.contentLoggingLimit;
   }

   public HttpResponse setContentLoggingLimit(int contentLoggingLimit) {
      Preconditions.checkArgument(contentLoggingLimit >= 0, "The content logging limit must be non-negative.");
      this.contentLoggingLimit = contentLoggingLimit;
      return this;
   }

   public boolean isLoggingEnabled() {
      return this.loggingEnabled;
   }

   public HttpResponse setLoggingEnabled(boolean loggingEnabled) {
      this.loggingEnabled = loggingEnabled;
      return this;
   }

   public String getContentEncoding() {
      return this.contentEncoding;
   }

   public String getContentType() {
      return this.contentType;
   }

   public HttpMediaType getMediaType() {
      return this.mediaType;
   }

   public HttpHeaders getHeaders() {
      return this.request.getResponseHeaders();
   }

   public boolean isSuccessStatusCode() {
      return HttpStatusCodes.isSuccess(this.statusCode);
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public String getStatusMessage() {
      return this.statusMessage;
   }

   public HttpTransport getTransport() {
      return this.request.getTransport();
   }

   public HttpRequest getRequest() {
      return this.request;
   }

   public InputStream getContent() throws IOException {
      if (!this.contentRead) {
         InputStream lowLevelResponseContent = this.response.getContent();
         if (lowLevelResponseContent != null) {
            boolean contentProcessed = false;

            try {
               String contentEncoding = this.contentEncoding;
               if (contentEncoding != null && contentEncoding.contains("gzip")) {
                  lowLevelResponseContent = new GZIPInputStream((InputStream)lowLevelResponseContent);
               }

               Logger logger = HttpTransport.LOGGER;
               if (this.loggingEnabled && logger.isLoggable(Level.CONFIG)) {
                  lowLevelResponseContent = new LoggingInputStream((InputStream)lowLevelResponseContent, logger, Level.CONFIG, this.contentLoggingLimit);
               }

               this.content = (InputStream)lowLevelResponseContent;
               contentProcessed = true;
            } catch (EOFException var8) {
            } finally {
               if (!contentProcessed) {
                  ((InputStream)lowLevelResponseContent).close();
               }

            }
         }

         this.contentRead = true;
      }

      return this.content;
   }

   public void download(OutputStream outputStream) throws IOException {
      InputStream inputStream = this.getContent();
      IOUtils.copy(inputStream, outputStream);
   }

   public void ignore() throws IOException {
      InputStream content = this.getContent();
      if (content != null) {
         content.close();
      }

   }

   public void disconnect() throws IOException {
      this.ignore();
      this.response.disconnect();
   }

   public Object parseAs(Class dataClass) throws IOException {
      return !this.hasMessageBody() ? null : this.request.getParser().parseAndClose(this.getContent(), this.getContentCharset(), dataClass);
   }

   private boolean hasMessageBody() throws IOException {
      int statusCode = this.getStatusCode();
      if (!this.getRequest().getRequestMethod().equals("HEAD") && statusCode / 100 != 1 && statusCode != 204 && statusCode != 304) {
         return true;
      } else {
         this.ignore();
         return false;
      }
   }

   public Object parseAs(Type dataType) throws IOException {
      return !this.hasMessageBody() ? null : this.request.getParser().parseAndClose(this.getContent(), this.getContentCharset(), dataType);
   }

   public String parseAsString() throws IOException {
      InputStream content = this.getContent();
      if (content == null) {
         return "";
      } else {
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         IOUtils.copy(content, out);
         return out.toString(this.getContentCharset().name());
      }
   }

   public Charset getContentCharset() {
      return this.mediaType != null && this.mediaType.getCharsetParameter() != null ? this.mediaType.getCharsetParameter() : Charsets.ISO_8859_1;
   }
}

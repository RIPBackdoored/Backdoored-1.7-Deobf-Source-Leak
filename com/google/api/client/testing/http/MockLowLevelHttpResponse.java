package com.google.api.client.testing.http;

import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.util.TestableByteArrayInputStream;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Beta
public class MockLowLevelHttpResponse extends LowLevelHttpResponse {
   private InputStream content;
   private String contentType;
   private int statusCode = 200;
   private String reasonPhrase;
   private List headerNames = new ArrayList();
   private List headerValues = new ArrayList();
   private String contentEncoding;
   private long contentLength = -1L;
   private boolean isDisconnected;

   public MockLowLevelHttpResponse addHeader(String name, String value) {
      this.headerNames.add(Preconditions.checkNotNull(name));
      this.headerValues.add(Preconditions.checkNotNull(value));
      return this;
   }

   public MockLowLevelHttpResponse setContent(String stringContent) {
      return stringContent == null ? this.setZeroContent() : this.setContent(StringUtils.getBytesUtf8(stringContent));
   }

   public MockLowLevelHttpResponse setContent(byte[] byteContent) {
      if (byteContent == null) {
         return this.setZeroContent();
      } else {
         this.content = new TestableByteArrayInputStream(byteContent);
         this.setContentLength((long)byteContent.length);
         return this;
      }
   }

   public MockLowLevelHttpResponse setZeroContent() {
      this.content = null;
      this.setContentLength(0L);
      return this;
   }

   public InputStream getContent() throws IOException {
      return this.content;
   }

   public String getContentEncoding() {
      return this.contentEncoding;
   }

   public long getContentLength() {
      return this.contentLength;
   }

   public final String getContentType() {
      return this.contentType;
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

   public String getReasonPhrase() {
      return this.reasonPhrase;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public String getStatusLine() {
      StringBuilder buf = new StringBuilder();
      buf.append(this.statusCode);
      if (this.reasonPhrase != null) {
         buf.append(this.reasonPhrase);
      }

      return buf.toString();
   }

   public final List getHeaderNames() {
      return this.headerNames;
   }

   public MockLowLevelHttpResponse setHeaderNames(List headerNames) {
      this.headerNames = (List)Preconditions.checkNotNull(headerNames);
      return this;
   }

   public final List getHeaderValues() {
      return this.headerValues;
   }

   public MockLowLevelHttpResponse setHeaderValues(List headerValues) {
      this.headerValues = (List)Preconditions.checkNotNull(headerValues);
      return this;
   }

   public MockLowLevelHttpResponse setContent(InputStream content) {
      this.content = content;
      return this;
   }

   public MockLowLevelHttpResponse setContentType(String contentType) {
      this.contentType = contentType;
      return this;
   }

   public MockLowLevelHttpResponse setContentEncoding(String contentEncoding) {
      this.contentEncoding = contentEncoding;
      return this;
   }

   public MockLowLevelHttpResponse setContentLength(long contentLength) {
      this.contentLength = contentLength;
      Preconditions.checkArgument(contentLength >= -1L);
      return this;
   }

   public MockLowLevelHttpResponse setStatusCode(int statusCode) {
      this.statusCode = statusCode;
      return this;
   }

   public MockLowLevelHttpResponse setReasonPhrase(String reasonPhrase) {
      this.reasonPhrase = reasonPhrase;
      return this;
   }

   public void disconnect() throws IOException {
      this.isDisconnected = true;
      super.disconnect();
   }

   public boolean isDisconnected() {
      return this.isDisconnected;
   }
}

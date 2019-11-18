package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.InputStream;

public final class InputStreamContent extends AbstractInputStreamContent {
   private long length = -1L;
   private boolean retrySupported;
   private final InputStream inputStream;

   public InputStreamContent(String type, InputStream inputStream) {
      super(type);
      this.inputStream = (InputStream)Preconditions.checkNotNull(inputStream);
   }

   public long getLength() {
      return this.length;
   }

   public boolean retrySupported() {
      return this.retrySupported;
   }

   public InputStreamContent setRetrySupported(boolean retrySupported) {
      this.retrySupported = retrySupported;
      return this;
   }

   public InputStream getInputStream() {
      return this.inputStream;
   }

   public InputStreamContent setType(String type) {
      return (InputStreamContent)super.setType(type);
   }

   public InputStreamContent setCloseInputStream(boolean closeInputStream) {
      return (InputStreamContent)super.setCloseInputStream(closeInputStream);
   }

   public InputStreamContent setLength(long length) {
      this.length = length;
      return this;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractInputStreamContent setCloseInputStream(boolean var1) {
      return this.setCloseInputStream(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractInputStreamContent setType(String var1) {
      return this.setType(var1);
   }
}

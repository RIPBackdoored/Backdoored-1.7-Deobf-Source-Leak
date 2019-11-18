package com.google.api.client.http;

import com.google.api.client.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class AbstractInputStreamContent implements HttpContent {
   private String type;
   private boolean closeInputStream = true;

   public AbstractInputStreamContent(String type) {
      this.setType(type);
   }

   public abstract InputStream getInputStream() throws IOException;

   public void writeTo(OutputStream out) throws IOException {
      IOUtils.copy(this.getInputStream(), out, this.closeInputStream);
      out.flush();
   }

   public String getType() {
      return this.type;
   }

   public final boolean getCloseInputStream() {
      return this.closeInputStream;
   }

   public AbstractInputStreamContent setType(String type) {
      this.type = type;
      return this;
   }

   public AbstractInputStreamContent setCloseInputStream(boolean closeInputStream) {
      this.closeInputStream = closeInputStream;
      return this;
   }
}

package com.google.api.client.http;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class GZipEncoding$1 extends BufferedOutputStream {
   // $FF: synthetic field
   final GZipEncoding this$0;

   GZipEncoding$1(GZipEncoding this$0, OutputStream x0) {
      super(x0);
      this.this$0 = this$0;
   }

   public void close() throws IOException {
      try {
         this.flush();
      } catch (IOException var2) {
      }

   }
}

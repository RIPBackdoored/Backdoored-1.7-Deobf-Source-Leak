package com.google.api.client.http.javanet;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class NetHttpResponse$SizeValidatingInputStream extends FilterInputStream {
   private long bytesRead;
   // $FF: synthetic field
   final NetHttpResponse this$0;

   public NetHttpResponse$SizeValidatingInputStream(NetHttpResponse var1, InputStream in) {
      super(in);
      this.this$0 = var1;
      this.bytesRead = 0L;
   }

   public int read(byte[] b, int off, int len) throws IOException {
      int n = this.in.read(b, off, len);
      if (n == -1) {
         this.throwIfFalseEOF();
      } else {
         this.bytesRead += (long)n;
      }

      return n;
   }

   public int read() throws IOException {
      int n = this.in.read();
      if (n == -1) {
         this.throwIfFalseEOF();
      } else {
         ++this.bytesRead;
      }

      return n;
   }

   private void throwIfFalseEOF() throws IOException {
      long contentLength = this.this$0.getContentLength();
      if (contentLength != -1L) {
         if (this.bytesRead != 0L && this.bytesRead < contentLength) {
            throw new IOException("Connection closed prematurely: bytesRead = " + this.bytesRead + ", Content-Length = " + contentLength);
         }
      }
   }
}

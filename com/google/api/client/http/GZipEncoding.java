package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZipEncoding implements HttpEncoding {
   public String getName() {
      return "gzip";
   }

   public void encode(StreamingContent content, OutputStream out) throws IOException {
      OutputStream out2 = new GZipEncoding$1(this, out);
      GZIPOutputStream zipper = new GZIPOutputStream(out2);
      content.writeTo(zipper);
      zipper.close();
   }
}

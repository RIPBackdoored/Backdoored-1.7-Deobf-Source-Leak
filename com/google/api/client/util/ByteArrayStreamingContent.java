package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayStreamingContent implements StreamingContent {
   private final byte[] byteArray;
   private final int offset;
   private final int length;

   public ByteArrayStreamingContent(byte[] byteArray) {
      this(byteArray, 0, byteArray.length);
   }

   public ByteArrayStreamingContent(byte[] byteArray, int offset, int length) {
      this.byteArray = (byte[])Preconditions.checkNotNull(byteArray);
      Preconditions.checkArgument(offset >= 0 && length >= 0 && offset + length <= byteArray.length);
      this.offset = offset;
      this.length = length;
   }

   public void writeTo(OutputStream out) throws IOException {
      out.write(this.byteArray, this.offset, this.length);
      out.flush();
   }
}

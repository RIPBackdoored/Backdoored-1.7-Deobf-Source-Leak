package com.google.api.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ByteStreams {
   private static final int BUF_SIZE = 4096;

   public static long copy(InputStream from, OutputStream to) throws IOException {
      Preconditions.checkNotNull(from);
      Preconditions.checkNotNull(to);
      byte[] buf = new byte[4096];
      long total = 0L;

      while(true) {
         int r = from.read(buf);
         if (r == -1) {
            return total;
         }

         to.write(buf, 0, r);
         total += (long)r;
      }
   }

   public static InputStream limit(InputStream in, long limit) {
      return new ByteStreams$LimitedInputStream(in, limit);
   }

   public static int read(InputStream in, byte[] b, int off, int len) throws IOException {
      Preconditions.checkNotNull(in);
      Preconditions.checkNotNull(b);
      if (len < 0) {
         throw new IndexOutOfBoundsException("len is negative");
      } else {
         int total;
         int result;
         for(total = 0; total < len; total += result) {
            result = in.read(b, off + total, len - total);
            if (result == -1) {
               break;
            }
         }

         return total;
      }
   }

   private ByteStreams() {
   }
}

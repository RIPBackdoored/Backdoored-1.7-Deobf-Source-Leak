package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Beta
public class TestableByteArrayInputStream extends ByteArrayInputStream {
   private boolean closed;

   public TestableByteArrayInputStream(byte[] buf) {
      super(buf);
   }

   public TestableByteArrayInputStream(byte[] buf, int offset, int length) {
      super(buf);
   }

   public void close() throws IOException {
      this.closed = true;
   }

   public final byte[] getBuffer() {
      return this.buf;
   }

   public final boolean isClosed() {
      return this.closed;
   }
}

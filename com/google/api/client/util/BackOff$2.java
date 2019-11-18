package com.google.api.client.util;

import java.io.IOException;

final class BackOff$2 implements BackOff {
   public void reset() throws IOException {
   }

   public long nextBackOffMillis() throws IOException {
      return -1L;
   }
}

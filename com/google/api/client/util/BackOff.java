package com.google.api.client.util;

import java.io.IOException;

public interface BackOff {
   long STOP = -1L;
   BackOff ZERO_BACKOFF = new BackOff$1();
   BackOff STOP_BACKOFF = new BackOff$2();

   void reset() throws IOException;

   long nextBackOffMillis() throws IOException;
}

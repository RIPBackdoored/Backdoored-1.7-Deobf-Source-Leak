package com.google.api.client.util;

public interface NanoClock {
   NanoClock SYSTEM = new NanoClock$1();

   long nanoTime();
}

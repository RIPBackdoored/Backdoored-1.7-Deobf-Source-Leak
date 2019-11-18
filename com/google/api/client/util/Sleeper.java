package com.google.api.client.util;

public interface Sleeper {
   Sleeper DEFAULT = new Sleeper$1();

   void sleep(long var1) throws InterruptedException;
}

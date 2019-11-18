package com.google.api.client.util;

public interface Clock {
   Clock SYSTEM = new Clock$1();

   long currentTimeMillis();
}

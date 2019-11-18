package com.google.api.client.util;

import java.io.IOException;

@Beta
public final class BackOffUtils {
   public static boolean next(Sleeper sleeper, BackOff backOff) throws InterruptedException, IOException {
      long backOffTime = backOff.nextBackOffMillis();
      if (backOffTime == -1L) {
         return false;
      } else {
         sleeper.sleep(backOffTime);
         return true;
      }
   }

   private BackOffUtils() {
   }
}

package com.google.api.client.http;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;

@Beta
public class HttpBackOffIOExceptionHandler implements HttpIOExceptionHandler {
   private final BackOff backOff;
   private Sleeper sleeper;

   public HttpBackOffIOExceptionHandler(BackOff backOff) {
      this.sleeper = Sleeper.DEFAULT;
      this.backOff = (BackOff)Preconditions.checkNotNull(backOff);
   }

   public final BackOff getBackOff() {
      return this.backOff;
   }

   public final Sleeper getSleeper() {
      return this.sleeper;
   }

   public HttpBackOffIOExceptionHandler setSleeper(Sleeper sleeper) {
      this.sleeper = (Sleeper)Preconditions.checkNotNull(sleeper);
      return this;
   }

   public boolean handleIOException(HttpRequest request, boolean supportsRetry) throws IOException {
      if (!supportsRetry) {
         return false;
      } else {
         boolean var10000;
         try {
            var10000 = BackOffUtils.next(this.sleeper, this.backOff);
         } catch (InterruptedException var4) {
            return false;
         }

         return var10000;
      }
   }
}

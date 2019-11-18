package com.google.api.client.http;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;

@Beta
public class HttpBackOffUnsuccessfulResponseHandler implements HttpUnsuccessfulResponseHandler {
   private final BackOff backOff;
   private HttpBackOffUnsuccessfulResponseHandler$BackOffRequired backOffRequired;
   private Sleeper sleeper;

   public HttpBackOffUnsuccessfulResponseHandler(BackOff backOff) {
      this.backOffRequired = HttpBackOffUnsuccessfulResponseHandler$BackOffRequired.ON_SERVER_ERROR;
      this.sleeper = Sleeper.DEFAULT;
      this.backOff = (BackOff)Preconditions.checkNotNull(backOff);
   }

   public final BackOff getBackOff() {
      return this.backOff;
   }

   public final HttpBackOffUnsuccessfulResponseHandler$BackOffRequired getBackOffRequired() {
      return this.backOffRequired;
   }

   public HttpBackOffUnsuccessfulResponseHandler setBackOffRequired(HttpBackOffUnsuccessfulResponseHandler$BackOffRequired backOffRequired) {
      this.backOffRequired = (HttpBackOffUnsuccessfulResponseHandler$BackOffRequired)Preconditions.checkNotNull(backOffRequired);
      return this;
   }

   public final Sleeper getSleeper() {
      return this.sleeper;
   }

   public HttpBackOffUnsuccessfulResponseHandler setSleeper(Sleeper sleeper) {
      this.sleeper = (Sleeper)Preconditions.checkNotNull(sleeper);
      return this;
   }

   public final boolean handleResponse(HttpRequest request, HttpResponse response, boolean supportsRetry) throws IOException {
      if (!supportsRetry) {
         return false;
      } else if (this.backOffRequired.isRequired(response)) {
         boolean var10000;
         try {
            var10000 = BackOffUtils.next(this.sleeper, this.backOff);
         } catch (InterruptedException var5) {
            return false;
         }

         return var10000;
      } else {
         return false;
      }
   }
}

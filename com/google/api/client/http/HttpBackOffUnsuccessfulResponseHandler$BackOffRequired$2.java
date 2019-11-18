package com.google.api.client.http;

final class HttpBackOffUnsuccessfulResponseHandler$BackOffRequired$2 implements HttpBackOffUnsuccessfulResponseHandler$BackOffRequired {
   public boolean isRequired(HttpResponse response) {
      return response.getStatusCode() / 100 == 5;
   }
}

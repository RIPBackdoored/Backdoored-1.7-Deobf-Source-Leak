package com.google.api.client.http;

import com.google.api.client.util.Beta;

@Beta
public interface HttpBackOffUnsuccessfulResponseHandler$BackOffRequired {
   HttpBackOffUnsuccessfulResponseHandler$BackOffRequired ALWAYS = new HttpBackOffUnsuccessfulResponseHandler$BackOffRequired$1();
   HttpBackOffUnsuccessfulResponseHandler$BackOffRequired ON_SERVER_ERROR = new HttpBackOffUnsuccessfulResponseHandler$BackOffRequired$2();

   boolean isRequired(HttpResponse var1);
}

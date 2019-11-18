package com.google.api.client.http;

import java.io.IOException;

public interface HttpResponseInterceptor {
   void interceptResponse(HttpResponse var1) throws IOException;
}

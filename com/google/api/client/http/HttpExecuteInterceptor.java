package com.google.api.client.http;

import java.io.IOException;

public interface HttpExecuteInterceptor {
   void intercept(HttpRequest var1) throws IOException;
}

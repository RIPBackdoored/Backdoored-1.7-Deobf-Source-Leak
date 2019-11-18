package com.google.api.client.http;

import java.io.IOException;

public interface HttpUnsuccessfulResponseHandler {
   boolean handleResponse(HttpRequest var1, HttpResponse var2, boolean var3) throws IOException;
}

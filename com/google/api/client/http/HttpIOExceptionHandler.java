package com.google.api.client.http;

import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
public interface HttpIOExceptionHandler {
   boolean handleIOException(HttpRequest var1, boolean var2) throws IOException;
}

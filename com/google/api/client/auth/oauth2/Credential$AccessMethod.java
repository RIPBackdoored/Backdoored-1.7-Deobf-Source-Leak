package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpRequest;
import java.io.IOException;

public interface Credential$AccessMethod {
   void intercept(HttpRequest var1, String var2) throws IOException;

   String getAccessTokenFromRequest(HttpRequest var1);
}

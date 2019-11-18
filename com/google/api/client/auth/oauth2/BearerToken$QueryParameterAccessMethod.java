package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpRequest;
import java.io.IOException;

final class BearerToken$QueryParameterAccessMethod implements Credential$AccessMethod {
   public void intercept(HttpRequest request, String accessToken) throws IOException {
      request.getUrl().set("access_token", accessToken);
   }

   public String getAccessTokenFromRequest(HttpRequest request) {
      Object param = request.getUrl().get("access_token");
      return param == null ? null : param.toString();
   }
}

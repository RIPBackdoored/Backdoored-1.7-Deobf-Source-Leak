package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Data;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Map;

final class BearerToken$FormEncodedBodyAccessMethod implements Credential$AccessMethod {
   public void intercept(HttpRequest request, String accessToken) throws IOException {
      Preconditions.checkArgument(!"GET".equals(request.getRequestMethod()), "HTTP GET method is not supported");
      getData(request).put("access_token", accessToken);
   }

   public String getAccessTokenFromRequest(HttpRequest request) {
      Object bodyParam = getData(request).get("access_token");
      return bodyParam == null ? null : bodyParam.toString();
   }

   private static Map getData(HttpRequest request) {
      return Data.mapOf(UrlEncodedContent.getContent(request).getData());
   }
}

package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

final class BearerToken$AuthorizationHeaderAccessMethod implements Credential$AccessMethod {
   static final String HEADER_PREFIX = "Bearer ";

   public void intercept(HttpRequest request, String accessToken) throws IOException {
      request.getHeaders().setAuthorization("Bearer " + accessToken);
   }

   public String getAccessTokenFromRequest(HttpRequest request) {
      List authorizationAsList = request.getHeaders().getAuthorizationAsList();
      if (authorizationAsList != null) {
         Iterator var3 = authorizationAsList.iterator();

         while(var3.hasNext()) {
            String header = (String)var3.next();
            if (header.startsWith("Bearer ")) {
               return header.substring("Bearer ".length());
            }
         }
      }

      return null;
   }
}

package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Key;

public final class ClientLogin$Response implements HttpExecuteInterceptor, HttpRequestInitializer {
   @Key("Auth")
   public String auth;

   public String getAuthorizationHeaderValue() {
      return ClientLogin.getAuthorizationHeaderValue(this.auth);
   }

   public void initialize(HttpRequest request) {
      request.setInterceptor(this);
   }

   public void intercept(HttpRequest request) {
      request.getHeaders().setAuthorization(this.getAuthorizationHeaderValue());
   }
}

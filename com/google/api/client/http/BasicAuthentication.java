package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import java.io.IOException;

public final class BasicAuthentication implements HttpRequestInitializer, HttpExecuteInterceptor {
   private final String username;
   private final String password;

   public BasicAuthentication(String username, String password) {
      this.username = (String)Preconditions.checkNotNull(username);
      this.password = (String)Preconditions.checkNotNull(password);
   }

   public void initialize(HttpRequest request) throws IOException {
      request.setInterceptor(this);
   }

   public void intercept(HttpRequest request) throws IOException {
      request.getHeaders().setBasicAuthentication(this.username, this.password);
   }

   public String getUsername() {
      return this.username;
   }

   public String getPassword() {
      return this.password;
   }
}

package com.google.api.client.auth.oauth2;

import java.util.regex.Pattern;

public class BearerToken {
   static final String PARAM_NAME = "access_token";
   static final Pattern INVALID_TOKEN_ERROR = Pattern.compile("\\s*error\\s*=\\s*\"?invalid_token\"?");

   public static Credential$AccessMethod authorizationHeaderAccessMethod() {
      return new BearerToken$AuthorizationHeaderAccessMethod();
   }

   public static Credential$AccessMethod formEncodedBodyAccessMethod() {
      return new BearerToken$FormEncodedBodyAccessMethod();
   }

   public static Credential$AccessMethod queryParameterAccessMethod() {
      return new BearerToken$QueryParameterAccessMethod();
   }
}

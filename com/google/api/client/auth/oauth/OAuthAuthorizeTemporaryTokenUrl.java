package com.google.api.client.auth.oauth;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;

@Beta
public class OAuthAuthorizeTemporaryTokenUrl extends GenericUrl {
   @Key("oauth_token")
   public String temporaryToken;

   public OAuthAuthorizeTemporaryTokenUrl(String encodedUserAuthorizationUrl) {
      super(encodedUserAuthorizationUrl);
   }
}

package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;

@Beta
public class OAuthGetTemporaryToken extends AbstractOAuthGetToken {
   public String callback;

   public OAuthGetTemporaryToken(String authorizationServerUrl) {
      super(authorizationServerUrl);
   }

   public OAuthParameters createParameters() {
      OAuthParameters result = super.createParameters();
      result.callback = this.callback;
      return result;
   }
}

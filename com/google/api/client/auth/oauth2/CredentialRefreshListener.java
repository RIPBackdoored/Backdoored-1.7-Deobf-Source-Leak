package com.google.api.client.auth.oauth2;

import java.io.IOException;

public interface CredentialRefreshListener {
   void onTokenResponse(Credential var1, TokenResponse var2) throws IOException;

   void onTokenErrorResponse(Credential var1, TokenErrorResponse var2) throws IOException;
}

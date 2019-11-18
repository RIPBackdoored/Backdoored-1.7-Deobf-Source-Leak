package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;
import java.security.GeneralSecurityException;

@Beta
public interface OAuthSigner {
   String getSignatureMethod();

   String computeSignature(String var1) throws GeneralSecurityException;
}

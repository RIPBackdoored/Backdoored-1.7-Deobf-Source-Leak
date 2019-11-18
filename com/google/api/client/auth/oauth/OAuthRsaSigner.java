package com.google.api.client.auth.oauth;

import com.google.api.client.util.Base64;
import com.google.api.client.util.Beta;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Signature;

@Beta
public final class OAuthRsaSigner implements OAuthSigner {
   public PrivateKey privateKey;

   public String getSignatureMethod() {
      return "RSA-SHA1";
   }

   public String computeSignature(String signatureBaseString) throws GeneralSecurityException {
      Signature signer = SecurityUtils.getSha1WithRsaSignatureAlgorithm();
      byte[] data = StringUtils.getBytesUtf8(signatureBaseString);
      return Base64.encodeBase64String(SecurityUtils.sign(signer, this.privateKey, data));
   }
}

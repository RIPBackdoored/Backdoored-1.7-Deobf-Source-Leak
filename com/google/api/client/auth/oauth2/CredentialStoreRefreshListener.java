package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

/** @deprecated */
@Deprecated
@Beta
public final class CredentialStoreRefreshListener implements CredentialRefreshListener {
   private final CredentialStore credentialStore;
   private final String userId;

   public CredentialStoreRefreshListener(String userId, CredentialStore credentialStore) {
      this.userId = (String)Preconditions.checkNotNull(userId);
      this.credentialStore = (CredentialStore)Preconditions.checkNotNull(credentialStore);
   }

   public void onTokenResponse(Credential credential, TokenResponse tokenResponse) throws IOException {
      this.makePersistent(credential);
   }

   public void onTokenErrorResponse(Credential credential, TokenErrorResponse tokenErrorResponse) throws IOException {
      this.makePersistent(credential);
   }

   public CredentialStore getCredentialStore() {
      return this.credentialStore;
   }

   public void makePersistent(Credential credential) throws IOException {
      this.credentialStore.store(this.userId, credential);
   }
}

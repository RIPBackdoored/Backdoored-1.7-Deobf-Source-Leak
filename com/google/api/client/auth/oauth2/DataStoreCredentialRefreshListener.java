package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;

@Beta
public final class DataStoreCredentialRefreshListener implements CredentialRefreshListener {
   private final DataStore credentialDataStore;
   private final String userId;

   public DataStoreCredentialRefreshListener(String userId, DataStoreFactory dataStoreFactory) throws IOException {
      this(userId, StoredCredential.getDefaultDataStore(dataStoreFactory));
   }

   public DataStoreCredentialRefreshListener(String userId, DataStore credentialDataStore) {
      this.userId = (String)Preconditions.checkNotNull(userId);
      this.credentialDataStore = (DataStore)Preconditions.checkNotNull(credentialDataStore);
   }

   public void onTokenResponse(Credential credential, TokenResponse tokenResponse) throws IOException {
      this.makePersistent(credential);
   }

   public void onTokenErrorResponse(Credential credential, TokenErrorResponse tokenErrorResponse) throws IOException {
      this.makePersistent(credential);
   }

   public DataStore getCredentialDataStore() {
      return this.credentialDataStore;
   }

   public void makePersistent(Credential credential) throws IOException {
      this.credentialDataStore.set(this.userId, new StoredCredential(credential));
   }
}

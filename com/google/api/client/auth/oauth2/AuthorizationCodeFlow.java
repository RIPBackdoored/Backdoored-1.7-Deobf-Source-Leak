package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Strings;
import com.google.api.client.util.store.DataStore;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class AuthorizationCodeFlow {
   private final Credential$AccessMethod method;
   private final HttpTransport transport;
   private final JsonFactory jsonFactory;
   private final String tokenServerEncodedUrl;
   private final HttpExecuteInterceptor clientAuthentication;
   private final String clientId;
   private final String authorizationServerEncodedUrl;
   /** @deprecated */
   @Deprecated
   @Beta
   private final CredentialStore credentialStore;
   @Beta
   private final DataStore credentialDataStore;
   private final HttpRequestInitializer requestInitializer;
   private final Clock clock;
   private final Collection scopes;
   private final AuthorizationCodeFlow$CredentialCreatedListener credentialCreatedListener;
   private final Collection refreshListeners;

   public AuthorizationCodeFlow(Credential$AccessMethod method, HttpTransport transport, JsonFactory jsonFactory, GenericUrl tokenServerUrl, HttpExecuteInterceptor clientAuthentication, String clientId, String authorizationServerEncodedUrl) {
      this(new AuthorizationCodeFlow$Builder(method, transport, jsonFactory, tokenServerUrl, clientAuthentication, clientId, authorizationServerEncodedUrl));
   }

   protected AuthorizationCodeFlow(AuthorizationCodeFlow$Builder builder) {
      this.method = (Credential$AccessMethod)Preconditions.checkNotNull(builder.method);
      this.transport = (HttpTransport)Preconditions.checkNotNull(builder.transport);
      this.jsonFactory = (JsonFactory)Preconditions.checkNotNull(builder.jsonFactory);
      this.tokenServerEncodedUrl = ((GenericUrl)Preconditions.checkNotNull(builder.tokenServerUrl)).build();
      this.clientAuthentication = builder.clientAuthentication;
      this.clientId = (String)Preconditions.checkNotNull(builder.clientId);
      this.authorizationServerEncodedUrl = (String)Preconditions.checkNotNull(builder.authorizationServerEncodedUrl);
      this.requestInitializer = builder.requestInitializer;
      this.credentialStore = builder.credentialStore;
      this.credentialDataStore = builder.credentialDataStore;
      this.scopes = Collections.unmodifiableCollection(builder.scopes);
      this.clock = (Clock)Preconditions.checkNotNull(builder.clock);
      this.credentialCreatedListener = builder.credentialCreatedListener;
      this.refreshListeners = Collections.unmodifiableCollection(builder.refreshListeners);
   }

   public AuthorizationCodeRequestUrl newAuthorizationUrl() {
      return (new AuthorizationCodeRequestUrl(this.authorizationServerEncodedUrl, this.clientId)).setScopes(this.scopes);
   }

   public AuthorizationCodeTokenRequest newTokenRequest(String authorizationCode) {
      return (new AuthorizationCodeTokenRequest(this.transport, this.jsonFactory, new GenericUrl(this.tokenServerEncodedUrl), authorizationCode)).setClientAuthentication(this.clientAuthentication).setRequestInitializer(this.requestInitializer).setScopes(this.scopes);
   }

   public Credential createAndStoreCredential(TokenResponse response, String userId) throws IOException {
      Credential credential = this.newCredential(userId).setFromTokenResponse(response);
      if (this.credentialStore != null) {
         this.credentialStore.store(userId, credential);
      }

      if (this.credentialDataStore != null) {
         this.credentialDataStore.set(userId, new StoredCredential(credential));
      }

      if (this.credentialCreatedListener != null) {
         this.credentialCreatedListener.onCredentialCreated(credential, response);
      }

      return credential;
   }

   public Credential loadCredential(String userId) throws IOException {
      if (Strings.isNullOrEmpty(userId)) {
         return null;
      } else if (this.credentialDataStore == null && this.credentialStore == null) {
         return null;
      } else {
         Credential credential = this.newCredential(userId);
         if (this.credentialDataStore != null) {
            StoredCredential stored = (StoredCredential)this.credentialDataStore.get(userId);
            if (stored == null) {
               return null;
            }

            credential.setAccessToken(stored.getAccessToken());
            credential.setRefreshToken(stored.getRefreshToken());
            credential.setExpirationTimeMilliseconds(stored.getExpirationTimeMilliseconds());
         } else if (!this.credentialStore.load(userId, credential)) {
            return null;
         }

         return credential;
      }
   }

   private Credential newCredential(String userId) {
      Credential$Builder builder = (new Credential$Builder(this.method)).setTransport(this.transport).setJsonFactory(this.jsonFactory).setTokenServerEncodedUrl(this.tokenServerEncodedUrl).setClientAuthentication(this.clientAuthentication).setRequestInitializer(this.requestInitializer).setClock(this.clock);
      if (this.credentialDataStore != null) {
         builder.addRefreshListener(new DataStoreCredentialRefreshListener(userId, this.credentialDataStore));
      } else if (this.credentialStore != null) {
         builder.addRefreshListener(new CredentialStoreRefreshListener(userId, this.credentialStore));
      }

      builder.getRefreshListeners().addAll(this.refreshListeners);
      return builder.build();
   }

   public final Credential$AccessMethod getMethod() {
      return this.method;
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final String getTokenServerEncodedUrl() {
      return this.tokenServerEncodedUrl;
   }

   public final HttpExecuteInterceptor getClientAuthentication() {
      return this.clientAuthentication;
   }

   public final String getClientId() {
      return this.clientId;
   }

   public final String getAuthorizationServerEncodedUrl() {
      return this.authorizationServerEncodedUrl;
   }

   /** @deprecated */
   @Deprecated
   @Beta
   public final CredentialStore getCredentialStore() {
      return this.credentialStore;
   }

   @Beta
   public final DataStore getCredentialDataStore() {
      return this.credentialDataStore;
   }

   public final HttpRequestInitializer getRequestInitializer() {
      return this.requestInitializer;
   }

   public final String getScopesAsString() {
      return Joiner.on(' ').join(this.scopes);
   }

   public final Collection getScopes() {
      return this.scopes;
   }

   public final Clock getClock() {
      return this.clock;
   }

   public final Collection getRefreshListeners() {
      return this.refreshListeners;
   }
}

package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.util.Collection;

public class AuthorizationCodeFlow$Builder {
   Credential$AccessMethod method;
   HttpTransport transport;
   JsonFactory jsonFactory;
   GenericUrl tokenServerUrl;
   HttpExecuteInterceptor clientAuthentication;
   String clientId;
   String authorizationServerEncodedUrl;
   /** @deprecated */
   @Deprecated
   @Beta
   CredentialStore credentialStore;
   @Beta
   DataStore credentialDataStore;
   HttpRequestInitializer requestInitializer;
   Collection scopes = Lists.newArrayList();
   Clock clock;
   AuthorizationCodeFlow$CredentialCreatedListener credentialCreatedListener;
   Collection refreshListeners;

   public AuthorizationCodeFlow$Builder(Credential$AccessMethod method, HttpTransport transport, JsonFactory jsonFactory, GenericUrl tokenServerUrl, HttpExecuteInterceptor clientAuthentication, String clientId, String authorizationServerEncodedUrl) {
      this.clock = Clock.SYSTEM;
      this.refreshListeners = Lists.newArrayList();
      this.setMethod(method);
      this.setTransport(transport);
      this.setJsonFactory(jsonFactory);
      this.setTokenServerUrl(tokenServerUrl);
      this.setClientAuthentication(clientAuthentication);
      this.setClientId(clientId);
      this.setAuthorizationServerEncodedUrl(authorizationServerEncodedUrl);
   }

   public AuthorizationCodeFlow build() {
      return new AuthorizationCodeFlow(this);
   }

   public final Credential$AccessMethod getMethod() {
      return this.method;
   }

   public AuthorizationCodeFlow$Builder setMethod(Credential$AccessMethod method) {
      this.method = (Credential$AccessMethod)Preconditions.checkNotNull(method);
      return this;
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public AuthorizationCodeFlow$Builder setTransport(HttpTransport transport) {
      this.transport = (HttpTransport)Preconditions.checkNotNull(transport);
      return this;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public AuthorizationCodeFlow$Builder setJsonFactory(JsonFactory jsonFactory) {
      this.jsonFactory = (JsonFactory)Preconditions.checkNotNull(jsonFactory);
      return this;
   }

   public final GenericUrl getTokenServerUrl() {
      return this.tokenServerUrl;
   }

   public AuthorizationCodeFlow$Builder setTokenServerUrl(GenericUrl tokenServerUrl) {
      this.tokenServerUrl = (GenericUrl)Preconditions.checkNotNull(tokenServerUrl);
      return this;
   }

   public final HttpExecuteInterceptor getClientAuthentication() {
      return this.clientAuthentication;
   }

   public AuthorizationCodeFlow$Builder setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      this.clientAuthentication = clientAuthentication;
      return this;
   }

   public final String getClientId() {
      return this.clientId;
   }

   public AuthorizationCodeFlow$Builder setClientId(String clientId) {
      this.clientId = (String)Preconditions.checkNotNull(clientId);
      return this;
   }

   public final String getAuthorizationServerEncodedUrl() {
      return this.authorizationServerEncodedUrl;
   }

   public AuthorizationCodeFlow$Builder setAuthorizationServerEncodedUrl(String authorizationServerEncodedUrl) {
      this.authorizationServerEncodedUrl = (String)Preconditions.checkNotNull(authorizationServerEncodedUrl);
      return this;
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

   public final Clock getClock() {
      return this.clock;
   }

   public AuthorizationCodeFlow$Builder setClock(Clock clock) {
      this.clock = (Clock)Preconditions.checkNotNull(clock);
      return this;
   }

   /** @deprecated */
   @Deprecated
   @Beta
   public AuthorizationCodeFlow$Builder setCredentialStore(CredentialStore credentialStore) {
      Preconditions.checkArgument(this.credentialDataStore == null);
      this.credentialStore = credentialStore;
      return this;
   }

   @Beta
   public AuthorizationCodeFlow$Builder setDataStoreFactory(DataStoreFactory dataStoreFactory) throws IOException {
      return this.setCredentialDataStore(StoredCredential.getDefaultDataStore(dataStoreFactory));
   }

   @Beta
   public AuthorizationCodeFlow$Builder setCredentialDataStore(DataStore credentialDataStore) {
      Preconditions.checkArgument(this.credentialStore == null);
      this.credentialDataStore = credentialDataStore;
      return this;
   }

   public final HttpRequestInitializer getRequestInitializer() {
      return this.requestInitializer;
   }

   public AuthorizationCodeFlow$Builder setRequestInitializer(HttpRequestInitializer requestInitializer) {
      this.requestInitializer = requestInitializer;
      return this;
   }

   public AuthorizationCodeFlow$Builder setScopes(Collection scopes) {
      this.scopes = (Collection)Preconditions.checkNotNull(scopes);
      return this;
   }

   public final Collection getScopes() {
      return this.scopes;
   }

   public AuthorizationCodeFlow$Builder setCredentialCreatedListener(AuthorizationCodeFlow$CredentialCreatedListener credentialCreatedListener) {
      this.credentialCreatedListener = credentialCreatedListener;
      return this;
   }

   public AuthorizationCodeFlow$Builder addRefreshListener(CredentialRefreshListener refreshListener) {
      this.refreshListeners.add(Preconditions.checkNotNull(refreshListener));
      return this;
   }

   public final Collection getRefreshListeners() {
      return this.refreshListeners;
   }

   public AuthorizationCodeFlow$Builder setRefreshListeners(Collection refreshListeners) {
      this.refreshListeners = (Collection)Preconditions.checkNotNull(refreshListeners);
      return this;
   }

   public final AuthorizationCodeFlow$CredentialCreatedListener getCredentialCreatedListener() {
      return this.credentialCreatedListener;
   }
}

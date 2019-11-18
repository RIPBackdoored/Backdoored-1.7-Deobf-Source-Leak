package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow$Builder;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow$CredentialCreatedListener;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential$AccessMethod;
import com.google.api.client.auth.oauth2.CredentialRefreshListener;
import com.google.api.client.auth.oauth2.CredentialStore;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.util.Collection;

public class GoogleAuthorizationCodeFlow$Builder extends AuthorizationCodeFlow$Builder {
   String approvalPrompt;
   String accessType;

   public GoogleAuthorizationCodeFlow$Builder(HttpTransport transport, JsonFactory jsonFactory, String clientId, String clientSecret, Collection scopes) {
      super(BearerToken.authorizationHeaderAccessMethod(), transport, jsonFactory, new GenericUrl("https://accounts.google.com/o/oauth2/token"), new ClientParametersAuthentication(clientId, clientSecret), clientId, "https://accounts.google.com/o/oauth2/auth");
      this.setScopes(scopes);
   }

   public GoogleAuthorizationCodeFlow$Builder(HttpTransport transport, JsonFactory jsonFactory, GoogleClientSecrets clientSecrets, Collection scopes) {
      super(BearerToken.authorizationHeaderAccessMethod(), transport, jsonFactory, new GenericUrl("https://accounts.google.com/o/oauth2/token"), new ClientParametersAuthentication(clientSecrets.getDetails().getClientId(), clientSecrets.getDetails().getClientSecret()), clientSecrets.getDetails().getClientId(), "https://accounts.google.com/o/oauth2/auth");
      this.setScopes(scopes);
   }

   public GoogleAuthorizationCodeFlow build() {
      return new GoogleAuthorizationCodeFlow(this);
   }

   public GoogleAuthorizationCodeFlow$Builder setDataStoreFactory(DataStoreFactory dataStore) throws IOException {
      return (GoogleAuthorizationCodeFlow$Builder)super.setDataStoreFactory(dataStore);
   }

   public GoogleAuthorizationCodeFlow$Builder setCredentialDataStore(DataStore typedDataStore) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setCredentialDataStore(typedDataStore);
   }

   public GoogleAuthorizationCodeFlow$Builder setCredentialCreatedListener(AuthorizationCodeFlow$CredentialCreatedListener credentialCreatedListener) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setCredentialCreatedListener(credentialCreatedListener);
   }

   /** @deprecated */
   @Deprecated
   @Deprecated
   @Beta
   @Beta
   public GoogleAuthorizationCodeFlow$Builder setCredentialStore(CredentialStore credentialStore) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setCredentialStore(credentialStore);
   }

   public GoogleAuthorizationCodeFlow$Builder setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setRequestInitializer(requestInitializer);
   }

   public GoogleAuthorizationCodeFlow$Builder setScopes(Collection scopes) {
      Preconditions.checkState(!scopes.isEmpty());
      return (GoogleAuthorizationCodeFlow$Builder)super.setScopes(scopes);
   }

   public GoogleAuthorizationCodeFlow$Builder setMethod(Credential$AccessMethod method) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setMethod(method);
   }

   public GoogleAuthorizationCodeFlow$Builder setTransport(HttpTransport transport) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setTransport(transport);
   }

   public GoogleAuthorizationCodeFlow$Builder setJsonFactory(JsonFactory jsonFactory) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setJsonFactory(jsonFactory);
   }

   public GoogleAuthorizationCodeFlow$Builder setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setTokenServerUrl(tokenServerUrl);
   }

   public GoogleAuthorizationCodeFlow$Builder setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setClientAuthentication(clientAuthentication);
   }

   public GoogleAuthorizationCodeFlow$Builder setClientId(String clientId) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setClientId(clientId);
   }

   public GoogleAuthorizationCodeFlow$Builder setAuthorizationServerEncodedUrl(String authorizationServerEncodedUrl) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setAuthorizationServerEncodedUrl(authorizationServerEncodedUrl);
   }

   public GoogleAuthorizationCodeFlow$Builder setClock(Clock clock) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setClock(clock);
   }

   public GoogleAuthorizationCodeFlow$Builder addRefreshListener(CredentialRefreshListener refreshListener) {
      return (GoogleAuthorizationCodeFlow$Builder)super.addRefreshListener(refreshListener);
   }

   public GoogleAuthorizationCodeFlow$Builder setRefreshListeners(Collection refreshListeners) {
      return (GoogleAuthorizationCodeFlow$Builder)super.setRefreshListeners(refreshListeners);
   }

   public GoogleAuthorizationCodeFlow$Builder setApprovalPrompt(String approvalPrompt) {
      this.approvalPrompt = approvalPrompt;
      return this;
   }

   public final String getApprovalPrompt() {
      return this.approvalPrompt;
   }

   public GoogleAuthorizationCodeFlow$Builder setAccessType(String accessType) {
      this.accessType = accessType;
      return this;
   }

   public final String getAccessType() {
      return this.accessType;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setRefreshListeners(Collection var1) {
      return this.setRefreshListeners(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder addRefreshListener(CredentialRefreshListener var1) {
      return this.addRefreshListener(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setCredentialCreatedListener(AuthorizationCodeFlow$CredentialCreatedListener var1) {
      return this.setCredentialCreatedListener(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setScopes(Collection var1) {
      return this.setScopes(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setRequestInitializer(HttpRequestInitializer var1) {
      return this.setRequestInitializer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setCredentialDataStore(DataStore var1) {
      return this.setCredentialDataStore(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setDataStoreFactory(DataStoreFactory var1) throws IOException {
      return this.setDataStoreFactory(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   @Deprecated
   @Deprecated
   @Beta
   @Beta
   public AuthorizationCodeFlow$Builder setCredentialStore(CredentialStore var1) {
      return this.setCredentialStore(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setClock(Clock var1) {
      return this.setClock(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setAuthorizationServerEncodedUrl(String var1) {
      return this.setAuthorizationServerEncodedUrl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setClientId(String var1) {
      return this.setClientId(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setClientAuthentication(HttpExecuteInterceptor var1) {
      return this.setClientAuthentication(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setTokenServerUrl(GenericUrl var1) {
      return this.setTokenServerUrl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setJsonFactory(JsonFactory var1) {
      return this.setJsonFactory(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setTransport(HttpTransport var1) {
      return this.setTransport(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow$Builder setMethod(Credential$AccessMethod var1) {
      return this.setMethod(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeFlow build() {
      return this.build();
   }
}

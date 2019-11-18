package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.Credential$Builder;
import com.google.api.client.auth.oauth2.CredentialRefreshListener;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.PemReader;
import com.google.api.client.util.SecurityUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collection;

public class GoogleCredential$Builder extends Credential$Builder {
   String serviceAccountId;
   Collection serviceAccountScopes;
   PrivateKey serviceAccountPrivateKey;
   String serviceAccountPrivateKeyId;
   String serviceAccountProjectId;
   String serviceAccountUser;

   public GoogleCredential$Builder() {
      super(BearerToken.authorizationHeaderAccessMethod());
      this.setTokenServerEncodedUrl("https://accounts.google.com/o/oauth2/token");
   }

   public GoogleCredential build() {
      return new GoogleCredential(this);
   }

   public GoogleCredential$Builder setTransport(HttpTransport transport) {
      return (GoogleCredential$Builder)super.setTransport(transport);
   }

   public GoogleCredential$Builder setJsonFactory(JsonFactory jsonFactory) {
      return (GoogleCredential$Builder)super.setJsonFactory(jsonFactory);
   }

   public GoogleCredential$Builder setClock(Clock clock) {
      return (GoogleCredential$Builder)super.setClock(clock);
   }

   public GoogleCredential$Builder setClientSecrets(String clientId, String clientSecret) {
      this.setClientAuthentication(new ClientParametersAuthentication(clientId, clientSecret));
      return this;
   }

   public GoogleCredential$Builder setClientSecrets(GoogleClientSecrets clientSecrets) {
      GoogleClientSecrets$Details details = clientSecrets.getDetails();
      this.setClientAuthentication(new ClientParametersAuthentication(details.getClientId(), details.getClientSecret()));
      return this;
   }

   public final String getServiceAccountId() {
      return this.serviceAccountId;
   }

   public GoogleCredential$Builder setServiceAccountId(String serviceAccountId) {
      this.serviceAccountId = serviceAccountId;
      return this;
   }

   public final String getServiceAccountProjectId() {
      return this.serviceAccountProjectId;
   }

   public GoogleCredential$Builder setServiceAccountProjectId(String serviceAccountProjectId) {
      this.serviceAccountProjectId = serviceAccountProjectId;
      return this;
   }

   public final Collection getServiceAccountScopes() {
      return this.serviceAccountScopes;
   }

   public GoogleCredential$Builder setServiceAccountScopes(Collection serviceAccountScopes) {
      this.serviceAccountScopes = serviceAccountScopes;
      return this;
   }

   public final PrivateKey getServiceAccountPrivateKey() {
      return this.serviceAccountPrivateKey;
   }

   public GoogleCredential$Builder setServiceAccountPrivateKey(PrivateKey serviceAccountPrivateKey) {
      this.serviceAccountPrivateKey = serviceAccountPrivateKey;
      return this;
   }

   @Beta
   @Beta
   public final String getServiceAccountPrivateKeyId() {
      return this.serviceAccountPrivateKeyId;
   }

   @Beta
   @Beta
   public GoogleCredential$Builder setServiceAccountPrivateKeyId(String serviceAccountPrivateKeyId) {
      this.serviceAccountPrivateKeyId = serviceAccountPrivateKeyId;
      return this;
   }

   public GoogleCredential$Builder setServiceAccountPrivateKeyFromP12File(File p12File) throws GeneralSecurityException, IOException {
      this.serviceAccountPrivateKey = SecurityUtils.loadPrivateKeyFromKeyStore(SecurityUtils.getPkcs12KeyStore(), new FileInputStream(p12File), "notasecret", "privatekey", "notasecret");
      return this;
   }

   @Beta
   @Beta
   public GoogleCredential$Builder setServiceAccountPrivateKeyFromPemFile(File pemFile) throws GeneralSecurityException, IOException {
      byte[] bytes = PemReader.readFirstSectionAndClose(new FileReader(pemFile), "PRIVATE KEY").getBase64DecodedBytes();
      this.serviceAccountPrivateKey = SecurityUtils.getRsaKeyFactory().generatePrivate(new PKCS8EncodedKeySpec(bytes));
      return this;
   }

   public final String getServiceAccountUser() {
      return this.serviceAccountUser;
   }

   public GoogleCredential$Builder setServiceAccountUser(String serviceAccountUser) {
      this.serviceAccountUser = serviceAccountUser;
      return this;
   }

   public GoogleCredential$Builder setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (GoogleCredential$Builder)super.setRequestInitializer(requestInitializer);
   }

   public GoogleCredential$Builder addRefreshListener(CredentialRefreshListener refreshListener) {
      return (GoogleCredential$Builder)super.addRefreshListener(refreshListener);
   }

   public GoogleCredential$Builder setRefreshListeners(Collection refreshListeners) {
      return (GoogleCredential$Builder)super.setRefreshListeners(refreshListeners);
   }

   public GoogleCredential$Builder setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (GoogleCredential$Builder)super.setTokenServerUrl(tokenServerUrl);
   }

   public GoogleCredential$Builder setTokenServerEncodedUrl(String tokenServerEncodedUrl) {
      return (GoogleCredential$Builder)super.setTokenServerEncodedUrl(tokenServerEncodedUrl);
   }

   public GoogleCredential$Builder setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      return (GoogleCredential$Builder)super.setClientAuthentication(clientAuthentication);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential$Builder setRefreshListeners(Collection var1) {
      return this.setRefreshListeners(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential$Builder addRefreshListener(CredentialRefreshListener var1) {
      return this.addRefreshListener(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential$Builder setRequestInitializer(HttpRequestInitializer var1) {
      return this.setRequestInitializer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential$Builder setClientAuthentication(HttpExecuteInterceptor var1) {
      return this.setClientAuthentication(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential$Builder setTokenServerEncodedUrl(String var1) {
      return this.setTokenServerEncodedUrl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential$Builder setTokenServerUrl(GenericUrl var1) {
      return this.setTokenServerUrl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential$Builder setJsonFactory(JsonFactory var1) {
      return this.setJsonFactory(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential$Builder setClock(Clock var1) {
      return this.setClock(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential$Builder setTransport(HttpTransport var1) {
      return this.setTransport(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential build() {
      return this.build();
   }
}

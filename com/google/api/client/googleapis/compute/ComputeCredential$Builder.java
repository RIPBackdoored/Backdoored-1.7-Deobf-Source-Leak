package com.google.api.client.googleapis.compute;

import com.google.api.client.auth.oauth2.BearerToken;
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
import com.google.api.client.util.Preconditions;
import java.util.Collection;

@Beta
public class ComputeCredential$Builder extends Credential$Builder {
   public ComputeCredential$Builder(HttpTransport transport, JsonFactory jsonFactory) {
      super(BearerToken.authorizationHeaderAccessMethod());
      this.setTransport(transport);
      this.setJsonFactory(jsonFactory);
      this.setTokenServerEncodedUrl(ComputeCredential.TOKEN_SERVER_ENCODED_URL);
   }

   public ComputeCredential build() {
      return new ComputeCredential(this);
   }

   public ComputeCredential$Builder setTransport(HttpTransport transport) {
      return (ComputeCredential$Builder)super.setTransport((HttpTransport)Preconditions.checkNotNull(transport));
   }

   public ComputeCredential$Builder setClock(Clock clock) {
      return (ComputeCredential$Builder)super.setClock(clock);
   }

   public ComputeCredential$Builder setJsonFactory(JsonFactory jsonFactory) {
      return (ComputeCredential$Builder)super.setJsonFactory((JsonFactory)Preconditions.checkNotNull(jsonFactory));
   }

   public ComputeCredential$Builder setTokenServerUrl(GenericUrl tokenServerUrl) {
      return (ComputeCredential$Builder)super.setTokenServerUrl((GenericUrl)Preconditions.checkNotNull(tokenServerUrl));
   }

   public ComputeCredential$Builder setTokenServerEncodedUrl(String tokenServerEncodedUrl) {
      return (ComputeCredential$Builder)super.setTokenServerEncodedUrl((String)Preconditions.checkNotNull(tokenServerEncodedUrl));
   }

   public ComputeCredential$Builder setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      Preconditions.checkArgument(clientAuthentication == null);
      return this;
   }

   public ComputeCredential$Builder setRequestInitializer(HttpRequestInitializer requestInitializer) {
      return (ComputeCredential$Builder)super.setRequestInitializer(requestInitializer);
   }

   public ComputeCredential$Builder addRefreshListener(CredentialRefreshListener refreshListener) {
      return (ComputeCredential$Builder)super.addRefreshListener(refreshListener);
   }

   public ComputeCredential$Builder setRefreshListeners(Collection refreshListeners) {
      return (ComputeCredential$Builder)super.setRefreshListeners(refreshListeners);
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

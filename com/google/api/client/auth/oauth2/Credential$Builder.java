package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Preconditions;
import java.util.Collection;

public class Credential$Builder {
   final Credential$AccessMethod method;
   HttpTransport transport;
   JsonFactory jsonFactory;
   GenericUrl tokenServerUrl;
   Clock clock;
   HttpExecuteInterceptor clientAuthentication;
   HttpRequestInitializer requestInitializer;
   Collection refreshListeners;

   public Credential$Builder(Credential$AccessMethod method) {
      this.clock = Clock.SYSTEM;
      this.refreshListeners = Lists.newArrayList();
      this.method = (Credential$AccessMethod)Preconditions.checkNotNull(method);
   }

   public Credential build() {
      return new Credential(this);
   }

   public final Credential$AccessMethod getMethod() {
      return this.method;
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public Credential$Builder setTransport(HttpTransport transport) {
      this.transport = transport;
      return this;
   }

   public final Clock getClock() {
      return this.clock;
   }

   public Credential$Builder setClock(Clock clock) {
      this.clock = (Clock)Preconditions.checkNotNull(clock);
      return this;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public Credential$Builder setJsonFactory(JsonFactory jsonFactory) {
      this.jsonFactory = jsonFactory;
      return this;
   }

   public final GenericUrl getTokenServerUrl() {
      return this.tokenServerUrl;
   }

   public Credential$Builder setTokenServerUrl(GenericUrl tokenServerUrl) {
      this.tokenServerUrl = tokenServerUrl;
      return this;
   }

   public Credential$Builder setTokenServerEncodedUrl(String tokenServerEncodedUrl) {
      this.tokenServerUrl = tokenServerEncodedUrl == null ? null : new GenericUrl(tokenServerEncodedUrl);
      return this;
   }

   public final HttpExecuteInterceptor getClientAuthentication() {
      return this.clientAuthentication;
   }

   public Credential$Builder setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      this.clientAuthentication = clientAuthentication;
      return this;
   }

   public final HttpRequestInitializer getRequestInitializer() {
      return this.requestInitializer;
   }

   public Credential$Builder setRequestInitializer(HttpRequestInitializer requestInitializer) {
      this.requestInitializer = requestInitializer;
      return this;
   }

   public Credential$Builder addRefreshListener(CredentialRefreshListener refreshListener) {
      this.refreshListeners.add(Preconditions.checkNotNull(refreshListener));
      return this;
   }

   public final Collection getRefreshListeners() {
      return this.refreshListeners;
   }

   public Credential$Builder setRefreshListeners(Collection refreshListeners) {
      this.refreshListeners = (Collection)Preconditions.checkNotNull(refreshListeners);
      return this;
   }
}

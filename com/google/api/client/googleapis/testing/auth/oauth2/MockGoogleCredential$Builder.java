package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.Credential$Builder;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential$Builder;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport$Builder;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;

@Beta
public class MockGoogleCredential$Builder extends GoogleCredential$Builder {
   public MockGoogleCredential$Builder setTransport(HttpTransport transport) {
      return (MockGoogleCredential$Builder)super.setTransport(transport);
   }

   public MockGoogleCredential$Builder setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
      return (MockGoogleCredential$Builder)super.setClientAuthentication(clientAuthentication);
   }

   public MockGoogleCredential$Builder setJsonFactory(JsonFactory jsonFactory) {
      return (MockGoogleCredential$Builder)super.setJsonFactory(jsonFactory);
   }

   public MockGoogleCredential$Builder setClock(Clock clock) {
      return (MockGoogleCredential$Builder)super.setClock(clock);
   }

   public MockGoogleCredential build() {
      if (this.getTransport() == null) {
         this.setTransport((new MockHttpTransport$Builder()).build());
      }

      if (this.getClientAuthentication() == null) {
         this.setClientAuthentication(new MockGoogleCredential$MockClientAuthentication((MockGoogleCredential$1)null));
      }

      if (this.getJsonFactory() == null) {
         this.setJsonFactory(new JacksonFactory());
      }

      return new MockGoogleCredential(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GoogleCredential$Builder setClientAuthentication(HttpExecuteInterceptor var1) {
      return this.setClientAuthentication(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GoogleCredential$Builder setClock(Clock var1) {
      return this.setClock(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GoogleCredential$Builder setJsonFactory(JsonFactory var1) {
      return this.setJsonFactory(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GoogleCredential$Builder setTransport(HttpTransport var1) {
      return this.setTransport(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GoogleCredential build() {
      return this.build();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential$Builder setClientAuthentication(HttpExecuteInterceptor var1) {
      return this.setClientAuthentication(var1);
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

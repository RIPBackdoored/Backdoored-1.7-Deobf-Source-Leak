package com.google.api.client.googleapis.testing.services;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClient$Builder;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;

@Beta
public class MockGoogleClient$Builder extends AbstractGoogleClient$Builder {
   public MockGoogleClient$Builder(HttpTransport transport, String rootUrl, String servicePath, ObjectParser objectParser, HttpRequestInitializer httpRequestInitializer) {
      super(transport, rootUrl, servicePath, objectParser, httpRequestInitializer);
   }

   public MockGoogleClient build() {
      return new MockGoogleClient(this);
   }

   public MockGoogleClient$Builder setRootUrl(String rootUrl) {
      return (MockGoogleClient$Builder)super.setRootUrl(rootUrl);
   }

   public MockGoogleClient$Builder setServicePath(String servicePath) {
      return (MockGoogleClient$Builder)super.setServicePath(servicePath);
   }

   public MockGoogleClient$Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (MockGoogleClient$Builder)super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
   }

   public MockGoogleClient$Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      return (MockGoogleClient$Builder)super.setHttpRequestInitializer(httpRequestInitializer);
   }

   public MockGoogleClient$Builder setApplicationName(String applicationName) {
      return (MockGoogleClient$Builder)super.setApplicationName(applicationName);
   }

   public MockGoogleClient$Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (MockGoogleClient$Builder)super.setSuppressPatternChecks(suppressPatternChecks);
   }

   public MockGoogleClient$Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (MockGoogleClient$Builder)super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
   }

   public MockGoogleClient$Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (MockGoogleClient$Builder)super.setSuppressAllChecks(suppressAllChecks);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient$Builder setSuppressAllChecks(boolean var1) {
      return this.setSuppressAllChecks(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient$Builder setSuppressRequiredParameterChecks(boolean var1) {
      return this.setSuppressRequiredParameterChecks(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient$Builder setSuppressPatternChecks(boolean var1) {
      return this.setSuppressPatternChecks(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient$Builder setApplicationName(String var1) {
      return this.setApplicationName(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient$Builder setHttpRequestInitializer(HttpRequestInitializer var1) {
      return this.setHttpRequestInitializer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient$Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer var1) {
      return this.setGoogleClientRequestInitializer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient$Builder setServicePath(String var1) {
      return this.setServicePath(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient$Builder setRootUrl(String var1) {
      return this.setRootUrl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient build() {
      return this.build();
   }
}

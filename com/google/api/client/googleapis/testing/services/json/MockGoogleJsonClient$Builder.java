package com.google.api.client.googleapis.testing.services.json;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClient$Builder;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient$Builder;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;

@Beta
public class MockGoogleJsonClient$Builder extends AbstractGoogleJsonClient$Builder {
   public MockGoogleJsonClient$Builder(HttpTransport transport, JsonFactory jsonFactory, String rootUrl, String servicePath, HttpRequestInitializer httpRequestInitializer, boolean legacyDataWrapper) {
      super(transport, jsonFactory, rootUrl, servicePath, httpRequestInitializer, legacyDataWrapper);
   }

   public MockGoogleJsonClient build() {
      return new MockGoogleJsonClient(this);
   }

   public MockGoogleJsonClient$Builder setRootUrl(String rootUrl) {
      return (MockGoogleJsonClient$Builder)super.setRootUrl(rootUrl);
   }

   public MockGoogleJsonClient$Builder setServicePath(String servicePath) {
      return (MockGoogleJsonClient$Builder)super.setServicePath(servicePath);
   }

   public MockGoogleJsonClient$Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (MockGoogleJsonClient$Builder)super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
   }

   public MockGoogleJsonClient$Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      return (MockGoogleJsonClient$Builder)super.setHttpRequestInitializer(httpRequestInitializer);
   }

   public MockGoogleJsonClient$Builder setApplicationName(String applicationName) {
      return (MockGoogleJsonClient$Builder)super.setApplicationName(applicationName);
   }

   public MockGoogleJsonClient$Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (MockGoogleJsonClient$Builder)super.setSuppressPatternChecks(suppressPatternChecks);
   }

   public MockGoogleJsonClient$Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (MockGoogleJsonClient$Builder)super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
   }

   public MockGoogleJsonClient$Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (MockGoogleJsonClient$Builder)super.setSuppressAllChecks(suppressAllChecks);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient$Builder setSuppressAllChecks(boolean var1) {
      return this.setSuppressAllChecks(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient$Builder setSuppressRequiredParameterChecks(boolean var1) {
      return this.setSuppressRequiredParameterChecks(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient$Builder setSuppressPatternChecks(boolean var1) {
      return this.setSuppressPatternChecks(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient$Builder setApplicationName(String var1) {
      return this.setApplicationName(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient$Builder setHttpRequestInitializer(HttpRequestInitializer var1) {
      return this.setHttpRequestInitializer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient$Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer var1) {
      return this.setGoogleClientRequestInitializer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient$Builder setServicePath(String var1) {
      return this.setServicePath(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient$Builder setRootUrl(String var1) {
      return this.setRootUrl(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient build() {
      return this.build();
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

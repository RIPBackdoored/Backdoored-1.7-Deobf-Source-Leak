package com.google.api.client.googleapis.services;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;

public abstract class AbstractGoogleClient$Builder {
   final HttpTransport transport;
   GoogleClientRequestInitializer googleClientRequestInitializer;
   HttpRequestInitializer httpRequestInitializer;
   final ObjectParser objectParser;
   String rootUrl;
   String servicePath;
   String batchPath;
   String applicationName;
   boolean suppressPatternChecks;
   boolean suppressRequiredParameterChecks;

   protected AbstractGoogleClient$Builder(HttpTransport transport, String rootUrl, String servicePath, ObjectParser objectParser, HttpRequestInitializer httpRequestInitializer) {
      this.transport = (HttpTransport)Preconditions.checkNotNull(transport);
      this.objectParser = objectParser;
      this.setRootUrl(rootUrl);
      this.setServicePath(servicePath);
      this.httpRequestInitializer = httpRequestInitializer;
   }

   public abstract AbstractGoogleClient build();

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public ObjectParser getObjectParser() {
      return this.objectParser;
   }

   public final String getRootUrl() {
      return this.rootUrl;
   }

   public AbstractGoogleClient$Builder setRootUrl(String rootUrl) {
      this.rootUrl = AbstractGoogleClient.normalizeRootUrl(rootUrl);
      return this;
   }

   public final String getServicePath() {
      return this.servicePath;
   }

   public AbstractGoogleClient$Builder setServicePath(String servicePath) {
      this.servicePath = AbstractGoogleClient.normalizeServicePath(servicePath);
      return this;
   }

   public AbstractGoogleClient$Builder setBatchPath(String batchPath) {
      this.batchPath = batchPath;
      return this;
   }

   public final GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
      return this.googleClientRequestInitializer;
   }

   public AbstractGoogleClient$Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
      this.googleClientRequestInitializer = googleClientRequestInitializer;
      return this;
   }

   public final HttpRequestInitializer getHttpRequestInitializer() {
      return this.httpRequestInitializer;
   }

   public AbstractGoogleClient$Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      this.httpRequestInitializer = httpRequestInitializer;
      return this;
   }

   public final String getApplicationName() {
      return this.applicationName;
   }

   public AbstractGoogleClient$Builder setApplicationName(String applicationName) {
      this.applicationName = applicationName;
      return this;
   }

   public final boolean getSuppressPatternChecks() {
      return this.suppressPatternChecks;
   }

   public AbstractGoogleClient$Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      this.suppressPatternChecks = suppressPatternChecks;
      return this;
   }

   public final boolean getSuppressRequiredParameterChecks() {
      return this.suppressRequiredParameterChecks;
   }

   public AbstractGoogleClient$Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      this.suppressRequiredParameterChecks = suppressRequiredParameterChecks;
      return this;
   }

   public AbstractGoogleClient$Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return this.setSuppressPatternChecks(true).setSuppressRequiredParameterChecks(true);
   }
}

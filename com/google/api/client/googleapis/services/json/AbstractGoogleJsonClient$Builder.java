package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClient$Builder;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.JsonObjectParser$Builder;
import com.google.api.client.util.ObjectParser;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public abstract class AbstractGoogleJsonClient$Builder extends AbstractGoogleClient$Builder {
   protected AbstractGoogleJsonClient$Builder(HttpTransport transport, JsonFactory jsonFactory, String rootUrl, String servicePath, HttpRequestInitializer httpRequestInitializer, boolean legacyDataWrapper) {
      super(transport, rootUrl, servicePath, (new JsonObjectParser$Builder(jsonFactory)).setWrapperKeys((Collection)(legacyDataWrapper ? Arrays.asList("data", "error") : Collections.emptySet())).build(), httpRequestInitializer);
   }

   public final JsonObjectParser getObjectParser() {
      return (JsonObjectParser)super.getObjectParser();
   }

   public final JsonFactory getJsonFactory() {
      return this.getObjectParser().getJsonFactory();
   }

   public abstract AbstractGoogleJsonClient build();

   public AbstractGoogleJsonClient$Builder setRootUrl(String rootUrl) {
      return (AbstractGoogleJsonClient$Builder)super.setRootUrl(rootUrl);
   }

   public AbstractGoogleJsonClient$Builder setServicePath(String servicePath) {
      return (AbstractGoogleJsonClient$Builder)super.setServicePath(servicePath);
   }

   public AbstractGoogleJsonClient$Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (AbstractGoogleJsonClient$Builder)super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
   }

   public AbstractGoogleJsonClient$Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      return (AbstractGoogleJsonClient$Builder)super.setHttpRequestInitializer(httpRequestInitializer);
   }

   public AbstractGoogleJsonClient$Builder setApplicationName(String applicationName) {
      return (AbstractGoogleJsonClient$Builder)super.setApplicationName(applicationName);
   }

   public AbstractGoogleJsonClient$Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (AbstractGoogleJsonClient$Builder)super.setSuppressPatternChecks(suppressPatternChecks);
   }

   public AbstractGoogleJsonClient$Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (AbstractGoogleJsonClient$Builder)super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
   }

   public AbstractGoogleJsonClient$Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (AbstractGoogleJsonClient$Builder)super.setSuppressAllChecks(suppressAllChecks);
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
   public ObjectParser getObjectParser() {
      return this.getObjectParser();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient build() {
      return this.build();
   }
}

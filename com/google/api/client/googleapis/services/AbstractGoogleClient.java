package com.google.api.client.googleapis.services;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Strings;
import java.io.IOException;
import java.util.logging.Logger;

public abstract class AbstractGoogleClient {
   static final Logger logger = Logger.getLogger(AbstractGoogleClient.class.getName());
   private final HttpRequestFactory requestFactory;
   private final GoogleClientRequestInitializer googleClientRequestInitializer;
   private final String rootUrl;
   private final String servicePath;
   private final String batchPath;
   private final String applicationName;
   private final ObjectParser objectParser;
   private final boolean suppressPatternChecks;
   private final boolean suppressRequiredParameterChecks;

   protected AbstractGoogleClient(AbstractGoogleClient$Builder builder) {
      this.googleClientRequestInitializer = builder.googleClientRequestInitializer;
      this.rootUrl = normalizeRootUrl(builder.rootUrl);
      this.servicePath = normalizeServicePath(builder.servicePath);
      this.batchPath = builder.batchPath;
      if (Strings.isNullOrEmpty(builder.applicationName)) {
         logger.warning("Application name is not set. Call Builder#setApplicationName.");
      }

      this.applicationName = builder.applicationName;
      this.requestFactory = builder.httpRequestInitializer == null ? builder.transport.createRequestFactory() : builder.transport.createRequestFactory(builder.httpRequestInitializer);
      this.objectParser = builder.objectParser;
      this.suppressPatternChecks = builder.suppressPatternChecks;
      this.suppressRequiredParameterChecks = builder.suppressRequiredParameterChecks;
   }

   public final String getRootUrl() {
      return this.rootUrl;
   }

   public final String getServicePath() {
      return this.servicePath;
   }

   public final String getBaseUrl() {
      String var10000 = String.valueOf(this.rootUrl);
      String var10001 = String.valueOf(this.servicePath);
      if (var10001.length() != 0) {
         var10000 = var10000.concat(var10001);
      } else {
         String var10002 = new String;
         var10001 = var10000;
         var10000 = var10002;
         var10002.<init>(var10001);
      }

      return var10000;
   }

   public final String getApplicationName() {
      return this.applicationName;
   }

   public final HttpRequestFactory getRequestFactory() {
      return this.requestFactory;
   }

   public final GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
      return this.googleClientRequestInitializer;
   }

   public ObjectParser getObjectParser() {
      return this.objectParser;
   }

   protected void initialize(AbstractGoogleClientRequest httpClientRequest) throws IOException {
      if (this.getGoogleClientRequestInitializer() != null) {
         this.getGoogleClientRequestInitializer().initialize(httpClientRequest);
      }

   }

   public final BatchRequest batch() {
      return this.batch((HttpRequestInitializer)null);
   }

   public final BatchRequest batch(HttpRequestInitializer httpRequestInitializer) {
      BatchRequest batch = new BatchRequest(this.getRequestFactory().getTransport(), httpRequestInitializer);
      GenericUrl var10001 = new GenericUrl;
      String var10003 = String.valueOf(this.getRootUrl());
      String var10004 = String.valueOf(this.batchPath);
      if (var10004.length() != 0) {
         var10003 = var10003.concat(var10004);
      } else {
         String var10005 = new String;
         var10004 = var10003;
         var10003 = var10005;
         var10005.<init>(var10004);
      }

      var10001.<init>(var10003);
      batch.setBatchUrl(var10001);
      return batch;
   }

   public final boolean getSuppressPatternChecks() {
      return this.suppressPatternChecks;
   }

   public final boolean getSuppressRequiredParameterChecks() {
      return this.suppressRequiredParameterChecks;
   }

   static String normalizeRootUrl(String rootUrl) {
      Preconditions.checkNotNull(rootUrl, "root URL cannot be null.");
      if (!rootUrl.endsWith("/")) {
         rootUrl = String.valueOf(rootUrl).concat("/");
      }

      return rootUrl;
   }

   static String normalizeServicePath(String servicePath) {
      Preconditions.checkNotNull(servicePath, "service path cannot be null");
      if (servicePath.length() == 1) {
         Preconditions.checkArgument("/".equals(servicePath), "service path must equal \"/\" if it is of length 1.");
         servicePath = "";
      } else if (servicePath.length() > 0) {
         if (!servicePath.endsWith("/")) {
            servicePath = String.valueOf(servicePath).concat("/");
         }

         if (servicePath.startsWith("/")) {
            servicePath = servicePath.substring(1);
         }
      }

      return servicePath;
   }
}

package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClient$Builder;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient$Builder;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

public final class Sheets$Builder extends AbstractGoogleJsonClient$Builder {
   public Sheets$Builder(HttpTransport var1, JsonFactory var2, HttpRequestInitializer var3) {
      super(var1, var2, "https://sheets.googleapis.com/", "", var3, false);
      this.setBatchPath("batch");
   }

   public Sheets build() {
      return new Sheets(this);
   }

   public Sheets$Builder setRootUrl(String var1) {
      return (Sheets$Builder)super.setRootUrl(var1);
   }

   public Sheets$Builder setServicePath(String var1) {
      return (Sheets$Builder)super.setServicePath(var1);
   }

   public Sheets$Builder setBatchPath(String var1) {
      return (Sheets$Builder)super.setBatchPath(var1);
   }

   public Sheets$Builder setHttpRequestInitializer(HttpRequestInitializer var1) {
      return (Sheets$Builder)super.setHttpRequestInitializer(var1);
   }

   public Sheets$Builder setApplicationName(String var1) {
      return (Sheets$Builder)super.setApplicationName(var1);
   }

   public Sheets$Builder setSuppressPatternChecks(boolean var1) {
      return (Sheets$Builder)super.setSuppressPatternChecks(var1);
   }

   public Sheets$Builder setSuppressRequiredParameterChecks(boolean var1) {
      return (Sheets$Builder)super.setSuppressRequiredParameterChecks(var1);
   }

   public Sheets$Builder setSuppressAllChecks(boolean var1) {
      return (Sheets$Builder)super.setSuppressAllChecks(var1);
   }

   public Sheets$Builder setSheetsRequestInitializer(SheetsRequestInitializer var1) {
      return (Sheets$Builder)super.setGoogleClientRequestInitializer(var1);
   }

   public Sheets$Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer var1) {
      return (Sheets$Builder)super.setGoogleClientRequestInitializer(var1);
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
   public AbstractGoogleClient$Builder setBatchPath(String var1) {
      return this.setBatchPath(var1);
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

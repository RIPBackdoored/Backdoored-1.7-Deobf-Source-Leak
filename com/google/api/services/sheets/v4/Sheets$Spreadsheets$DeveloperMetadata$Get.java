package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.DeveloperMetadata;
import java.io.IOException;

public class Sheets$Spreadsheets$DeveloperMetadata$Get extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}/developerMetadata/{metadataId}";
   @Key
   private String spreadsheetId;
   @Key
   private Integer metadataId;
   // $FF: synthetic field
   final Sheets$Spreadsheets$DeveloperMetadata this$2;

   protected Sheets$Spreadsheets$DeveloperMetadata$Get(Sheets$Spreadsheets$DeveloperMetadata var1, String var2, Integer var3) {
      super(var1.this$1.this$0, "GET", "v4/spreadsheets/{spreadsheetId}/developerMetadata/{metadataId}", (Object)null, DeveloperMetadata.class);
      this.this$2 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
      this.metadataId = (Integer)Preconditions.checkNotNull(var3, "Required parameter metadataId must be specified.");
   }

   public HttpResponse executeUsingHead() throws IOException {
      return super.executeUsingHead();
   }

   public HttpRequest buildHttpRequestUsingHead() throws IOException {
      return super.buildHttpRequestUsingHead();
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setAccessToken(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setAlt(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setCallback(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setFields(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.setFields(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setKey(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.setKey(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setOauthToken(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setUploadType(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public Integer getMetadataId() {
      return this.metadataId;
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get setMetadataId(Integer var1) {
      this.metadataId = var1;
      return this;
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Get set(String var1, Object var2) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Get)super.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setUploadProtocol(String var1) {
      return this.setUploadProtocol(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setUploadType(String var1) {
      return this.setUploadType(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setQuotaUser(String var1) {
      return this.setQuotaUser(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setPrettyPrint(Boolean var1) {
      return this.setPrettyPrint(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setOauthToken(String var1) {
      return this.setOauthToken(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setKey(String var1) {
      return this.setKey(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setFields(String var1) {
      return this.setFields(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setCallback(String var1) {
      return this.setCallback(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setAlt(String var1) {
      return this.setAlt(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest setAccessToken(String var1) {
      return this.setAccessToken(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public SheetsRequest set$Xgafv(String var1) {
      return this.set$Xgafv(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClientRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }
}

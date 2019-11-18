package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.SearchDeveloperMetadataRequest;
import com.google.api.services.sheets.v4.model.SearchDeveloperMetadataResponse;

public class Sheets$Spreadsheets$DeveloperMetadata$Search extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}/developerMetadata:search";
   @Key
   private String spreadsheetId;
   // $FF: synthetic field
   final Sheets$Spreadsheets$DeveloperMetadata this$2;

   protected Sheets$Spreadsheets$DeveloperMetadata$Search(Sheets$Spreadsheets$DeveloperMetadata var1, String var2, SearchDeveloperMetadataRequest var3) {
      super(var1.this$1.this$0, "POST", "v4/spreadsheets/{spreadsheetId}/developerMetadata:search", var3, SearchDeveloperMetadataResponse.class);
      this.this$2 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setAccessToken(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setAlt(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setCallback(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setFields(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.setFields(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setKey(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.setKey(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setOauthToken(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setUploadType(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public Sheets$Spreadsheets$DeveloperMetadata$Search set(String var1, Object var2) {
      return (Sheets$Spreadsheets$DeveloperMetadata$Search)super.set(var1, var2);
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

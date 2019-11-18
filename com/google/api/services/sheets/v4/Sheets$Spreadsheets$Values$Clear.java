package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.sheets.v4.model.ClearValuesRequest;
import com.google.api.services.sheets.v4.model.ClearValuesResponse;

public class Sheets$Spreadsheets$Values$Clear extends SheetsRequest {
   private static final String REST_PATH = "v4/spreadsheets/{spreadsheetId}/values/{range}:clear";
   @Key
   private String spreadsheetId;
   @Key
   private String range;
   // $FF: synthetic field
   final Sheets$Spreadsheets$Values this$2;

   protected Sheets$Spreadsheets$Values$Clear(Sheets$Spreadsheets$Values var1, String var2, String var3, ClearValuesRequest var4) {
      super(var1.this$1.this$0, "POST", "v4/spreadsheets/{spreadsheetId}/values/{range}:clear", var4, ClearValuesResponse.class);
      this.this$2 = var1;
      this.spreadsheetId = (String)Preconditions.checkNotNull(var2, "Required parameter spreadsheetId must be specified.");
      this.range = (String)Preconditions.checkNotNull(var3, "Required parameter range must be specified.");
   }

   public Sheets$Spreadsheets$Values$Clear set$Xgafv(String var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.set$Xgafv(var1);
   }

   public Sheets$Spreadsheets$Values$Clear setAccessToken(String var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.setAccessToken(var1);
   }

   public Sheets$Spreadsheets$Values$Clear setAlt(String var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.setAlt(var1);
   }

   public Sheets$Spreadsheets$Values$Clear setCallback(String var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.setCallback(var1);
   }

   public Sheets$Spreadsheets$Values$Clear setFields(String var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.setFields(var1);
   }

   public Sheets$Spreadsheets$Values$Clear setKey(String var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.setKey(var1);
   }

   public Sheets$Spreadsheets$Values$Clear setOauthToken(String var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.setOauthToken(var1);
   }

   public Sheets$Spreadsheets$Values$Clear setPrettyPrint(Boolean var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.setPrettyPrint(var1);
   }

   public Sheets$Spreadsheets$Values$Clear setQuotaUser(String var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.setQuotaUser(var1);
   }

   public Sheets$Spreadsheets$Values$Clear setUploadType(String var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.setUploadType(var1);
   }

   public Sheets$Spreadsheets$Values$Clear setUploadProtocol(String var1) {
      return (Sheets$Spreadsheets$Values$Clear)super.setUploadProtocol(var1);
   }

   public String getSpreadsheetId() {
      return this.spreadsheetId;
   }

   public Sheets$Spreadsheets$Values$Clear setSpreadsheetId(String var1) {
      this.spreadsheetId = var1;
      return this;
   }

   public String getRange() {
      return this.range;
   }

   public Sheets$Spreadsheets$Values$Clear setRange(String var1) {
      this.range = var1;
      return this;
   }

   public Sheets$Spreadsheets$Values$Clear set(String var1, Object var2) {
      return (Sheets$Spreadsheets$Values$Clear)super.set(var1, var2);
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
